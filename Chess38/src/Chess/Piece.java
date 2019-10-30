package Chess;

/**
 * Piece is an abstract class that all the chess pieces will extend. 
 * @author Wesley Cheung
 * @author Dennis Yu
 *
 */
public abstract class Piece {
	public String type;
	public char team;
	
	public abstract char getTeam();
	public abstract String getType();
	/**
	 * Each subclass of Piece implements their own version of checkMove
	 */
	public abstract boolean checkMove(Piece gameBoard[][], 
			int x1, int y1, 
			int x2, int y2);
}
