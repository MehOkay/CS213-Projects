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
	 * @param gameBoard - the game board that holds the piece
	 * @param x1 - the current row of the piece
	 * @param y1 - the current column of the piece
	 * @param x2 - the new row of the piece
	 * @param y2 - the new column of the piece
	 * 
	 *  @return boolean value if the new row and new column is a valid move for the piece
	 * 
	 */
	public abstract boolean checkMove(Piece gameBoard[][], 
			int x1, int y1, 
			int x2, int y2);
}
