//  This program reads five cards from the user, then analyzes the cards and 
//  prints out the category of hand that they represent
//  Inputs   : five numberic cards between 2-9
//  Outputs  : Pair, Two Pair, Three of a Kind, Straight
//             Full House, Four of a kind
// Written by: Lishan Chan
// Modified  : Sep 9, 2015 
// 

import java.util.*;

public class CardPairs
{
    public static void main(String arg[])
    {
      //defind array hand
      int hand[]=new int[5];
      //for loop to input five numberic cards  
      for (int i=0; i<5; i++)
      {
      Scanner keyboard=new Scanner(System.in);
      System.out.println("Enter five numeric cards, no face cards. Use 2 - 9.");
      System.out.print("Card "+ (i+1) +": ");
      hand[i]=keyboard.nextInt();
      }
      
      //call method containsStraight to check if Straight
      if (containsStraight(hand))
      {
          System.out.println("Straight!");
      }
      //call method containsPair to check if Pair
      else if (containsPair(hand))
      {
          System.out.println("Pair!");
      }
      //call method containsTwoPair to check if Two pairs
      else if (containsTwoPair(hand))
      {
          System.out.println("Two Pair!");    
      }
      //call method contaisThreeOfaKind to check Three of a kind
      else if (containsThreeOfaKind(hand))
      {
          System.out.println("Three of a kind!");
      }
      //call method containsFullHouse to chek Full House
      else if (containsFullHouse(hand))
      {
          System.out.println("Full House!");
      }
      //call method containsFourOfaKind to check Four of a kind
      else if ( containsFourOfaKind(hand))
      {
          System.out.println("Four of a kind!");
      }
      else
      {
          System.out.println("No match!");
      } 
    }
    //create method isSorted perform a selection sort on an integer array  
    public static void isSorted(int hand[])
    {
        int minValue, startnum, minIndex, index;
        for (startnum=0;startnum< hand.length-1; startnum++)
        {
           minIndex=startnum;
           minValue=hand[startnum];
           for (index=startnum+1; index<hand.length; index++)
           { 
              //compare element and find the array min value
              if (hand[index]<minValue)
              {
                 minValue=hand[index];
                 minIndex=index;
              }
           }
           //swap hand[startnum] and hand[minIndex]
           hand[minIndex]=hand[startnum];
           hand[startnum]=minValue;
         }
     }
     //create method containsPair to check if the five card number is pair
     // if Two of the cards are identical then Pair
     public static boolean containsPair(int hand[])
     {    
          //check if the array hand is five cards
          if (hand.length !=5)
             return false;
          //check if the cards are identical as Two pair or three of a kind
          //or full house or four of a kind, if so then it's not a pair
          if ( containsTwoPair(hand) || containsThreeOfaKind(hand)|| containsFullHouse(hand)|| containsFourOfaKind(hand))
             return false;
          //sort the cards
          isSorted(hand);
          //two of the cards are identical
          if (hand[0]==hand[1] || hand[1]==hand[2] || hand[2]==hand[3] || hand[3]==hand[4])
              return true;
           else 
              return false;
     }
  
     //create method to check two of the cards are identical
     public static boolean containsTwoPair(int hand[])
      {
          if (hand.length !=5)
             return false;
          if (containsFullHouse(hand)||containsFourOfaKind(hand))
             return false;

          isSorted(hand);
          if (hand[0]==hand[1] && hand[2]==hand[3] || hand[1]==hand[2]&& hand[3]==hand[4] || hand[0]==hand[1] && hand[3]==hand[4])
              return true;
           else 
              return false;
      } 

      //create method to check three match cards
      public static boolean containsThreeOfaKind(int hand[])
      {
          if (hand.length !=5)
             return false;
          if (containsFullHouse(hand)|| containsFourOfaKind(hand))
             return false;

          isSorted(hand);
          if (hand[0]==hand[1] && hand[1]==hand[2]|| hand[1]==hand[2] && hand[2]==hand[3] || hand[2]==hand[3] && hand[3]==hand[4])
              return true;
           else 
              return false;
      }
      
      //create method to check card values can be arranged in order
      public static boolean containsStraight(int hand[])
      {
          boolean h1=false, h2=false, h3=false, h4=false;
          if (hand.length !=5)
          return false;

          isSorted(hand);
          h1=hand[0]==2 && hand[1]==3 && hand[2]==4 && hand[3]==5 && hand[4]==6;
          h2=hand[0]==3 && hand[1]==4 && hand[2]==5 && hand[3]==6 && hand[4]==7;
          h3=hand[0]==4 && hand[1]==5 && hand[2]==6 && hand[3]==7 && hand[4]==8;
          h4=hand[0]==5 && hand[1]==6 && hand[2]==7 && hand[3]==8 && hand[4]==9;
          return (h1 || h2 || h3 || h4);
      }

      //create method to check a pair and a three of a kind
      public static boolean containsFullHouse(int hand[])
      {
         if (hand.length !=5)
           return false;

         isSorted(hand);
         if (hand[0]==hand[1] && hand[1]==hand[2] && hand[3]==hand[4] || hand[0]==hand[1] && hand[2]==hand[3] && hand[3]==hand[4])
            return true;
         else 
            return false;
      }

      //create method to check four matching cards
      public static boolean containsFourOfaKind(int hand[])
      {
          if (hand.length !=5)
            return false;

          isSorted(hand);
          if (hand[0]==hand[1] && hand[1]==hand[2]&& hand[2]==hand[3] || hand[1]==hand[2]&& hand[2]==hand[3] && hand[3]==hand[4])
             return true;
           else 
             return false;
      }
}
