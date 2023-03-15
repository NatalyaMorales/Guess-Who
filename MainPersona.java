package actividad8;
import java.util.Random;

public class MainPersona {
    public static void main (String[] args){
    
    Random random = new Random();
    
    Estudiante1[] estudiantes = new Estudiante1[10];
    
    int contMexicano=0;
    int contMayor18=0;
    int contViveMex=0;
    int contManejar=0;

    String[] nombres = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

    System.out.println("Nombre / Es Mexicano / Es Mayor 18 / Vive Mexico / Sabe Manejar");

    for(int i=0; i < estudiantes.length; i++) {
        String nombre = nombres[i];
        boolean esMexicano = random.nextBoolean();
        boolean esMayor18 = random.nextBoolean();
        boolean viveMexico = random.nextBoolean();
        boolean sabeManejar = random.nextBoolean();  

        estudiantes[i] = new Estudiante1(nombre, esMexicano,esMayor18,viveMexico,sabeManejar);
        //Comprobar que todas las personas sean diferentes
        if (i==0){
            continue;
        } else {
            for(int j=0; j < i; j++) {
                if (estudiantes[i].esMexicano == estudiantes[j].esMexicano && estudiantes[i].esMayor18 == estudiantes[j].esMayor18 && estudiantes[i].viveMexico == estudiantes[j].viveMexico && estudiantes[i].sabeManejar == estudiantes[j].sabeManejar){
                    esMexicano = random.nextBoolean();
                    esMayor18 = random.nextBoolean();
                    viveMexico = random.nextBoolean();
                    sabeManejar = random.nextBoolean();
                    estudiantes[i] = new Estudiante1(nombre, esMexicano,esMayor18,viveMexico,sabeManejar);
                    j=0;
                } 
            }
        }

        if (esMexicano) contMexicano++;
        if (esMayor18) contMayor18++;
        if (viveMexico) contViveMex++;
        if (sabeManejar) contManejar++;
    }   

    for (Estudiante1 estu : estudiantes) {
        System.out.println(estu.getName() +" / "+ estu.esMexicano +" / "+ estu.esMayor18+" / "+ estu.viveMexico+" / "+ estu.sabeManejar);
    }

    System.out.println("Contador es Mexicano = true: "+contMexicano);
    System.out.println("Contador es Mayor 18 = true: "+contMayor18);
    System.out.println("Contador vive en Mexico = true: "+contViveMex);
    System.out.println("Contador sabe Manejar = true: "+contManejar);
}
}

