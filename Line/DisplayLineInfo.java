package week10;

import javafx.scene.shape.Line;
import java.lang.*;
@FunctionalInterface
public interface DisplayLineInfo {

    String getInfo(Line line);

    public static enum InfoType {
        DISTANCE, MIDPOINT, VERTHORZ, STARTENDPOINT;
    }

    //factory method to return four different possible DisplayLineInfo objects 
    public static DisplayLineInfo createDisplayLineInfo(InfoType type) {
    	
        switch(type) {
        //display the distance between two poing
        case DISTANCE: return (Line line) -> {
        	String str ="";
    		double x1= line.getStartX();
    		double x2=line.getEndX();
    		double y1=line.getStartY();
    		double y2=line.getEndY();
    		double distance=Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
    		double distance_fixed=Math.round(distance);
    				
    		return str+ distance_fixed;
        };
        //display the middle point of two points
        case MIDPOINT: return (Line line) -> {
        	String str="";
    		double x1= line.getStartX();
    		double x2=line.getEndX();
    		double y1=line.getStartY();
    		double y2=line.getEndY();
    		int midx=(int) ((x1+x2)/2);
    		int midy=(int) ((y1+y2)/2);
    		return str+ "(" +midx + "," + midy +")";
        };
        
        //check if the line is vertical or horizon 
        case VERTHORZ: return (Line line) -> {
        	String str="";
    		double x1= line.getStartX();
    		double x2=line.getEndX();
    		double y1=line.getStartY();
    		double y2=line.getEndY();
    		if(x1==x2) {
    			str= str + " Vertical? true ";
    		}
    		if(x1 != x2)
    		{
    			str= str + " Vertical? false ";
    		}
    		
    		if(y1==y2) {
    			str= str + " Horizon? true ";
    		}
    		if(y1 !=y2) { 
    			str= str + " Horizon? false ";
    		}
			return str;
        };
        
        //Extra credit: display the location of two points
        case STARTENDPOINT: return(Line line) -> {
        	String str ="";
        	double x1 = Math.round(line.getStartX());
    		double x2 = Math.round(line.getEndX());
    		double y1 = Math.round(line.getStartY());
    		double y2 = Math.round(line.getEndY());
    		return str+ "(" +x1+", " + y1 + ")" + "  ("+ x2 + ", " + y2 +")";
        	
        };
        
        
      }
      return null;
      
    }

}
