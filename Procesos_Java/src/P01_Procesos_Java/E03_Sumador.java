package P01_Procesos_Java;

public class E03_Sumador {
	/**
	 * M�todo que suma todos los n�meros entre dos valores
	 * @param n1 N�mero por el que va a empezar a sumar
	 * @param n2 N�mero con el que va a terminar de sumar
	 * @return Integer Devuelve el resultado de la suma
	 */
    public int sumar(int n1, int n2)
    {
            int resultado=0;
            
            for (int i=n1;i<=n2;i++)
            {
                    resultado=resultado+i;
            }
            // System.out.println(resultado);
            return resultado;
    }
    
    
    public static void main(String[] args)
    {
            E03_Sumador s = new E03_Sumador();
            
            //le pasamos los valores por argumentos al m�todo main
            int n1 = Integer.parseInt(args[0]); 
            int n2 = Integer.parseInt(args[1]);
            
            int resultado=s.sumar(n1, n2);
            
            System.out.println(resultado);
    }
}