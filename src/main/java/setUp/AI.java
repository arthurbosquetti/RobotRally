package setUp;

public class AI extends Player{
	
	private int goalX;
	private int goalY;
	private int x;
	private int y;
	
	
	public AI(String name) {super();}
	
	//AI needs to know where it is (x,y coord)
	//AI needs to know where flag1 and flag2 are
	
	public void setGoal(int x, int y) {
		this.goalX=x;
		this.goalY=y;
	}
	
	//sketch:
	/*
	 * AI knows its X and Y coordinates.
	 * for each card (ex: f1,f2,L,R,B,F2...):
	 *    if x+card makes goalX-x smaller (brings it closer to target):
	 *        pick it
	 *    else: dont
	 *    
	 *    //also:
	 *    if #empty slots left==#cards_left:
	 *    	pick all remaining cards
	 * 
	 */
		
}
	
	
	
	
	
	
	
	
	
	
	
