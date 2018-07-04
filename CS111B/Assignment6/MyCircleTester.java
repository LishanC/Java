// This program create three instances of the MyCircle class
// Written by: Lishan Chan
//   Modified: Sep 14, 2015 
//
import java.text.DecimalFormat;
public class MyCircleTester
{
    public static void main(String[] args)
    {
        double Area1, Area2, Area3; //To hold the three areas

        //create three MyCircle objects
        MyCircle circle1=new MyCircle();
        MyCircle circle2=new MyCircle(); 
        MyCircle circle3=new MyCircle();  

        //store the x,y and radius of the three circles
        circle1.setRadius(3.1); 
        circle1.setX(7.0);
        circle1.setY(8.1);
   
        circle2.setRadius(1.5);
        circle2.setX(4.5);
        circle2.setY(5.2);

        circle3.setRadius(2.0);
        circle3.setX(0.0);
        circle3.setY(0.0);
 
        DecimalFormat twodec = new DecimalFormat("#.00");
        //call method getArea to get the area
        Area1=circle1.getArea();
        Area2=circle2.getArea();
        Area3=circle3.getArea();

        System.out.println("The area of circle1 is: "+ twodec.format(Area1));
        System.out.println("The area of circle2 is: "+ twodec.format(Area2));
        System.out.println("The area of circle3 is: "+ twodec.format(Area3));
 
        //call method doesOverlap to check if two of them should overlap
        if (circle1.doesOverlap(circle2))
           System.out.println("circle1 overlap circle2");
        else
           System.out.println("circle1 does not overlap circle2");
        
         if (circle1.doesOverlap(circle3))
           System.out.println("circle1 overlap circle3");
        else
           System.out.println("circle1 does not overlap circle3");

         if (circle2.doesOverlap(circle1))
           System.out.println("circle2 overlap circle1");
        else
           System.out.println("circle2 does not overlap circle1");

        if (circle2.doesOverlap(circle3))
           System.out.println("circle2 overlap circle3");
        else
           System.out.println("circle2 does not overlap circle3");

    }
}
