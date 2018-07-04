import java.util.*;

public class StringProcessor
{
      private String str;           //hold the string
      private int Numofwords=0;     //hold the number of words
      private int Numofuppercase=0; //hold the number of uppercase letter
      private int Numofdigit=0;     //hold the number of digit
      private int Numofdigitword=0; //hold the number of digit characters
      
      //hold the word digit zero to nine
      private String[] wordDigits={"zero","one","two","three","four","five",
                         "six", "seven","eight", "nine"};
     
      //hold the digit 0-9
      private String[] digits={"0","1","2","3","4","5","6","7","8","9"};
      
      //constructor without argument
      public StringProcessor()
      {
          
      }
 
      //constructor with string argument
      public StringProcessor(String s)
      {
          str=s;
      }

      //create setString method
      public void setString(String s)
      {
          str=s;
      }

      //create getString method and return string str
      public String getString()
      {
         return str;
      }

      //create method to calculate the number of words
      public int wordCount()
      {
         StringTokenizer newstr=new StringTokenizer(str);
         Numofwords=newstr.countTokens();
         
         return Numofwords;
      }

      //create method to calculate the upper case of string
      public int uppercaseCount()
      {
         for (int i=0; i<str.length(); i++)
         {
            if (Character.isUpperCase(str.charAt(i)))
               Numofuppercase++;
         }
         return Numofuppercase;
      }

      //create method to count the digit 0-9
      public int digitCount()
      {
         for (int i=0; i<str.length(); i++)
         {
            if (Character.isDigit(str.charAt(i)))
               Numofdigit++;
         }
          return Numofdigit;
      }

      //create method to count the digit word zero to nine
      public int digitWordCount()
      {
         String[] strdigit=str.split(" ");
         for(int i=0; i<strdigit.length; i++)
         {
             for(int j=0; j<wordDigits.length; j++)
             {
              if (strdigit[i].equalsIgnoreCase(wordDigits[j]))
               Numofdigitword++;
             }
         }

         return Numofdigitword;
      }

      //create method to remove space of the string
      public String getNoSpaceString()
      {
         String str2;
         str2=str.replace(" ", "");

         return str2;
      }

      //create method to replace vowel with "-"
      public String getNoVowelString()
      {
         String str2;
         str2=str.replaceAll("[AEIOUaeiou]", "-");
         return str2;
      }

      //create method to use digit to replace digit word
      public String getNoDigitWordString() 
      {
         String str2=str;
         String[] strsplit=str.split(" ");
         for (int i=0; i<strsplit.length; i++)
         {
             for(int j=0; j<wordDigits.length; j++)
             {
                 if (strsplit[i].equalsIgnoreCase(wordDigits[j]))
                 {
                     str2=str2.replace(strsplit[i], digits[j]);
                 }
             }
         }
         return str2;
      }
}
