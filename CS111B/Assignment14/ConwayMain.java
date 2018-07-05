import java.util.*;

public class ConwayMain {
	
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		ConwayWorld world = new ConwayWorld();
		
		// Add some live conway cells, in a horizontal line		
		for (int i = 0; i < 8; i++) {
			ConwayCell c = new ConwayCell(5, 5 + i, world);
			c.setIsAlive(true);
			world.replaceCell(c);
		}
		
	
		// Add 2 live conway cells, in a horizontal and vertical	
		for (int i = 0; i <2 ; i++) 
		{
			 for (int j=0; j<2; j++)
			 {
			    ConwayCell block = new ConwayCell(20+i, 25 + j, world);
			    block.setIsAlive(true);
			    world.replaceCell(block);
			 }
		}
		
		// Add 3 alive cells
		for (int i = 0; i <3; i++) {
			BlinkerCell b = new BlinkerCell(10, 15 + i, world);
			b.setIsAlive(true);
			world.replaceCell(b);
		}

		
		// Add an always-alive cells
		AbstractCell a = new AlwaysAliveCell(12, 12, world);
		world.replaceCell(a);
			
		// Add an always-alive cells
		AbstractCell n = new NeverAliveCell(17, 17, world);
		world.replaceCell(n);
			
		// Go!	
		do {
			world.display();
			world.advanceToNextGeneration();
			
			System.out.print("Another? (y/n): ");
		} while (input.nextLine().charAt(0) == 'y');
	}
}
