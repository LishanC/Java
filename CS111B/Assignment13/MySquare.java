public class MySquare extends GridItem
{
    private int side;

    public MySquare (int xValue, int yValue, int xside)
    {
         x=xValue;
         y=yValue;
         side=xside;
    }

    public double getArea()
    {
         return side * side;
    }

    public boolean containsPoint(int xVlue, int yValue)
    {
        return xValue >=x && xValue <=x+side && yValue>=y && yValue <=y+side;
    }
}
