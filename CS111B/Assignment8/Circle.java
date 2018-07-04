import java.text.DecimalFormat;

public class Circle
{
   private Point origin;   //the origin
   private double radius;  //hold the radius 
   
   //create constructor with two arguments, initialize origin and radius
   public Circle(Point o, double r)
   {
       origin=new Point(o);
       radius=r;
   }

   //create constructor with three arguments, accept three double values
   public Circle(double xValue, double yValue, double r)
   {
      origin=new Point(xValue, yValue);
      radius=r;
   }
 
   //create constructor with x and y are set to 0 to initialize the origin
   //member and set radius to 1.0
   public Circle()
   {
       origin=new Point(0,0);
       radius=1.0;
   }

   //create copy constructor
   public Circle(Circle c)
   {
       origin=new Point(c.origin);
       radius=c.radius;
   }

   //return the copy of origin object
   public Point GetOrigin()
   {
       return new Point(origin);
   }

   //set origin object with instance of Point 
   public void setOrigin(Point p)
   {
       origin=new Point(p);
   }

   //set the x value in the origin object
   public void setX(double value)
   {
       origin.setX(value);
   }

   //get x in the origin object
   public double getX()
   {
       return origin.getX();
   }

   //set the y value in the origin object
   public void setY(double value)
   {
       origin.setY(value);
   }

   //get the y value in the origin object
   public double getY()
   {
       return origin.getY();
   }
    
   //set the radius value
   public void setRadius(double value)
   {
       radius=value;
   }
 
   //get the radius value
   public double getRadius()
   {
       return radius;
   }

   //caculate the area 
   public double getArea()
   {
       return Math.PI * radius* radius;
   }

   //display the x,y, radius and area
   public String toString()
   {
       DecimalFormat twodec = new DecimalFormat("#.00");
       String str="X is : " +this.getX() +
       "\nY is :" + this.getY() +
       "\nRadius is: " + radius +
       "\nArea is : " +twodec.format(getArea());
       
       return str;
    }

    //create the equals method, if two cirlce content are the same return true
    //otherwise return false
    public boolean equals(Circle c)
    {
       if (this.getX()==c.getX() && this.getY()==c.getY() && this.getRadius() == c.getRadius())
          return true;
       else
          return false;
    }
    
    //create method to chheck if two circle overlap with others
    boolean doesOverlap(Circle c)
    {
       double distance, sum;
       distance=Math.sqrt(Math.pow((this.getX()-c.getX()),2)+Math.pow((this.getY()-c.getY()),2));
       sum=this.getRadius()+c.getRadius();
  
       if (sum>distance)
          return true;
       else
          return false;
    }
}
