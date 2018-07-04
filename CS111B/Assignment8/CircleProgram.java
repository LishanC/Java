// This program create is to test Aggregation, multiple Constructors 
// copy Constructor, the toString method and equals method 
// Written by: Lishan Chan
//   Modified: Set 21, 2015 
//

public class CircleProgram
{
    public static void main(String[] args)
    {
        //declare 4 Area    
        double Area1, Area2, Area3,Area4; 

        //create 4 circle objects with 4 different constructor
        Point p1=new Point(3.0,5.0);
        Circle circle1=new Circle(p1, 2.0);
        Circle circle2=new Circle(4.0,5.2,4.1);    
        Circle circle3=new Circle();
        Circle circle4=new Circle(circle1);
 
        Area1=circle1.getArea();
        Area2=circle2.getArea();
        Area3=circle3.getArea();
        Area4=circle4.getArea();

        //output the circle's x, y, radius and area with toString method
        System.out.println(circle1);
        System.out.println(circle2);
        System.out.println(circle3);
        System.out.println(circle4);
 
        //call method doesOverlap to check if two of them overlap
        if (circle1.doesOverlap(circle2))
           System.out.println("circle1 overlap circle2");
        else
           System.out.println("circle1 does not overlap circle2");
        
         if (circle1.doesOverlap(circle3))
           System.out.println("circle1 overlap circle3");
        else
           System.out.println("circle1 does not overlap circle3");

        if (circle1.doesOverlap(circle4))
           System.out.println("circle1 overlap circle4");
        else
           System.out.println("circle1 does not overlap circle4");

         if (circle2.doesOverlap(circle1))
           System.out.println("circle2 overlap circle1");
        else
           System.out.println("circle2 does not overlap circle1");

        if (circle2.doesOverlap(circle3))
           System.out.println("circle2 overlap circle3");
        else
           System.out.println("circle2 does not overlap circle3");
       
        if (circle2.doesOverlap(circle4))
           System.out.println("circle2 overlap circle4");
        else
           System.out.println("circle2 does not overlap circle4");
        
        if (circle3.doesOverlap(circle4))
           System.out.println("circle3 overlap circle4");
        else
           System.out.println("circle3 does not overlap circle4");

        //call method equals to check if two of circle are the same content
        if (circle1.equals(circle2))
           System.out.println("circle1 and circle2 are the same");
        else
           System.out.println("circle1 and circle2 are not the same");

        if (circle1.equals(circle4))
            System.out.println("circle1 and circle4 are the same");
        else
           System.out.println("circle1 and circle4 are not the same");
    }
}
