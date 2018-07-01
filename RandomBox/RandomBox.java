/**the generic RandomBox to hold a list of item
 * The class can be used to simulate a random drawing of objects.
 * Example: a drawing of Strings- people's names who entered a contest
 * Example: a drawing of Integers- guess the number
 * Example: a drawing of Employee objects- one lucky worker wins a free trip!
 * 
 * @author Lishan Chan
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Random;

public class RandomBox <T>  {
	
	private ArrayList<T> list; 
	
	public RandomBox() {
		this.list=new ArrayList<>();
	}
	
	public void addItem(T newItem) {
		list.add(newItem);
	}
	
	public T drawWinner() {
		Random r=new Random();
		int len=list.size();
		int randomnum = r.nextInt(len);
		return list.get(randomnum);
	}
	
	public void displayEntries() {
		System.out.print(list);
	}

	public String toString() {
		String str="";
		str="There are " + list.size() + " entries .";
		return str;
	}
}
