
import java.lang.reflect.Field;
import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.stream.*;


public class Address {
	
	@ProperLength()
	private String street;
	private String street2;
	
	@ProperLength()
	private String city;
	
	@ProperLength(
			minLength=2,
			maxLength=2
		)
	private String state;
	
	@ProperLength(
			minLength=5,
			maxLength=5
		)
	private String zip;

	public Address(String street, String street2, String city, String state, String zip) throws Exception {
		this.street = street;
		this.street2 = street2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		
		validateLengths();
	}
	
	
	private void validateLengths() throws IllegalArgumentException, IllegalAccessException {
		/* some pseudocode in case it helps:
		 * get the current class
		 * get all fields in this class
		 * 	  NOTE: use the method myClass.getDeclaredFields() to access private fields;
		 *      (getFields() only accesses public fields)
		 * check if the ProperLength annotation is present for that field
		 * if it is, get the annotation object
		 * then get the value for that field
		 *      NOTE: the method myField.get(myObject) can be used to obtain the value of a field for a particular object;
		 *      note that this returns an Object, so you'll need to cast it
		 * check that the length of the value matches the specifications of the annotation
		 * if the length isn't valid, throw an exception     
		 */
		
		ProperLength myannotation = null;
		 Class c= this.getClass();
		 Field[] fields = c.getDeclaredFields();
		 
		 for(Field field: fields)
		 {
    		if(field.isAnnotationPresent(ProperLength.class)) {
    			 myannotation= field.getDeclaredAnnotation(ProperLength.class);
    			
   	             int max=myannotation.maxLength();
   	             int min=myannotation.minLength();
		
   	            if(field.getName()=="street") {
   	        	   if((this.street.length())>max&& (this.street.length()<min) ){
            		  throw new IllegalArgumentException( this.street + " has invalid length for a street" );
            		}
   	            }
   	          
   	            if(field.getName()=="city") {
  	        	   if((this.city.length())>max&& (this.city.length()<min) ){
           		      throw new IllegalArgumentException( this.city + " has invalid length for a city" );
           		   }
  	           }
   	       
   	           if(field.getName()=="state") {
	        	  if((this.state.length())>max&& (this.state.length()<min) ){
        		     throw new IllegalArgumentException( this.state + " has invalid length for a state" );
        		  }
	           }
   	       
   	           if(field.getName()=="zip") {
   	        	  if((this.zip.length())>max&& (this.zip.length()<min) ){
            		throw new IllegalArgumentException( this.zip + " has invalid length for a zip" );
            	  }
   	           }
    		}  
	   } 
}
		 
		
	
	@Override
	public String toString() {
		String s = street + 
				(street2.length()>0 ? "\n"+street2 : "") +
				"\n" + city + ", " + state + " " + zip;
		return s;
				
	}

	
	

}
