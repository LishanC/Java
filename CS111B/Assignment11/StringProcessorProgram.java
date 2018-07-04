import java.util.*;

public class StringProcessorProgram
{
     public static void main(String[] args)
     {
          String input;   //hold the input
          Scanner keyboard=new Scanner(System.in);
          char response='y';
          
          //use loop to repeat the input
          do
          {         
               System.out.print("Enter a line of text: ");
               input=keyboard.nextLine();  //input string
               
               //create object
               StringProcessor counter=new StringProcessor();
               counter.setString(input);

               //output the string with all methods
               System.out.println("words: " + counter.wordCount());
               System.out.println("uppercase: "+counter.uppercaseCount());
               System.out.println("digits: " +counter.digitCount());
               System.out.println("digit words: "+ counter.digitWordCount());
               System.out.println("line with whitespace removed: " +counter.getNoSpaceString());
               System.out.println("line with vowels replaced: "+counter.getNoVowelString());
               System.out.println("line with digit words replaced: "+counter.getNoDigitWordString());

               System.out.print("do you want to enter another? (y/n): ");
               response=keyboard.nextLine().charAt(0);
            }while(response !='n');
      }
}
