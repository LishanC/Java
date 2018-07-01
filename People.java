/**
 * the super class of hospital mangement system which define a people object
 *  which including name, age and gender.
 *
 * @author Lishan Chan
 * @version 1.0
 */

package week1;

public class People {
	private String lastName;
	private String firstName;
	private int age;
	private String gender;
	
       // constructor 
	public People(String lastName2, String firstName2, int age2, String gender2) {
		
	    this.lastName=lastName2;
	    this.firstName=firstName2;
	    this.age=age2;
	    this.gender=gender2;
	}

	public String getFirstName() {
	    return this.firstName;
	}
	
	public String getLastName() {
	    return this.lastName;
	}

	//method getFullName
	public String getFullName() {
    	    return this.firstName + " " +  this.lastName;
        }
    
        public void setFirstName(String firstName) {
    	    this.firstName=firstName;
        }
    
        public void setLastName(String lastName) {
    	   this.lastName=lastName;
        }
    
        public int getAge() {
    	   return this.age;
        }
    
        public void setAge(int age) {
    	   this.age=age;
        }

        public String getGender() {
    	   return this.gender;
        }
    
        public void setGender(String gender) {
    	   this.gender=gender;
        }
    
       //method toString to display an object
        public String toString() {
     	    return getFullName() + " , " + getAge() + " years old, " + getGender() + ", ";
        }
    
       //method equals to check if two object are the same
       public boolean equals(People otherP) {
    	
    	    if(otherP instanceof People) {
		People other = (People) otherP;
    	
         	boolean sameFirstName=this.firstName.equals(other.firstName);
         	boolean sameLastName=this.lastName.equals(other.lastName);
         	boolean sameAge=this.age==other.age;
        	boolean sameGender=this.gender.equals(other.gender);
        	    	
       	        return sameFirstName &&sameLastName&&sameAge&&sameGender;
            }
    	    else
    		return false;
    
       }
}
