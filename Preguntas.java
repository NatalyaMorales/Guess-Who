package examen2;

public class Preguntas {
    
    //Metodo que indica si el atributo es cierto o falso
    public static void atributo(boolean atributo){
        if (atributo == true) {
            System.out.println("\nPara el personaje a adivinar el atributo es verdadero\n");
        } else {
            System.out.println("\nPara el personaje a adivinar el atributo es falso\n");
        }

        System.out.println("Las personas que cumplen con esas características son:");
    }

    //Metodo para imprimir las 3 preguntas restantes
    public static void preguntas3(String[] preguntas, int pregunta1) {
        System.out.println("\nRealiza 2 preguntas más y adivina la persona seleccionada");
        for (int i=0; i<preguntas.length;i++) {
            if (i==(pregunta1-1)){
                continue;
            } else {
                System.out.println(preguntas[i]);
            }
        }
    }

    //Metodo para imprimir las 2 preguntas restantes
    public static void preguntas2(String[] preguntas, int pregunta1, int pregunta2) {
        System.out.println("\nRealiza una ultima pregunta y adivina la persona seleccionada");
            for (int i=0; i<preguntas.length;i++) {
                if (i==(pregunta1-1) || i==(pregunta2-1)){
                    continue;
                } else {
                    System.out.println(preguntas[i]);
                }
            }
    }

}
