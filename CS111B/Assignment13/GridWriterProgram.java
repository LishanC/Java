
public class GridWriterProgram 
{		
       public static void main(String[] args) 
       {		
             GridWriter gw = new GridWriter(40, 50);				
             gw.add(new MyCircle(10, 10, 9));		
             gw.add(new MyCircle(25, 20, 12));		
             gw.add(new MyCircle(25, 20, 5));	
             
             gw.add(new MyRectangle(25, 25, 20, 15));		
             gw.add(new MyRectangle(5, 5, 3, 4));		
             gw.add(new MyRectangle(40, 0, 10, 10));
             
             gw.add(new MySquare(5,5,10));
     	     gw.add(new MySquare(8,10,10));
     	     gw.add(new MySquare(10,20,5));
     	     gw.add(new MySquare(-2,-10,6));
             gw.display();	
       }	
}
