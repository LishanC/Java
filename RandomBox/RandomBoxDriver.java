import java.util.*;

public class RandomBoxDriver {

	public static void main(String[] args) {
		RandomBox<String> nameDrawing = new RandomBox<>();
		fillNames(nameDrawing);
		System.out.println("Random Name Drawing!");
		System.out.println(nameDrawing);
		nameDrawing.displayEntries();
		System.out.println("Winner: " + nameDrawing.drawWinner());
		
		RandomBox<Integer> lottery = new RandomBox<>();
		fillNumbers(lottery, 100);
		System.out.println("\nLottery!");
		lottery.displayEntries();
		System.out.println(lottery);		
		System.out.println("Winner: " + lottery.drawWinner());
		
		System.out.println("\nMultiple Winners!\n");
		System.out.println("Random Name Drawing! 5 Winners!");
		ArrayList<String> nameWinners = pickMultipleWinners(nameDrawing, 5);
		System.out.println(nameWinners);
		System.out.println("\nLottery! 3 Winners!");
		ArrayList<Integer> numberWinners = pickMultipleWinners(lottery, 3);
		System.out.println(numberWinners);
	}
	
	public static void fillNames(RandomBox<String> wordBox) {
		wordBox.addItem("Adam Zapel"); wordBox.addItem("Al Dente"); wordBox.addItem("Al Fresco"); wordBox.addItem("Al K. Seltzer"); wordBox.addItem("Alf A. Romeo"); wordBox.addItem("Amanda Lynn"); wordBox.addItem("Anita Job"); wordBox.addItem("Anna Conda"); wordBox.addItem("Anna Graham"); wordBox.addItem("Anna Prentice "); wordBox.addItem("Anna Sasin"); wordBox.addItem("Anne Teak"); wordBox.addItem("B.A. Ware"); wordBox.addItem("Barb Dwyer"); wordBox.addItem("Barb E. Dahl"); wordBox.addItem("Barbara Seville"); wordBox.addItem("Barry Cade"); wordBox.addItem("Bea Minor"); wordBox.addItem("Dee Major"); wordBox.addItem("Beau Tye"); wordBox.addItem("Bill Board"); wordBox.addItem("Cara Van"); wordBox.addItem("Chris P. Bacon"); wordBox.addItem("Constance Noring"); wordBox.addItem("Crystal Ball"); wordBox.addItem("Crystal Glass"); wordBox.addItem("Earl Lee Riser"); wordBox.addItem("Easton West "); wordBox.addItem("Ferris Wheeler"); wordBox.addItem("Flint Sparks"); wordBox.addItem("Franklin Stein "); wordBox.addItem("Gene Poole"); wordBox.addItem("Heidi Clare"); wordBox.addItem("Helen Back"); wordBox.addItem("Helen Wiells"); wordBox.addItem("Holly McRell"); wordBox.addItem("Holly Wood"); wordBox.addItem("Jack Pott"); wordBox.addItem("Joe Kerr"); wordBox.addItem("Joy Rider"); wordBox.addItem("Justin Case"); wordBox.addItem("Justin Time"); wordBox.addItem("Kandi Apple"); wordBox.addItem("Laura Norder"); wordBox.addItem("Leigh King "); wordBox.addItem("Luke Warm"); wordBox.addItem("Marsha Mellow"); wordBox.addItem("Marshall Law"); wordBox.addItem("Marty Graw"); wordBox.addItem("Olive Branch"); wordBox.addItem("Paige Turner"); wordBox.addItem("Pepe Roni"); wordBox.addItem("Price Wright"); wordBox.addItem("Rocky Beach"); wordBox.addItem("Sandy Beach"); wordBox.addItem("Sal A. Mander"); wordBox.addItem("Stanley Cupp"); wordBox.addItem("Tom Morrow"); wordBox.addItem("Warren Peace"); wordBox.addItem("Will Power"); wordBox.addItem("X. Benedict");
	}
	
	public static void fillNumbers(RandomBox<Integer> numbersBox, int numberOfNumbers) {
		Random generator = new Random();
		int maxNumber = numberOfNumbers * 100;
		for(int i=0; i<numberOfNumbers; i++) {
			numbersBox.addItem(generator.nextInt(maxNumber));
		}
	}
	
	
	// method to pick multiple winners from a RandomBox.
	public static <T> ArrayList<T> pickMultipleWinners(RandomBox<T> box, int number){
		ArrayList<T> winnerlist=new ArrayList<>();
		int count=0;
		while(count<number) {
			T winner=box.drawWinner();
			if(!winnerlist.contains(winner))
			winnerlist.add(winner);
			count++;		
		}
		return winnerlist;
	}
}
