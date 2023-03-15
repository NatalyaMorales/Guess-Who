package examen2;
import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class MainPersona {
    public static void main (String[] args)  throws IOException {
    
    Scanner sc = new Scanner(System.in); 
    Random random = new Random();
    //String consume = sc.next();
    
    Estudiante1[] estudiantes = new Estudiante1[10]; 
    int contMexicano=0;
    int contMayor18=0;
    int contViveMex=0;
    int contManejar=0;
    
    
    //User
    int wins=0, games=0;
    System.out.println("Ingresa tu usuario:");
    String user=sc.next();
     
    //Archivos
    File file = new File("D:/Amigu/Universidad/AdivinaQuien", user + ".txt");
    if (file.exists()) {
        BufferedReader BR = new BufferedReader(new FileReader(file));
		games=Integer.parseInt(BR.readLine());
		wins=Integer.parseInt(BR.readLine());
		BR.close();
        System.out.println("Bienvenido de nuevo " + user);
        System.out.println("Total de juegos: " + games + "\nTotal de partidas ganadas: " + wins);
    } else {
        file.createNewFile();
        System.out.println("Bienvenido "+ user);
    }
   
    //file = new File(user);

    //Inicio del juego
    games++;

    System.out.println("\nJuguemos Adivina quién...\n\nLas personas generadas son: \n");
    String[] nombres = {"Jose", "Carlos", "Carla", "Josefina", "Natalya", "Patricia", "Natalio", "Patricio", "Benito", "Benita"};
    
    int[] randoms = new int[10];

    System.out.println("Nombre / Es Mexicano / Es Mayor 18 / Vive Mexico / Sabe Manejar");

    for (int i=0; i < 10; i++) {
        randoms[i] = random.nextInt(10);
        for (int j=0;j<i;j++){
            if (randoms[i]==randoms[j]){
                i--;
            }
        }
    }

    do {
    for(int i=0; i < estudiantes.length; i++) {
        String nombre = nombres[i];
        boolean esMexicano = random.nextBoolean();
        boolean esMayor18 = random.nextBoolean();
        boolean viveMexico = random.nextBoolean();
        boolean sabeManejar = random.nextBoolean();  

        estudiantes[i] = new Estudiante1(nombre, esMexicano,esMayor18,viveMexico,sabeManejar);
        //Comprobar que todas las personas sean diferentes
        for(int j=0; j < i; j++) {
                if (estudiantes[i].esMexicano == estudiantes[j].esMexicano && estudiantes[i].esMayor18 == estudiantes[j].esMayor18 && estudiantes[i].viveMexico == estudiantes[j].viveMexico && estudiantes[i].sabeManejar == estudiantes[j].sabeManejar){
                    esMexicano = random.nextBoolean();
                    esMayor18 = random.nextBoolean();
                    viveMexico = random.nextBoolean();
                    sabeManejar = random.nextBoolean();
                    estudiantes[i] = new Estudiante1(nombre, esMexicano,esMayor18,viveMexico,sabeManejar);
                    j=-1;
                } 
            }

        if (esMexicano) contMexicano++;
        if (esMayor18) contMayor18++;
        if (viveMexico) contViveMex++;
        if (sabeManejar) contManejar++;
    }    
    } while (contMexicano < 2 || contMayor18 < 2 || contViveMex < 2 || contManejar < 2); //Revisa si todos los atributos son verdaderos al menos 2 veces

    for (Estudiante1 estu : estudiantes) {
        System.out.println(estu.getName() +" / "+ estu.esMexicano +" / "+ estu.esMayor18+" / "+ estu.viveMexico+" / "+ estu.sabeManejar);
    }

    System.out.println("\nContador es Mexicano = true: "+contMexicano);
    System.out.println("Contador es Mayor 18 = true: "+contMayor18);
    System.out.println("Contador vive en Mexico = true: "+contViveMex);
    System.out.println("Contador sabe Manejar = true: "+contManejar);  

    //Preguntas
    String[] preguntas = {"1. Su personaje es mexicano?","2. Su personaje es mayor de 18?", "3. Su personaje vive en Mexico?", "4. Su personaje sabe manejar?"};
    int randPersona = random.nextInt(10);
    System.out.println("\nRealiza 3 preguntas y adivina la persona seleccionada");
    for (int i=0; i<preguntas.length;i++) {
        System.out.println(preguntas[i]);
    }
    
    System.out.println("Inserte el numero de la primera pregunta a realizar: ");
    int pregunta1=sc.nextInt();

    switch (pregunta1){
        case 1:
        Preguntas.atributo(estudiantes[randPersona].esMexicano());
        for (int i=0; i<estudiantes.length;i++){
            if (estudiantes[randPersona].esMexicano() == estudiantes[i].esMexicano()) {
                System.out.println(estudiantes[i].getName());
            } else {
                continue;
            }
        }
        Preguntas.preguntas3(preguntas, pregunta1);
        System.out.println("Inserte el numero de la segunda pregunta a realizar: ");
        int pregunta2=sc.nextInt();
        switch (pregunta2) {
            case 2:
            Preguntas.atributo(estudiantes[randPersona].esMayor18());
            for (int i=0; i<estudiantes.length;i++){
                if (estudiantes[randPersona].esMexicano() == estudiantes[i].esMexicano() && estudiantes[randPersona].esMayor18() == estudiantes[i].esMayor18()) {
                    System.out.println(estudiantes[i].getName());
                } else {
                    continue;
                }
            }
            Preguntas.preguntas2(preguntas, pregunta1, pregunta2);
            System.out.println("Inserte el numero de la tercera pregunta a realizar: ");
            int pregunta3=sc.nextInt();
            switch (pregunta3) {
                case 3:
                Preguntas.atributo(estudiantes[randPersona].viveMexico());
                for (int i=0; i<estudiantes.length;i++){
                    if (estudiantes[randPersona].esMexicano() == estudiantes[i].esMexicano() && estudiantes[randPersona].esMayor18() == estudiantes[i].esMayor18() && estudiantes[randPersona].viveMexico() == estudiantes[i].viveMexico()) {
                        System.out.println(estudiantes[i].getName());
                    } else {
                        continue;
                    }
                }
                break;

                case 4:
                Preguntas.atributo(estudiantes[randPersona].sabeManejar());
                for (int i=0; i<estudiantes.length;i++){
                    if (estudiantes[randPersona].esMexicano() == estudiantes[i].esMexicano() && estudiantes[randPersona].esMayor18() == estudiantes[i].esMayor18() && estudiantes[randPersona].sabeManejar() == estudiantes[i].sabeManejar()) {
                        System.out.println(estudiantes[i].getName());
                    } else {
                        continue;
                    }
                }
                break;
            
            }
            break;
            case 3:
            Preguntas.atributo(estudiantes[randPersona].viveMexico());
            for (int i=0; i<estudiantes.length;i++){
                if (estudiantes[randPersona].esMexicano() == estudiantes[i].esMexicano() && estudiantes[randPersona].viveMexico() == estudiantes[i].viveMexico()) {
                    System.out.println(estudiantes[i].getName());
                } else {
                    continue;
                }
            }
            Preguntas.preguntas2(preguntas, pregunta1, pregunta2);
            System.out.println("Inserte el numero de la tercera pregunta a realizar: ");
            pregunta3=sc.nextInt();
            switch (pregunta3) {
                case 2:
                Preguntas.atributo(estudiantes[randPersona].esMayor18());
                for (int i=0; i<estudiantes.length;i++){
                    if (estudiantes[randPersona].esMexicano() == estudiantes[i].esMexicano() && estudiantes[randPersona].esMayor18() == estudiantes[i].esMayor18() && estudiantes[randPersona].viveMexico() == estudiantes[i].viveMexico()) {
                        System.out.println(estudiantes[i].getName());
                    } else {
                        continue;
                    }
                }
                    break;
                case 4:
                Preguntas.atributo(estudiantes[randPersona].sabeManejar());
                for (int i=0; i<estudiantes.length;i++){
                    if (estudiantes[randPersona].esMexicano() == estudiantes[i].esMexicano() && estudiantes[randPersona].viveMexico() == estudiantes[i].viveMexico() && estudiantes[randPersona].sabeManejar() == estudiantes[i].sabeManejar()) {
                        System.out.println(estudiantes[i].getName());
                    } else {
                        continue;
                    }
                }
                break;
            }
            break;
            case 4:
            Preguntas.atributo(estudiantes[randPersona].sabeManejar());
            for (int i=0; i<estudiantes.length;i++){
                if (estudiantes[randPersona].esMexicano() == estudiantes[i].esMexicano() && estudiantes[randPersona].sabeManejar() == estudiantes[i].sabeManejar()) {
                    System.out.println(estudiantes[i].getName());
                } else {
                    continue;
                }
            }
            Preguntas.preguntas2(preguntas, pregunta1, pregunta2);
            System.out.println("Inserte el numero de la tercera pregunta a realizar: ");
            pregunta3=sc.nextInt();
            switch (pregunta3) {
                case 2:
                    Preguntas.atributo(estudiantes[randPersona].esMayor18());
                for (int i=0; i<estudiantes.length;i++){
                    if (estudiantes[randPersona].esMexicano() == estudiantes[i].esMexicano() && estudiantes[randPersona].esMayor18() == estudiantes[i].esMayor18() && estudiantes[randPersona].sabeManejar() == estudiantes[i].sabeManejar()) {
                        System.out.println(estudiantes[i].getName());
                    } else {
                        continue;
                    }
                }
                    break;
                case 3:
                Preguntas.atributo(estudiantes[randPersona].viveMexico());
                for (int i=0; i<estudiantes.length;i++){
                    if (estudiantes[randPersona].esMexicano() == estudiantes[i].esMexicano() && estudiantes[randPersona].viveMexico() == estudiantes[i].viveMexico() && estudiantes[randPersona].sabeManejar() == estudiantes[i].sabeManejar()) {
                        System.out.println(estudiantes[i].getName());
                    } else {
                        continue;
                    }
                }
                break;
            }
            break;
        }
        break;
        case 2:
        Preguntas.atributo(estudiantes[randPersona].esMayor18());
        for (int i=0; i<estudiantes.length;i++){
            if (estudiantes[randPersona].esMayor18() == estudiantes[i].esMayor18()) {
                System.out.println(estudiantes[i].getName());
            } else {
                continue;
            }
        }
        Preguntas.preguntas3(preguntas, pregunta1);
        System.out.println("Inserte el numero de la segunda pregunta a realizar: ");
        pregunta2=sc.nextInt();
        switch (pregunta2) {
            case 1:
            Preguntas.atributo(estudiantes[randPersona].esMexicano());
            for (int i=0; i<estudiantes.length;i++){
                if (estudiantes[randPersona].esMexicano() == estudiantes[i].esMexicano() && estudiantes[randPersona].esMayor18() == estudiantes[i].esMayor18()) {
                    System.out.println(estudiantes[i].getName());
                } else {
                    continue;
                }
            }
            Preguntas.preguntas2(preguntas, pregunta1, pregunta2);
            System.out.println("Inserte el numero de la tercera pregunta a realizar: ");
            int pregunta3=sc.nextInt();
            switch (pregunta3) {
                case 3:
                Preguntas.atributo(estudiantes[randPersona].viveMexico());
                for (int i=0; i<estudiantes.length;i++){
                    if (estudiantes[randPersona].viveMexico() == estudiantes[i].viveMexico() && estudiantes[randPersona].esMayor18() == estudiantes[i].esMayor18() && estudiantes[randPersona].esMexicano() == estudiantes[i].esMexicano()) {
                        System.out.println(estudiantes[i].getName());
                    } else {
                        continue;
                    }
                }
                break;

                case 4:
                Preguntas.atributo(estudiantes[randPersona].sabeManejar());
                for (int i=0; i<estudiantes.length;i++){
                    if (estudiantes[randPersona].esMexicano() == estudiantes[i].esMexicano() && estudiantes[randPersona].esMayor18() == estudiantes[i].esMayor18() && estudiantes[randPersona].sabeManejar() == estudiantes[i].sabeManejar()) {
                        System.out.println(estudiantes[i].getName());
                    } else {
                        continue;
                    }
                }
                break;
            
            }
            break;
            case 3:
            Preguntas.atributo(estudiantes[randPersona].viveMexico());
            for (int i=0; i<estudiantes.length;i++){
                if (estudiantes[randPersona].esMayor18() == estudiantes[i].esMayor18() && estudiantes[randPersona].viveMexico() == estudiantes[i].viveMexico()) {
                    System.out.println(estudiantes[i].getName());
                } else {
                    continue;
                }
            }
            Preguntas.preguntas2(preguntas, pregunta1, pregunta2);
            System.out.println("Inserte el numero de la ultima pregunta a realizar: ");
            pregunta3=sc.nextInt();
            switch (pregunta3) {
                case 1:
                Preguntas.atributo(estudiantes[randPersona].esMexicano());
                for (int i=0; i<estudiantes.length;i++){
                    if (estudiantes[randPersona].esMexicano() == estudiantes[i].esMexicano() && estudiantes[randPersona].esMayor18() == estudiantes[i].esMayor18() && estudiantes[randPersona].viveMexico() == estudiantes[i].viveMexico()) {
                        System.out.println(estudiantes[i].getName());
                    } else {
                        continue;
                    }
                }
                    break;
                case 4:
                Preguntas.atributo(estudiantes[randPersona].sabeManejar());
                for (int i=0; i<estudiantes.length;i++){
                    if (estudiantes[randPersona].esMayor18() == estudiantes[i].esMayor18() && estudiantes[randPersona].viveMexico() == estudiantes[i].viveMexico() && estudiantes[randPersona].sabeManejar() == estudiantes[i].sabeManejar()) {
                        System.out.println(estudiantes[i].getName());
                    } else {
                        continue;
                    }
                }
                break;
            }
            break;
            case 4:
            Preguntas.atributo(estudiantes[randPersona].sabeManejar());
            for (int i=0; i<estudiantes.length;i++){
                if (estudiantes[randPersona].esMayor18() == estudiantes[i].esMayor18() && estudiantes[randPersona].sabeManejar() == estudiantes[i].sabeManejar()) {
                    System.out.println(estudiantes[i].getName());
                } else {
                    continue;
                }
            }
            Preguntas.preguntas2(preguntas, pregunta1, pregunta2);
            System.out.println("Inserte el numero de la ultima pregunta a realizar: ");
            pregunta3=sc.nextInt();
            switch (pregunta3) {
                case 1:
                    Preguntas.atributo(estudiantes[randPersona].esMexicano());
                for (int i=0; i<estudiantes.length;i++){
                    if (estudiantes[randPersona].esMexicano() == estudiantes[i].esMexicano() && estudiantes[randPersona].esMayor18() == estudiantes[i].esMayor18() && estudiantes[randPersona].sabeManejar() == estudiantes[i].sabeManejar()) {
                        System.out.println(estudiantes[i].getName());
                    } else {
                        continue;
                    }
                }
                    break;
                case 3:
                Preguntas.atributo(estudiantes[randPersona].viveMexico());
                for (int i=0; i<estudiantes.length;i++){
                    if (estudiantes[randPersona].esMayor18() == estudiantes[i].esMayor18() && estudiantes[randPersona].viveMexico() == estudiantes[i].viveMexico() && estudiantes[randPersona].sabeManejar() == estudiantes[i].sabeManejar()) {
                        System.out.println(estudiantes[i].getName());
                    } else {
                        continue;
                    }
                }
                break;
            }
            break;
        }
        break;
        case 3:
        Preguntas.atributo(estudiantes[randPersona].viveMexico());
        for (int i=0; i<estudiantes.length;i++){
            if (estudiantes[randPersona].viveMexico() == estudiantes[i].viveMexico()) {
                System.out.println(estudiantes[i].getName());
            } else {
                continue;
            }
        }
        Preguntas.preguntas3(preguntas, pregunta1);
        System.out.println("Inserte el numero de la segunda pregunta a realizar: ");
        pregunta2=sc.nextInt();
        switch (pregunta2) {
            case 1:
            Preguntas.atributo(estudiantes[randPersona].esMexicano());
            for (int i=0; i<estudiantes.length;i++){
                if (estudiantes[randPersona].viveMexico() == estudiantes[i].viveMexico() && estudiantes[randPersona].esMexicano() == estudiantes[i].esMexicano()) {
                    System.out.println(estudiantes[i].getName());
                } else {
                    continue;
                }
            }
            Preguntas.preguntas2(preguntas, pregunta1, pregunta2);
            System.out.println("Inserte el numero de la tercera pregunta a realizar: ");
            int pregunta3=sc.nextInt();
            switch (pregunta3) {
                case 2:
                Preguntas.atributo(estudiantes[randPersona].esMayor18());
                for (int i=0; i<estudiantes.length;i++){
                    if (estudiantes[randPersona].viveMexico() == estudiantes[i].viveMexico() && estudiantes[randPersona].esMexicano() == estudiantes[i].esMexicano() && estudiantes[randPersona].esMayor18() == estudiantes[i].esMayor18()) {
                        System.out.println(estudiantes[i].getName());
                    } else {
                        continue;
                    }
                }
                break;

                case 4:
                Preguntas.atributo(estudiantes[randPersona].sabeManejar());
                for (int i=0; i<estudiantes.length;i++){
                    if (estudiantes[randPersona].viveMexico() == estudiantes[i].viveMexico() && estudiantes[randPersona].esMexicano() == estudiantes[i].esMexicano() && estudiantes[randPersona].sabeManejar() == estudiantes[i].sabeManejar()) {
                        System.out.println(estudiantes[i].getName());
                    } else {
                        continue;
                    }
                }
                break;
            
            }
            break;
            case 2:
            Preguntas.atributo(estudiantes[randPersona].esMayor18());
            for (int i=0; i<estudiantes.length;i++){
                if (estudiantes[randPersona].viveMexico() == estudiantes[i].viveMexico() && estudiantes[randPersona].esMayor18() == estudiantes[i].esMayor18()) {
                    System.out.println(estudiantes[i].getName());
                } else {
                    continue;
                }
            }
            Preguntas.preguntas2(preguntas, pregunta1, pregunta2);
            System.out.println("Inserte el numero de la tercera pregunta a realizar: ");
            pregunta3=sc.nextInt();
            switch (pregunta3) {
                case 1:
                Preguntas.atributo(estudiantes[randPersona].esMexicano());
                for (int i=0; i<estudiantes.length;i++){
                    if (estudiantes[randPersona].viveMexico() == estudiantes[i].viveMexico() && estudiantes[randPersona].esMayor18() == estudiantes[i].esMayor18() && estudiantes[randPersona].esMexicano() == estudiantes[i].esMexicano()) {
                        System.out.println(estudiantes[i].getName());
                    } else {
                        continue;
                    }
                }
                    break;
                case 4:
                Preguntas.atributo(estudiantes[randPersona].sabeManejar());
                for (int i=0; i<estudiantes.length;i++){
                    if (estudiantes[randPersona].viveMexico() == estudiantes[i].viveMexico() && estudiantes[randPersona].esMayor18() == estudiantes[i].esMayor18() && estudiantes[randPersona].sabeManejar() == estudiantes[i].sabeManejar()) {
                        System.out.println(estudiantes[i].getName());
                    } else {
                        continue;
                    }
                }
                break;
            }
            break;
            case 4:
            Preguntas.atributo(estudiantes[randPersona].sabeManejar());
            for (int i=0; i<estudiantes.length;i++){
                if (estudiantes[randPersona].viveMexico() == estudiantes[i].viveMexico() && estudiantes[randPersona].sabeManejar() == estudiantes[i].sabeManejar()) {
                    System.out.println(estudiantes[i].getName());
                } else {
                    continue;
                }
            }
            Preguntas.preguntas2(preguntas, pregunta1, pregunta2);
            System.out.println("Inserte el numero de la tercera pregunta a realizar: ");
            pregunta3=sc.nextInt();
            switch (pregunta3) {
                case 1:
                    Preguntas.atributo(estudiantes[randPersona].esMayor18());
                for (int i=0; i<estudiantes.length;i++){
                    if (estudiantes[randPersona].viveMexico() == estudiantes[i].viveMexico() && estudiantes[randPersona].sabeManejar() == estudiantes[i].sabeManejar() && estudiantes[randPersona].esMexicano() == estudiantes[i].esMexicano()) {
                        System.out.println(estudiantes[i].getName());
                    } else {
                        continue;
                    }
                }
                    break;
                case 2:
                Preguntas.atributo(estudiantes[randPersona].esMayor18());
                for (int i=0; i<estudiantes.length;i++){
                    if (estudiantes[randPersona].viveMexico() == estudiantes[i].viveMexico() && estudiantes[randPersona].sabeManejar() == estudiantes[i].sabeManejar() && estudiantes[randPersona].esMayor18() == estudiantes[i].esMayor18()) {
                        System.out.println(estudiantes[i].getName());
                    } else {
                        continue;
                    }
                }
                break;
            }
            break;
        }
        break;
        case 4:
        Preguntas.atributo(estudiantes[randPersona].sabeManejar());
        for (int i=0; i<estudiantes.length;i++){
            if (estudiantes[randPersona].sabeManejar() == estudiantes[i].sabeManejar()) {
                System.out.println(estudiantes[i].getName());
            } else {
                continue;
            }
        }
        Preguntas.preguntas3(preguntas, pregunta1);
        System.out.println("Inserte el numero de la segunda pregunta a realizar: ");
        pregunta2=sc.nextInt();
        switch (pregunta2) {
            case 1:
            Preguntas.atributo(estudiantes[randPersona].esMexicano());
            for (int i=0; i<estudiantes.length;i++){
                if (estudiantes[randPersona].esMexicano() == estudiantes[i].esMexicano() && estudiantes[randPersona].sabeManejar() == estudiantes[i].sabeManejar()) {
                    System.out.println(estudiantes[i].getName());
                } else {
                    continue;
                }
            }
            Preguntas.preguntas2(preguntas, pregunta1, pregunta2);
            System.out.println("Inserte el numero de la tercera pregunta a realizar: ");
            int pregunta3=sc.nextInt();
            switch (pregunta3) {
                case 2:
                Preguntas.atributo(estudiantes[randPersona].esMayor18());
                for (int i=0; i<estudiantes.length;i++){
                    if (estudiantes[randPersona].sabeManejar() == estudiantes[i].sabeManejar() && estudiantes[randPersona].esMexicano() == estudiantes[i].esMexicano() && estudiantes[randPersona].esMayor18() == estudiantes[i].esMayor18()) {
                        System.out.println(estudiantes[i].getName());
                    } else {
                        continue;
                    }
                }
                break;

                case 3:
                Preguntas.atributo(estudiantes[randPersona].viveMexico());
                for (int i=0; i<estudiantes.length;i++){
                    if (estudiantes[randPersona].sabeManejar() == estudiantes[i].sabeManejar() && estudiantes[randPersona].esMexicano() == estudiantes[i].esMexicano() && estudiantes[randPersona].viveMexico() == estudiantes[i].viveMexico()) {
                        System.out.println(estudiantes[i].getName());
                    } else {
                        continue;
                    }
                }
                break;
            
            }
            break;
            case 2:
            Preguntas.atributo(estudiantes[randPersona].esMayor18());
            for (int i=0; i<estudiantes.length;i++){
                if (estudiantes[randPersona].sabeManejar() == estudiantes[i].sabeManejar() && estudiantes[randPersona].esMayor18() == estudiantes[i].esMayor18()) {
                    System.out.println(estudiantes[i].getName());
                } else {
                    continue;
                }
            }
            Preguntas.preguntas2(preguntas, pregunta1, pregunta2);
            System.out.println("Inserte el numero de la ultima pregunta a realizar: ");
            pregunta3=sc.nextInt();
            switch (pregunta3) {
                case 1:
                Preguntas.atributo(estudiantes[randPersona].esMexicano());
                for (int i=0; i<estudiantes.length;i++){
                    if (estudiantes[randPersona].esMexicano() == estudiantes[i].esMexicano() && estudiantes[randPersona].esMayor18() == estudiantes[i].esMayor18() && estudiantes[randPersona].sabeManejar() == estudiantes[i].sabeManejar()) {
                        System.out.println(estudiantes[i].getName());
                    } else {
                        continue;
                    }
                }
                    break;
                case 3:
                Preguntas.atributo(estudiantes[randPersona].viveMexico());
                for (int i=0; i<estudiantes.length;i++){
                    if (estudiantes[randPersona].sabeManejar() == estudiantes[i].sabeManejar() && estudiantes[randPersona].esMayor18() == estudiantes[i].esMayor18() && estudiantes[randPersona].viveMexico() == estudiantes[i].viveMexico()) {
                        System.out.println(estudiantes[i].getName());
                    } else {
                        continue;
                    }
                }
                break;
            }
            break;
            case 3:
            Preguntas.atributo(estudiantes[randPersona].viveMexico());
            for (int i=0; i<estudiantes.length;i++){
                if (estudiantes[randPersona].sabeManejar() == estudiantes[i].sabeManejar() && estudiantes[randPersona].viveMexico() == estudiantes[i].viveMexico()) {
                    System.out.println(estudiantes[i].getName());
                } else {
                    continue;
                }
            }
            Preguntas.preguntas2(preguntas, pregunta1, pregunta2);
            System.out.println("Inserte el numero de la ultima pregunta a realizar: ");
            pregunta3=sc.nextInt();
            switch (pregunta3) {
                case 1:
                    Preguntas.atributo(estudiantes[randPersona].esMexicano());
                for (int i=0; i<estudiantes.length;i++){
                    if (estudiantes[randPersona].esMexicano() == estudiantes[i].esMexicano() && estudiantes[randPersona].viveMexico() == estudiantes[i].viveMexico() && estudiantes[randPersona].sabeManejar() == estudiantes[i].sabeManejar()) {
                        System.out.println(estudiantes[i].getName());
                    } else {
                        continue;
                    }
                }
                    break;
                case 2:
                Preguntas.atributo(estudiantes[randPersona].esMayor18());
                for (int i=0; i<estudiantes.length;i++){
                    if (estudiantes[randPersona].esMayor18() == estudiantes[i].esMayor18() && estudiantes[randPersona].viveMexico() == estudiantes[i].viveMexico() && estudiantes[randPersona].sabeManejar() == estudiantes[i].sabeManejar()) {
                        System.out.println(estudiantes[i].getName());
                    } else {
                        continue;
                    }
                }
                break;
            }
            break;
        }
        break;
    }
    
    sc.nextLine();
    System.out.println("\nQuien crees que es la persona elegida? ");
    String adivinar = sc.next();
    if (adivinar.equals(estudiantes[randPersona].getName())) {
        System.out.println("\nAdivinaste!\n\nLa persona seleccionada era: ");
        System.out.println(estudiantes[randPersona].getName());
        wins++;
    } else {
        System.out.println("\nNo adivinaste!\n\nLa persona seleccionada era: ");
        System.out.println(estudiantes[randPersona].getName());
    }

    //Escribir en el archivo
    FileWriter FW = new FileWriter(file);
    //FW.write("Total de partidas: \n");
    FW.write(games + "\n");
    //FW.write("Victorias:\n");
    FW.write(wins + "\n");
    FW.close();
    System.out.println("Datos guardados correctamente");

    sc.close();
    

}
}