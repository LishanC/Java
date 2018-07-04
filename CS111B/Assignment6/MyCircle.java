public class MyCircle
{
     //declare variable x, y, radius and they are not access outside the class
     private double x;
     private double y;  
     private double radius; 

     //create setX method stores a value in the x field
     public void setX(double value)
     {
         x=value;
     }
 
     //create method return a MyCircle's x
     public double getX()
     {
        return x;
     }

      //create setY method stores a value in the y field
     public void setY(double value)
     {
        y=value;
     }
   
     //create method return a MyCircle's y
     public double getY()
     {
        return y;
     }
 
     //create setRadius method stores a value in the Radius field
     public void setRadius(double value)
     {
        radius=value;
     }

     //create method return a MyCircle's Radius
     public double getRadius()
     {
        return radius;
     }
 
     //create method getArea to return MyCircle's area
     public double getArea()
     {
        return Math.PI*Math.pow(radius,2);
     }

     //create method to return true if this circle overlaps the circle
     //that the method was invoked on
     public boolean doesOverlap(MyCircle otherCircle)
     {
        double sum, distance;
        sum=radius+otherCircle.radius;
        distance=Math.sqrt(Math.pow((x-otherCircle.x),2)+Math.pow((y-otherCircle.y),2));

        if (sum>distance)
          return true;
        else
          return false;
     }
}
