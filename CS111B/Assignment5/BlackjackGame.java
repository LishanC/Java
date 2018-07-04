// This program have player and dealer to play the game, and they are asked 
// whether or not they want more cards. Their goal is to get as close as 
// possible to a total of 21 without going over.
//   Inputs   : 'y' or 'n' or 'c' to answer question
//   Outputs : 1.play card 1-10 and total
//              2.Display player and dealer win or bust or push       
//  Written by: Lishan Chan
//   Modified: August 28, 2015 
// 

import java.util.*;  //Need the Scanner class

public class BlackjackGame
{
   public static void main(String args[])
   {
        
         char playagain='y';                     //initial playagain to 'y'
         Scanner keyboard=new Scanner(System.in);//Create a Scanner object      
         Random r=new Random();                  //create a Random object

         //start the loop
         while (playagain != 'n')
         {
              //generate a card for dealer
              int dealertotal=r.nextInt(10)+1;
              System.out.println("The dealer starts with a  "+ dealertotal);

              //generate two cards for player and add to the player total
              int num1, num2, playertotal;
              num1=r.nextInt(10)+1;
              num2=r.nextInt(10)+1;
              playertotal=num1+num2;
              System.out.println("Your first Cards: " + num1 +","+num2);
              System.out.println("Total: " +playertotal);
           
              //use loop to ask the player if need another card and 
              //update the player total
              char anothercard='y';
              System.out.print("hit? (y/n): ");
              anothercard=keyboard.next().charAt(0);
              while (anothercard !='n')
              {
                 int card=r.nextInt(10)+1;
                 System.out.println("Card: " + card);
                 playertotal=playertotal+card;
                 System.out.println("Total: " + playertotal);
                
                 //check the player total in each loop.if the player bust 
                 //or win, if so stop the game and ask if to play again.
                 if (playertotal>21)
                 {
                     System.out.println("Bust.You lost");
                     break;
                 }
                 if (playertotal==21)
                 {
                     System.out.println("You win!");
                     break;
                 }                
 
                 System.out.print("hit? (y/n): ");
                 anothercard=keyboard.next().charAt(0);
              }
              System.out.println("dealers has a " +dealertotal +".....");
              
              char continu='c';

              System.out.print("(c to continue) " );
              continu=keyboard.next().charAt(0);

             //if the player total less than 21, then turn to dealer 
             //and check dealer total in each loop, if dealer total<17, dealer
             //must take more card, if dealertotal>17 and type 'c', dealer will 
             //take more card, otherwise stop take card
             if(playertotal<21)
             {
                 while (continu =='c' || dealertotal<17)
                 {
                    int newdealer=r.nextInt(10)+1;
                    System.out.println("Dealer gets a " + newdealer);
                    dealertotal=dealertotal+newdealer;
                    System.out.println("Total: " + dealertotal);

                    if (dealertotal==21) 
                    {
                       System.out.println("Dealer Wins!");
                       break;
                    }
                    if (dealertotal==playertotal)
                    {
                       System.out.println("Push!");
                       break;
                    }
                    if (dealertotal>21)
                    {
                       System.out.println("Bust, Dealer lost!");
                       break;
                    }
                 
                    System.out.print("(c to continue) " );
                    continu=keyboard.next().charAt(0);
                }
              }
              //conclude the result, if dealertotal>playtotal, dealwin
              //otherwise player win the game
              if (dealertotal<21 && playertotal<21)
              {
                 if (dealertotal>playertotal)
                 {
                     System.out.println("Dealer win!");
                 }
                 if (dealertotal<playertotal)
                 {
                    System.out.println("Player win!");
                 }
              }

               System.out.print(" play again? (y/n): ");
               playagain=keyboard.next().charAt(0);

         }
   }
}
