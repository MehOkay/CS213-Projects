package Chess;

/**
 * The Rook class is an extension of the Piece class and creates a Rook Piece.
 * @author Wesley Cheung
 * @author Dennis Yu
 *
 */

public class Rook extends Piece {
	private char team;
	private String type = "Rook";
	private boolean hasMoved;
	
	public Rook(char team) {
		this.team = team;
		this.hasMoved = false;
	}
	public char getTeam() {
		return this.team;
	}
	public String getType() {
		return this.type;
	}
	public boolean getMoved() {
		return this.hasMoved;
	}
	/**
	 * checkMove() takes in the game board, current row, current column, new row, 
	 * and new column as parameters and returns true if new position is a valid move for Rook
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
		
		//check if valid move for a Rook
		if((x1 == x2 || y1 == y2 ) && !((x1 == x2) && (y1 == y2))) {
			
			//check if new position is empty:
			if(gameBoard[x2][y2] == null) {
				
				if(isPathEmpty(gameBoard, x1, y1, x2, y2)) {
					this.hasMoved = true;
					return true;
				}
				
				else {
					return false;
				}
			}
			
			//new position is not empty
			else {
				
				//checks team of both pieces
				if(gameBoard[x1][y1].getTeam() == gameBoard[x2][y2].getTeam()) {
					return false;
				}
				
				else {
					if(isPathEmpty(gameBoard, x1, y1, x2, y2)) {
						this.hasMoved = true;
						return true;
					}
					
					else {
						return false;
					}
				}
			}
		}
		
		else {
			return false;
		}
	}
	
	/**
	 * isPathEmpty() checks if the path is clear for the Rook to move from its current position to the new position
	 * @param gameBoard
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * 
	 * @return true if the path is clear otherwise false
	 */
	private boolean isPathEmpty(Piece gameBoard[][], int x1, int y1, int x2, int y2) {
		int offset;
		
		if(x1 != x2){
			if(x1 < x2){
				offset = 1;
			}else{
				offset = -1;
			}
			
			for(int x = x1 + offset; x != x2; x += offset){
				//Go from currentRow to newRow, and check every space
				if(gameBoard[x][y1] != null){
					return false;
				}
			}
		}
		
		//Now do the same for columns
		if(y1 != y2){
			if(y1 < y2){
				offset = 1;
			}else{
				offset = -1;
			}
			
			for(int y = y1 + offset; y != y2; y += offset){
				
				//Go from currentCol to newCol, and check every space
				if(gameBoard[x1][y] != null){
					return false;
				}
			}
		}
		
		return true;
	}
	
}
