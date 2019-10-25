package Chess;

public class King extends Piece {
	public char team;
	public String type = "King";
	
	public King(char team) {
		this.team = team;
	}
	public char getTeam() {
		return this.team;
	}
	public String getType() {
		return this.type;
	}
	
	/**
	 * checkMove() takes in the game board, current row, current column, new row, 
	 * and new column as parameters and returns true if new position is a valid move for King
	 * 
	 * @param gameBoard is the game board
	 * @param x1 is the current row
	 * @param y1 is the current column
	 * @param x2 is the new row
	 * @param y2 is the new column
	 * 
	 * @return true if move is valid or false if not
	 */
	public boolean checkMove(Piece gameBoard[][], 
			int x1, int y1, 
			int x2, int y2) {
		//king moving more than 1 space
		if((Math.abs(x1-x2) != 1) || (Math.abs(y2-y1) != 1)) {
			return false;
		}
		//same team piece blocking
		else if(gameBoard[x2][y2] != null)
			if(gameBoard[x2][y2].getTeam() == gameBoard[x1][y1].getTeam())
				return false;
			else 
				return true;
		else 		
			return true; 
	}
}
