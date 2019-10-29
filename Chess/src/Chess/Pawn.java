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
	private boolean enPass;
	
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
	public boolean getPas() {
		return this.enPass;
	}
	public void setPas() {
		enPass = false;
	}
	/*
	public boolean checkMove(Piece gameBoard[][], int x1, int y1, int x2, int y2) {
		System.out.println("pawn");
		return true;
	}*/
	
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
	
	public boolean checkMove(Piece gameBoard[][], int x1, int y1, int x2, int y2) {
	
		//pawns cannot go backward
		if(gameBoard[x1][y1].getTeam() == 'b') {
			if(x1 > x2) {
				System.out.print(1);
				return false;
				}
		}
		else{
			if(x2 > x1) {
				System.out.println(2);
				return false;
			}
		}
		//white 
		if(gameBoard[x1][y1].getTeam() == 'w') {
			//move
			if(y1 == y2) {
				//Destination is open
				if(gameBoard[x2][y2] == null) {
					//two forward
					if(x1 - x2 == 2) {
						//can only move 2 from first row
						if(x1 == 6) {
							//nothing in between
							if(gameBoard[x2+1][y2] == null) {
								this.enPass = true;
								return true;
							}
							else {System.out.print("w2");
							return false;}
						}
						else {System.out.print("w3");
						return false;}
					}
					//1 forward
					else if(x1 - x2 == 1) {
						this.setPas();
						return true;
					}
					//more than 2 forward
					else {System.out.print("w4");
					return false;}
				}
				//path blocked
				else {System.out.print("w5");
				return false;}
			}
			//kill 
			else {
				//pawns can only kill 1 diagonal away
				if(Math.abs(y1-y2) == 1 && Math.abs(x1-x2) == 1) {
					//En passant
					/*
					if(gameBoard[x2][y2] == null) {
						Pawn pawn = (Pawn)gameBoard[x1][y2];
						if(pawn.getPas()) {
							pawn.setPas();
							gameBoard[x2][y2] = pawn;
							gameBoard[x1][y1] = null;
							return true;
						}
						else {
							{System.out.print("w6");
							return false;}
						}
					
					}
					*/
					//normal kill
					if(gameBoard[x2][y2] != null && gameBoard[x2][y2].getTeam() == 'b') {
						this.setPas();
						return true;
					}
					else {System.out.print("w7");
					return false;}
				}
			}
			System.out.print("w8");
			return false;
		}
		
		//black
		else{
			//move
			if(y1 == y2) {
				//Destination is open
				if(gameBoard[x2][y2] == null) {
					//two forward
					if(x1 - x2 == -2) {
						//first row
						if(x1 == 1) {
							//nothing in between
							if(gameBoard[x2-1][y2] == null) {
								this.enPass = true;
								return true;
							}
							else {System.out.print("b2");
							return false;}
						}
						else {System.out.print("b3");
						return false;}
					}
					else if(x1 - x2 == -1) {
						this.setPas();
						return true;
					}
					//more than 2 forward
					else{System.out.print("b4");
					return false;}
				}
				//path blocked
				else {System.out.print("b5");
				return false;}
			}
			//kill 
			else {
				//pawns can only kill 1 diagonal away
				if(Math.abs(y1-y2) == 1 && Math.abs(x1-x2) == 1) {
					//En passant
					/*
					if(gameBoard[x2][y2] == null) {
						Pawn pawn = (Pawn)gameBoard[x1][y2];
						if(pawn.getPas()) {
							pawn.setPas();
							gameBoard[x2][y2] = pawn;
							gameBoard[x1][y1] = null;
							return true;
						}
						else {
							{System.out.print("b6");
							return false;}
						}
					
					}
					*/
					//normal kill
					if(gameBoard[x2][y2] != null && gameBoard[x2][y2].getTeam() == 'w') {
						this.setPas();
						return true;
					}
					else {System.out.print("b7");
					return false;}
				}
			}
		}
		System.out.println("end");
		return false;
	}
	
}

