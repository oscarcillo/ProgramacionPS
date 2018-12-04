package Multihilo_java;

public class Cola {
    private char caracter;
    private boolean disponible = false;//inicialmente cola vacia

    public int get() {
	    if(disponible) {      //hay n�mero en la cola
		disponible = false; //se pone cola vac�a
            return caracter;      //se devuelve
	    }
          return -1;	//no hay n�mero disponible, cola vac�a	
    }

    public void put(char caracter) {
        this.caracter = caracter;    //coloca valor en la cola 
        disponible = true; //disponible para consumir, cola llena	
    }
}