import java.util.Scanner;

public class Assignment1
{
   public static void main(String args[])
   {
       int count;
       char goAgain='y';
       Scanner keyboard=new Scanner(System.in);

       while(goAgain !='n')
       {
          System.out.print("How many asterisk?: ");
          count=keyboard.nextInt();

          for(int i=0; i<count; i++)
          {
             System.out.print("*");
          }
   
          System.out.println();
          System.out.print("Do you want to go again? (y/n): ");

          goAgain=keyboard.next().charAt(0);
       }
    }
}
