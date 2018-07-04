public class HighScores
{
    private String name;   //Hold the name
    private int score;     //Hold the score
  
    //constructor accept a String n and a int s
    public HighScores(String n, int s)
    {
         name=n;
         score=s;
    }

    //create method setName to store a value in the name field
    public void setName(String n)
    {
        name=n;
    }

    //getName method , return the name field
    public String getName()
    {
        return name;
    }

    //create method setScore to store a value in the score field
    public void setScore(int s)
    {
        score=s;
    }

    //getScore method , return the score field
    public int getScore()
    {
        return score;
    }
}
