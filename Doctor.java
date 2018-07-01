/** subclass Doctor which define a doctor, including the name, age, 
 * gender inherit from super class People
 * and it's subclass variable speciality  
 * 
 */

package week1;

import java.util.ArrayList;

public class Doctor extends People {
	private String speciality;
	ArrayList<Patient> patientList= new ArrayList<>();
	
	//constructor 
	public Doctor(String lastName, String firstName, int age, String genda, String speciality) {
		super(lastName, firstName, age, genda);
		this.speciality=speciality;
	}
	
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String newspeciality) {
		this.speciality=newspeciality;
	}
	
	//this method override super class method toString
	@Override
	public String toString(){
		return "Doctor " + super.getFullName() + " is a " + getSpeciality();
	}

	//this method override super class method equals
	@Override
	public boolean equals(Object o) {
		if(! super.equals(o)) {
			return false;
		}
		if(o instanceof People) {
			Doctor other =(Doctor) o;
			if(this.speciality.equals(other.speciality))
				return true;
		}
		return false;
	}
	
	public void addPatients(Patient obj)
	{
	    patientList.add(obj);
	}
	
	public void printPatientList() {
		System.out.print("Doctor " + super.getFullName() + " patients including : ");
		for(int i=0; i<patientList.size(); i++) {
	            System.out.print(patientList.get(i).getFullName() + ", ");
		}
	}
}
