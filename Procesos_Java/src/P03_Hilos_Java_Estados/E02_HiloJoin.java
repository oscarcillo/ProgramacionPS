package P03_Hilos_Java_Estados;

public class E02_HiloJoin extends Thread 
{
	  private int n;
	  public E02_HiloJoin(String nom, int n) 
	  {
	    super(nom);  
	    this.n=n;	
	  }
	  
	  public void run() 
	  {
	    for(int i=1; i<= n; i++)  
	    {
	       System.out.println(getName() + ": " + i);
	       try 
	       {
	           sleep(1000); 
	       } 
	       catch (InterruptedException ignore) {}    	   
	    }
	    
		System.out.println("Fin Bucle " + getName());
	  }
	  
}//