public class NumberGuesser
{
    protected int lowest;          //hold the lowest
    protected int highest;         //hold the highest
    private int originallower;     //hold the original lower
    private int originalupper;     //hold the original upper

    //create Constructor, param lowerBound, upperBound
    public NumberGuesser(int lowerBound, int upperBound)
    {
        lowest=lowerBound;
        originallower=lowerBound;

        highest=upperBound;
        originalupper=upperBound;
    }

    //create method when higher set the lowest to current guess
    public void higher()
    {
        lowest=getCurrentGuess();
    }

    //create method when lower set the higest to current guess
    public void lower()
    {
        highest=getCurrentGuess();
    }

    //create method to set the mid number between lowest and highest
    public int getCurrentGuess()
    {
        return (lowest+highest)/2;
    }

    //create method return the state that it was in when it was constructed
    public void reset()
    {
        highest=originalupper;
        lowest=originallower;
    }

}
