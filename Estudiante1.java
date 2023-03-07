package examen2;

public class Estudiante1 extends Persona { 
    
    public String nombre;
    public boolean esMexicano;
    public boolean esMayor18;
    public boolean viveMexico;
    public boolean sabeManejar;
    
    public Estudiante1(){
       
    }

    public Estudiante1(String nombre, boolean esMexicano, boolean esMayor18, boolean viveMexico, boolean sabeManejar) {
        this.nombre = nombre;
        this.esMexicano = esMexicano;
        this.esMayor18 = esMayor18;
        this.viveMexico = viveMexico;
        this.sabeManejar = sabeManejar;
    }

    public String getName() {
        return nombre;
    }

    public boolean esMexicano() {
        return esMexicano;
    }

    public boolean esMayor18() {
        return esMayor18;
    }
    public boolean viveMexico() {
        return viveMexico;
    }

    public boolean sabeManejar() {
        return sabeManejar;
    }

}
