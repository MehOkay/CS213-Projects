package Chess;
import java.math.*;
/**
 * The Pawn class is an extension of the Piece class and creates a Pawn Piece.
 * @author Wesley Cheung
 * @author Dennis Yu
 */

public class Pawn extends Piece {
	private char team;
	private String type = "Pawn";
	public boolean enPass;
	
	public Pawn(char team) {
		this.team = team;
		this.enPass = false;
	}
	public char getTeam() {
		return this.team;
	}
	public String getType() {
		return this.type;
	}

	
	/**
	 * checkMove() takes in the game board, current row, current column, new row, 
	 * and new column as parameters and returns true if new position is a valid move for Pawn
	 * 
	 * @param gameBoard is the game board
	 * @param x1 is the current row
	 * @param y1 is the current column
	 * @param x2 is the new row
	 * @param y2 is the new column
	 * 
	 * @return true if move is valid or false if not
	 */
	public boolean checkMove(Piece gameBoard[][], int x1, int y1, 
			int x2, int y2) {
		
		//pawns cannot go backward
		if(gameBoard[x1][y1].getTeam() == 'w') {
			if(x1 > x2)
				return false;
		}
		else{
			if(x2 > x1)
				return false;
		}
		
		//white 
		if(gameBoard[x1][y1].getTeam() == 'w') {
			//move
			if(y1 == y2) {
				//Destination is open
				if(gameBoard[x2][y2] == null) {
					//two forward
					if(x1 - x2 == -2) {
						//can only move 2 from first row
						if(x1 == 6) {
							//nothing in between
							if(gameBoard[x2-1][y2] == null) {
								this.enPass = true;
								return true;
							}
							else return false;
						}
						else return false;
					}
					//1 forward
					else if(x1 - x2 == -1) {
						return true;
					}
					//more than 2 forward
					else
						return false;
				}
				//path blocked
				else return false;
			}
			//kill 
			else {
				//if black piece exists in 1 diagonal
				if((gameBoard[x2][y2] != null && gameBoard[x2][y2].getTeam() == 'b')
						&& (Math.abs(y1-y2) == 1 && Math.abs(x1-x2) == 1)) {
					return true;
				}
				else 
					return false;
			}
		}
		//black
		else{
			if(y1 == y2) {
				//Destination is open
				if(gameBoard[x2][y2] == null) {
					//two forward
					if(x1 - x2 == 2) {
						//first row
						if(x1 == 1) {
							//nothing in between
							if(gameBoard[x2+1][y2] == null) {
								this.enPass = true;
								return true;
							}
							else return false;
						}
						else return false;
					}
					else if(x1 - x2 == 1) {
						return true;
					}
					//more than 2 forward
					else
						return false;
				}
				//path blocked
				else return false;
			}
			//kill 
			else {
				//if white piece exists in 1 diagonal
				if((gameBoard[x2][y2] != null && gameBoard[x2][y2].getTeam() == 'w')
						&& (Math.abs(y1-y2) == 1 && Math.abs(x1-x2) == 1)) {
					return true;
				}
				else 
					return false;
			}
		}
	}
	
	/**
	 * Convert returns the new Piece to replace promoted Pawn
	 * @param team is either B or 
	 * @param promotion is the type of piece
	 * @return new Piece
	 */
	
	public Piece convert(char team, char promotion) {
		switch(promotion) {
		case 'R':
			return new Rook(team); 
		case 'N':
			return new Knight(team);
		case 'B':
			return new Bishop(team);
		default:
			return new Queen(team);
		}
	}

}

