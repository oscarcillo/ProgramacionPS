package P01_Procesos_Java;

public class A01_procesos {

	public static void main(String[] args) 
	{
		
		//comprueba que el numero de argumentos es menor a 1
		if(args.length<1) 
		{
			System.exit(1); // devuelve el valor 
		}
		
		if(args.length==1 && args[0].charAt(0)=='-')
		{
			System.exit(3);
		}
		
		if(args.length==1 && args[0].charAt(0)!='-')
		{
			System.exit(2);
		}
		
		System.exit(0);
		
		
	}

}
