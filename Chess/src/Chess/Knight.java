package Chess;

/**
 * The Knight class is an extension of the Piece class and creates a Knight Piece.
 * @author Wesley Cheung
 * @author Dennis Yu
 * 
 */
public class Knight extends Piece {
	public char team;
	public String type = "Knight";

	public Knight(char team) {
		this.team = team;
	}
	public char getTeam() {
		return this.team;
	}
	public String getType() {
		return this.type;
	}
	
	/**
	 * checMove() takes in the current position and new position of knight's move and returns true if it is a valid move for Knight. 
	 * This is different from checkHelper() which determines ALL possible knight moves. 
	 * 
	 * @param gameBoard
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * 
	 * @return true if move is valid and false otherwise.
	 */
	public boolean checkMove(Piece gameBoard[][], 
			int x1, int y1, 
			int x2, int y2) {
		
		if(checkMoveHelper(gameBoard, x1, y1, x2, y2) == true) {
		/*is a valid Knight move*/
			
			//check if new position is empty:
			if(gameBoard[x2][y2] == null) {
				return true;
			}
			
			//new position is not empty
			else {
				
				//checks team of both pieces
				if(gameBoard[x1][y1].getTeam() == gameBoard[x2][y2].getTeam()) {
					return false;
				}
				else {
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * helper method to checkMove(). Checks to see if destination is one of the possible new positions of a knight.
	 * @param gameBoard
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @return
	 */
	private boolean checkMoveHelper(Piece gameBoard[][], 
			int x1, int y1, 
			int x2, int y2) {
		
		if(Math.abs(x2 - x1) == 2 && Math.abs(y2 - y1) == 1){
			return true;
		}
		
		if(Math.abs(x2 - x1) == 1 && Math.abs(y2 - y1) == 2){
			return true;
		}
		
		return false;
	}
	
}