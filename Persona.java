package actividad8;

public abstract class Persona {
    private String nombre;
    private boolean esMexicano;
    private boolean esMayor18;
    private boolean viveMexico;
    private boolean sabeManejar;

    public Persona() {
        
    }

    public Persona(String nombre, boolean esMexicano, boolean esMayor18, boolean viveMexico, boolean sabeManejar) {
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

    /*public void recopilarDatos(String nombre, boolean esMexicano, boolean esMayor18, boolean viveMexico, boolean sabeManejar){
        this.nombre = nombre;
        this.esMexicano = esMexicano;
        this.esMayor18 = esMayor18;
        this.viveMexico = viveMexico;
        this.sabeManejar = sabeManejar;

        System.out.println(nombre+"\t"+esMexicano+"\t"+esMayor18+"\t"+viveMexico+"\t"+sabeManejar);
    }*/
    
}
