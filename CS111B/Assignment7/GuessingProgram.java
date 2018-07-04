import java.util.*;
public class GuessingProgram 
{
    public static void main(String[] args) 
    {     
        //create an instance of the NumberGuesser class, pass 1 and 100
        //as arguments to the constructor
        NumberGuesser guesser = new NumberGuesser(1,100);
        
        char response,input;
        Scanner keyboard = new Scanner(System.in);
        
        //use loop to repeat the game
        do
        {
            System.out.println("Think of a number between 1 and 100");
          
            //use loop to guess number high or low or correct
            //if correct then reset the high and low to when it was constructed
            do
            {
                System.out.print("Is the number " + guesser.getCurrentGuess() + "?"                + " (h/l/c): ");
                response = keyboard.next().charAt(0);
                if (response == 'h' || response == 'H')
                {
                    guesser.higher();
                }
                else if (response == 'l' || response == 'L')
                {
                    guesser.lower();
                }
                else if (response == 'c' || response == 'C')
                {
                    System.out.println("You picked "+ guesser.getCurrentGuess()+"? Great pick.");
                    guesser.reset();
                    break;
                }
             }while(response !='c' || response !='C');

         System.out.print("Do you want to play again? (y/n): ");
         input = keyboard.next().charAt(0);
     }while (input=='y' || input=='Y');
     System.out.println("Good bye!");
  }
}
