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

    String[] nombres = {"Jose", "Carlos", "Carla", "Josefina", "Natalya", "Patricia", "Natalio", "Patricio", "Benito", "Benita"};

    System.out.println("Nombre\tEs Mexicano\tEs Mayor 18\tVive Mexico\tSabe Manejar");

    for(int i=0; i < 10; i++) {
        String nombre = nombres[i];
        boolean esMexicano = random.nextBoolean();
        boolean esMayor18 = random.nextBoolean();
        boolean viveMexico = random.nextBoolean();
        boolean sabeManejar = random.nextBoolean();  

        if (esMexicano) {
            contMexicano++;
        }
        if (esMayor18) {
            contMayor18++;
        }
        if (viveMexico) {
            contViveMex++;
        }
        if (sabeManejar) {
            contManejar++;
        }

        estudiantes[i] = new Estudiante1(nombre, esMexicano,esMayor18,viveMexico,sabeManejar);
    }   

    for (Estudiante1 estu : estudiantes) {
        System.out.println(estu.getName() +"\t"+ estu.esMexicano +"\t"+ estu.esMayor18+"\t"+ estu.viveMexico+"\t"+ estu.sabeManejar);
    }

    System.out.println("Contador es Mexicano = true: "+contMexicano);
    System.out.println("Contador es Mayor 18 = true: "+contMayor18);
    System.out.println("Contador vive en Mexico = true: "+contViveMex);
    System.out.println("Contador sabe Manejar = true: "+contManejar);
}
}

