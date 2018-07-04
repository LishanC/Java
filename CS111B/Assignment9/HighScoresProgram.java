//  This program records high-score data for a fictitious game 
//  Inputs     : five names and five scores
//  Outputs    : print it back out sorted by score
//  Written by : Lishan Chan
//  Modified   : Sep 28 ,2015

import java.util.*;
public class HighScoresProgram
{
    public static void main(String[] args)
    {
          //allocate an array of five HighScore references
    	  HighScores[] scores=new HighScores[5];

    	  //call three methods to initial array, sort data and display
          initialize(scores);
          sort(scores);
          display(scores);
    }

    //create method to let user input five names and five scores
    public static void initialize(HighScores[] scores)
    {
         Scanner keyboard=new Scanner(System.in);     
         int score;
         String name;
 
         for (int i=0; i<5; i++)
         {
              System.out.print("Enter the name for score #"+(i+1) + ":");
              name=keyboard.next();
              System.out.print("Enter the score for score #"+(i+1) + ":");
              score=keyboard.nextInt();
              scores[i]=new HighScores(name, score);
         }
    }
  
    //create method sort to sort array base on the values in the scores array
    public static void sort(HighScores[] scores)
    {
         HighScores max, tempscore;         //hold objects
         int maxIndex, maxScore, tempScore; //hold maxIndex,maxScore, tempScore
         String maxName, tempName;          //hold maxName, tempName
         for (int startNum=0; startNum<scores.length -1; startNum++)
         {
             //initial the maxIndex, max, maxScore, maxName
             maxIndex=startNum;
             max=scores[startNum];
             maxScore=max.getScore();
             maxName=max.getName();

             for (int index=startNum+1; index<scores.length; index++)
             {
            	 //compare element and find the array max value and replace them
                 if (scores[index].getScore()>maxScore)
                 {
                      maxScore=scores[index].getScore();
                      maxIndex=index;
                      maxName=scores[index].getName();
                 }
             }
             
             //swap the max score and name
             tempScore=max.getScore();
             tempName=max.getName();

             max.setScore(maxScore);
             max.setName(maxName);

             tempscore=scores[maxIndex];
             tempscore.setName(tempName);
             tempscore.setScore(tempScore);
         }
     }

     //create method to display the sort names and scores
     public static void display(HighScores[] scores)
     { 
          System.out.println("Top Scorers: ");
          for (int i=0; i<scores.length; i++)
          {
              System.out.println(scores[i].getName()+ ":" + scores[i].getScore());
          }
     }
} 
