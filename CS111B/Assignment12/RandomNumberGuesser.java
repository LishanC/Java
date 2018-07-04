import java.util.Random;

//The RandomNumberGuesser class extends the NumberGuesser class
public class RandomNumberGuesser extends NumberGuesser
{
     private Random r;             //hold the Random object
     private int rpoint;           //hold the rpoint
     private boolean check=true;   //hold the check and initialize to true
     
    //call the superclass constructor
    public RandomNumberGuesser(int lowerBound, int upperBound)
    {
        super(lowerBound,upperBound);
    }

    //override superclass method getcurrentGuess, if true generate a new random number
    //otherwise will generate the same random number
    public int getCurrentGuess()
    {
    	   if (check)
    	   {
    		Random r=new Random();
                //access to superclass variable highest and lowest and 
                //generate a random number between high and low,
               
   	        rpoint=lowest+(r.nextInt((highest-lowest)+1)); 
   	        check=false;
    	   }  
           return rpoint;
    }
    
    //call the superclass method higher().
    public void higher() 
    {
	   super.higher();
	   check=true;
    }
	
    //call the superclass method lower().
    public void lower()
    {
	   super.lower();
	   check=true;
    }
	
    //call the superclass method reset().
    public void reset()
    {
	   super.reset();
	   check = true;
    }
}
