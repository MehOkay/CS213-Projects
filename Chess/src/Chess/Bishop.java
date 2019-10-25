package Chess;

/**
 * The Bishop class is an extension of the Piece class and creates a Bishop piece.
 * @author Wesley Cheung
 * @author Dennis Yu
 *
 */

public class Bishop extends Piece {
	public char team;
	public String type = "Bishop";
	
	public Bishop(char team) {
		this.team = team;
	}
	public char getTeam() {
		return this.team;
	}
	public String getType() {
		return this.type;
	}
	
	/**
	 * check() takes in the game board, current row, current column, new row, and new column as parameters and returns true if new position is a valid move for Bishop
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
		
		//checks if valid move for bishop
		if( ((Math.abs(x2 - x1)) / (Math.abs(y1 - y2)) == 1) && !((x1 == x2) && (y1 == y2)) ) {
			
			//check if new position is empty:
			if(gameBoard[x2][y2] == null) {
				
				if(isPathEmpty(gameBoard, x1, y1, x2, y2)) {
					return true;
				}
				
				else {
					return false;
				}
			}
			
			//new position is not empty
			else {
				
				//checks if team of both pieces
				if(gameBoard[x1][y1].getTeam() == gameBoard[x2][y2].getTeam()) {
					return false;
				}
				
				else {
					if(isPathEmpty(gameBoard, x1, y1, x2, y2)) {
						return true;
					}
					
					else {
						return false;
					}
				}
			}
		}
		
		//illegal move for bishop
		else {
			return false;
		}
	}
	
	/**
	 * isPathEmpty() checks if the path is clear for the Bishop to move from its current position to the new position
	 * @param gameBoard
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * 
	 * @return true if the path is clear otherwise false
	 */
	private boolean isPathEmpty(Piece gameBoard[][], int x1, int y1, int x2, int y2) {
		int rowOffset, colOffset;
		
		if(x1 < x2){
			rowOffset = 1;
		}else{
			rowOffset = -1;
		}
		
		if(y1 < y2){
			colOffset = 1;
		}else{
			colOffset = -1;
		}
		
		int y = y1 + colOffset;
		for(int x = x1 + rowOffset; x != x2; x += rowOffset){
			
			if(gameBoard[x][y] != null){
				return false;
			}
			
			y += colOffset;
		}
		return true;
	}
}
