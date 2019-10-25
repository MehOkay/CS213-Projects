package Chess;

/**
 * The Queen class is an extension of the Piece class and creates a Queen piece.
 * @author Wesley Cheung
 * @author Dennis Yu
 *
 */

public class Queen extends Piece {
	public char team;
	public String type = "Queen";

	public Queen(char team) {
		this.team = team;
	}
	public char getTeam() {
		return this.team;
	}
	public String getType() {
		return this.type;
	}
	
	/**
<<<<<<< HEAD
	 * checkMove() takes in the game board, current row, current column, new row, 
	 * and new column as parameters and returns true if new position is a valid move for Queen
	 * 
	 * @param gameBoard is the game board
=======
	 * check() takes in the game board, current row, current column, new row, and new column as parameters and returns true if new position is a valid move for Queen
	 * 
	 * @param gameBoard is the current game board
>>>>>>> 9cb27b83be933784d06ab775ad0a73cb050b3724
	 * @param x1 is the current row
	 * @param y1 is the current column
	 * @param x2 is the new row
	 * @param y2 is the new column
	 * 
	 * @return true if move is valid or false if not
	 */
<<<<<<< HEAD
	
=======
>>>>>>> 9cb27b83be933784d06ab775ad0a73cb050b3724
	public boolean checkMove(Piece gameBoard[][], 
			int x1, int y1, 
			int x2, int y2) {
		
		return new Rook(team).checkMove(gameBoard, x1, y2, x2, y2) 
				|| new Bishop(team).checkMove(gameBoard, x1, y1, x2, y2);
		
	}
}