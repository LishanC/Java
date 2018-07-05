public class BlinkerCell extends AbstractCell {

	public BlinkerCell(int r, int c, ConwayWorld w) {
		super(r, c, w);
	}	

	//Calculates whether the cell will be alive or dead after the next step
	public boolean willBeAliveInNextGeneration() {
		int nc = neighborCount();
		
                // Add 3 live cells
		for(int i=0;i<3;i++){
	            if (getIsAlive()){
	            	if (i==0 || i==2){
	            		if (nc<2 || nc>3)
	            	    return false;
	            	}
	            	else {
	            	   return true; 
	            	}
	            }
	            else{
	            	return nc == 3;
	            	}
			}
		return getIsAlive();
}
	
	public AbstractCell cellForNextGeneration() {
		BlinkerCell next = new BlinkerCell(getRow(), getColumn(), world);
		
		next.setIsAlive(willBeAliveInNextGeneration());
		
		return next;
	}
	
	public int neighborCount() {
		int count = 0;
		
		int row = getRow();
		int column = getColumn();
		
		for (int dr = -1; dr <= 1; dr++) {
			for (int dc = -1; dc <= 1; dc++) {
				if (world.isAlive(row + dr, column + dc) && !(dr == 0 && dc == 0)) {
					count++;
				}
			}
		}
		
		return count;
	}
}
