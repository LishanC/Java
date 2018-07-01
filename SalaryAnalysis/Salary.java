import java.util.Objects;

/** Salary class contains variables name, department, title, base_pay,
 *  overtime_pay and totalpay, methods get/set, equal and compareTo .
*
*/

public class Salary implements Comparable<Salary>{
	private String name;
	private String dept;
	private String title;
    private double base_pay;
    private double overtime_pay;
    private double totalpay;
    
    public Salary(String name, String dept, String title, double base_pay, double overtime_pay,double totalpay) {
    	this.name=name;
    	this.dept=dept;
    	this.title=title;
    	this.base_pay=base_pay;
    	this.overtime_pay=overtime_pay;
    	this.totalpay=totalpay;
    }
    
    public String getName() {
    	return this.name;
    }
    
    public void setName(String name) {
    	this.name=name;
    }
    
    public String getDepartment() {
    	return this.dept;
    }
    
    public void setDepartment(String dept) {
        this.dept=dept;
    }
    
    public String getTitle() {
    	return this.title;
    }
    
    public void setTitle(String title) {
    	this.title=title;
    }
    
    public double getBasepay() {
    	return this.base_pay;
    }
    
    public void setBasepay(double base_pay) {
    	this.base_pay=base_pay;
    }
    
    public double getOverTimePay() {
    	return this.overtime_pay;
    }
    
    public void setOverTimePay(double overtime_pay) {
    	this.overtime_pay=overtime_pay;
    }
    
    public double getTotalpay() {
    	return this.totalpay;
    }

    @Override
	public String toString() {
    	return getName() + " earned $" + getBasepay() + " base pay, and $" + getOverTimePay() + " overtime pay in 2016.";
	}
    
    public boolean equals(Object o) {
    	
    	if(o instanceof Salary) {
    		Salary obj = (Salary) o;
    	
    	boolean checkName=this.name.equals(obj.name);
    	boolean checkDepartment=this.dept.equals(obj.dept);
    	boolean checkTitle=this.title.equals(obj.title);
    	boolean checkBasepay=this.base_pay==obj.base_pay;
    	boolean checkOvertimepay=this.overtime_pay==obj.overtime_pay;
    	boolean checktotalpay=this.totalpay==obj.totalpay;
    	return checkName && checkDepartment && checkTitle && checkBasepay && checkOvertimepay &&checktotalpay;
    }
    	else {
    		return false;
    	}
    }
    
    @Override
	public int hashCode() {
		return Objects.hash(name, dept,title,base_pay,overtime_pay);
	}
    
    @Override
    public int compareTo(Salary obj) {
		if (this.name.compareTo(obj.name) != 0) {
			return name.compareToIgnoreCase(obj.name);
		} else {
			return dept.compareToIgnoreCase(obj.dept);
		}
	}

	public int compareByOT(Salary obj) {
		return Double.compare(obj.overtime_pay, this.overtime_pay);
	}
}


