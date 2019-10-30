package Chess;

public class board {
	
	private Piece[][] gameBoard = new Piece[8][8];
	private boolean inPlay;
	private int turns = 0;
	
	public board() {
		this.inPlay = true;
		this.setBoard();
	}
	
	public void setBoard() {		
		for(int i = 0; i < 8; i++) {
			gameBoard[1][i] = new Pawn('b');
			gameBoard[6][i] = new Pawn('w'); 
		}
		gameBoard[0][0] = new Rook('b');
		gameBoard[0][7] = new Rook('b');
		gameBoard[0][1] = new Knight('b');
		gameBoard[0][6] = new Knight('b');
		gameBoard[0][2] = new Bishop('b');
		gameBoard[0][5] = new Bishop('b');
		gameBoard[0][3] = new Queen('b');
		gameBoard[0][4] = new King('b');
		gameBoard[7][0] = new Rook('w');
		gameBoard[7][7] = new Rook('w');
		gameBoard[7][1] = new Knight('w');
		gameBoard[7][6] = new Knight('w');
		gameBoard[7][2] = new Bishop('w');
		gameBoard[7][5] = new Bishop('w');
		gameBoard[7][3] = new Queen('w');
		gameBoard[7][4] = new King('w');
		for(int x = 2; x < 6; x++)
			for(int y = 1; y < 8; y++)
				gameBoard[x][y] = null;
	}
	
	public boolean getInPlay() {
		return this.inPlay;
	}
	
	public int getTurns() {
		return this.turns;
	}
	
	public boolean isEmpty(int x, int y) {
		return gameBoard[x][y] == null;
	}
	
	/**
	 * Moves Piece onto new spot on board
	 * incorporates castling
	 * @param move - input of movement
	 * @return whether movement successful or not
	 */
	public boolean movePiece(String move) {
		
		if(move.length() > 5)
			return false;
		
		int x1, y1, x2, y2;
		x1 = 7 - (move.charAt(1) - 49);
		y1 = yTran(move.charAt(0));
		x2 = 7 - (move.charAt(4) - 49);
		y2 = yTran(move.charAt(3));
		
		//System.out.println(x1 + " " + y1 + "   " + x2 + " " + y2);
		//Checks if desired move is out of bounds
		if((x1 > 8 || x1 < 0) || (x2 > 8 || x2 < 0) ||
				(y1 > 8 || y1 < 0) || (y2 > 8 || y2 < 0)) {
			System.out.println("out of bounds");
			return false;
		}
		
		//if no piece is being moved
		if(this.isEmpty(x1, y1)) {
			System.out.println("empty");
			return false;
		}
		
		//same spot
		if(x1 == x2 && y1 == y2){
			System.out.println("same");
			return false;
		}
		
		/*En passant
		 * Conditions 
		 * 	first piece must be Pawn 
		 * 	movement must be 1 diagonal
		 * 	space must be empty
		 * 	second piece must be pawn 
		 * 	second piece must be next to First
		 * 	must have enPass Enabled
		 *  
		 */
		if(gameBoard[x1][y1].getType().equals("Pawn") && (Math.abs(y1-y2) == 1 && Math.abs(x1-x2) == 1) &&
				gameBoard[x2][y2] == null && gameBoard[x1][y2] != null &&
				gameBoard[x1][y2].getType().equals("Pawn")) {
			Pawn pawn = (Pawn)gameBoard[x1][y2];
			if(!pawn.getPas())
				return false;
			else {
				if((turns % 2 == 0 && gameBoard[x1][y1].getTeam() == 'w') ||
					(turns % 2 == 1 && gameBoard[x1][y1].getTeam() == 'b'))
				gameBoard[x2][y2] = gameBoard[x1][y1];
				gameBoard[x1][y2] = null;
				gameBoard[x1][y1] = null;
				turns++;
				return true;
			}
		}			
		
		
		/*Castle - only applies to rook and king of same color
		 * Conditions
		 * 	first Piece must be a King
		 *  second Piece must be a Rook
		 *  they must both be the same Color
		 *  Both Pieces cannot be Moved prior to castle
		 *  not Pieces can be in between them
		*/
		//King, Rook, Same color
		if((gameBoard[x1][y1].getType().equals("King") && 
				gameBoard[x2][y2].getType().equals("Rook")) && 
				gameBoard[x1][y2].getTeam() == gameBoard[x2][y2].getTeam()) {
			System.out.println("in");
			King king = (King)gameBoard[x1][y1];
			Rook rook = (Rook)gameBoard[x2][y2];
			//King or Rook already moved
			if(king.getMoved() || rook.getMoved()) {
				System.out.println("here1");
				return false;}
			//right side
			else if(y2 == 7) {
				//Checks if path is clear
				for(int i = 5; i < 7; i++) {
					if(gameBoard[x1][i] != null) {
						System.out.println("here2");
						return false;
					}
				}
				king.setMoved();
				rook.setMoved();
				gameBoard[x2][6] = king;
				gameBoard[x2][5] = rook;
				gameBoard[x1][y1] = null;
				gameBoard[x2][y2] = null;
				turns++;
				return true;
				
			}
			//left side
			else if(y2 == 0){
				//Checks if path is clear
				for(int i = 1; i < 4; i++) {
					if(gameBoard[x1][i] != null) {
						System.out.println("here3");
						return false;
					}
				}
				king.setMoved();
				rook.setMoved();
				gameBoard[x1][2] = king;
				gameBoard[x1][3] = rook;
				gameBoard[x1][y1] = null;
				gameBoard[x2][y2] = null;
				turns++;
				return true;
			}
		}
		
		//Confirm Move
		if(gameBoard[x1][y1].checkMove(gameBoard, x1, y1, x2, y2)) {
			gameBoard[x2][y2] = gameBoard[x1][y1];
			gameBoard[x1][y1] = null;
			turns++;
			return true;
		}
		else {
			System.out.println("Failed");
			return false;
		}
	}

	/**
	 * Turns pawn into desired Piece
	 * @param move - input of movement and Piece desired
	 * @return whether promotion was successful
	 */
	public boolean promotion(String move) {
		if(move.length() > 7)
			return false;
		int x1, y1, x2, y2;
		char team, type = move.charAt(7);
		x1 = Math.abs(move.charAt(0) - 56);
		y1 = yTran(move.charAt(1));
		x2 = Math.abs(move.charAt(3));
		y2 = yTran(move.charAt(4));
		
		
		//Checks if desired move is out of bounds
		if((x1 > 8 || x1 < 1) || (x2 > 8 || x2 < 1) ||
				(y1 > 8 || y1 < 1) ||(y2 > 8 || y2 < 1) )
			return false;
		//Check if legit piece
		if(type != 'R' && type != 'N' && type != 'B' && type != 'Q')
			return false;
		//Piece must be a pawn
		if(!gameBoard[x1][y1].getType().equals("Pawn"))
			return false;
		//movement can only be in a column
		if(y1 != y2)
			return false;
		//piece infront of pawn
		if(gameBoard[x2][y2] != null)
			return false;
		team = gameBoard[x1][y2].getTeam();
		
		switch(type) {
		case 'R':
			gameBoard[x2][y2] = new Rook(team); 
		case 'N':
			gameBoard[x2][y2] = new Knight(team);
		case 'B':
			gameBoard[x2][y2] = new Bishop(team);
		default:
			gameBoard[x2][y2] = new Queen(team);
		}
		gameBoard[x1][y1] = null;		
		turns++;
		return true;
	}
	
	/**
	 * Checks to see if the king of the given color is in check. Needs to be called twice after every move
	 * @param gameBoard
	 * @param team
	 * @return boolean value corresponding to the king being in check
	 */
	
	public boolean check(Piece gameBoard[][], char team){
		int[] kingPos = getKingPosition(gameBoard, team);
		int row = kingPos[0];
		int col = kingPos[1];
		
		//White king
		if(gameBoard[row][col].getTeam() == 'w') {
			
	        for(int x = 0; x<gameBoard.length; x++){
	            for(int y = 0; y<gameBoard[0].length; y++){
	            	
	                if(gameBoard[x][y] != null){
	                	if(gameBoard[x][y].getTeam() == 'b') {
	                		 if(gameBoard[x][y].checkMove(gameBoard, x, y, row, col)){
	 	                        return true;
	 	                    }
	                	}
	                   
	                }
	            }
	        }
		}
		//Black King
		else if (gameBoard[row][col].getTeam() == 'b') {
	        
			for(int x = 0; x<gameBoard.length; x++){
	            for(int y = 0; y<gameBoard[0].length; y++){
	            	
	                if(gameBoard[x][y] != null){
	                	if(gameBoard[x][y].getTeam() == 'w') {
	                		 if(gameBoard[x][y].checkMove(gameBoard, x, y, row, col)){
	 	                        return true;
	 	                    }
	                	}
	                   
	                }
	            }
	        }
		}
		
		return false;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean checkmate() {
		return false;
	}

	//Prints out current state of Board
	public void printBoard() { 
		for(int x = 0; x < 8; x++) {
			for(int y = 0; y < 8; y++) {
				if(gameBoard[x][y] == null) {
					if(x % 2 == 0)
						if (y % 2 == 1)
							System.out.print("## ");
						else
							System.out.print("   ");
					else
						if(y % 2 == 0)
							System.out.print("## ");
						else
							System.out.print("   ");
				}
				else {
					String p = "";
					if(gameBoard[x][y].getTeam() == 'w')
						p += 'w';
					else
						p += 'b';
					String type = gameBoard[x][y].getType();
					switch (type) {
					case "Pawn": p += "p"; break;
					case "Rook": p += "R"; break;
					case "Knight": p += "N"; break;
					case "Bishop": p += "B"; break;
					case "Queen": p += "Q";	break;
					case "King":p += "K"; break;
					default: break;					
					}
					System.out.print(p + " ");
				}
			}
			System.out.print(8 - x + "\n");
		}
		System.out.print(" a  b  c  d  e  f  g  h ");
	}
	
	/**
	 * Translates the Y coordinate from char to int 
	 * @param Y coordinate in char
	 * @return Y coordinate in int
	 */
	public int yTran(char i) { 
		switch (i) {
			case 'a':return 0;
			case 'b':return 1;
			case 'c':return 2;
			case 'd':return 3;
			case 'e':return 4;
			case 'f':return 5;
			case 'g':return 6;
			case 'h':return 7;
			default:return 8;
		}
	}
	
	/**
	 * Gets the position of a given team's King piece
	 * @param gameBoard
	 * @param team
	 * @return int array corresponding to a King's row and column. The first element is the row and second element is the column. 
	 */
	private int [] getKingPosition(Piece[][] gameBoard, char team) {
		
		int[] kingPos = new int[2];
		int kingRow = 0, kingCol = 0;
		
		for (int i = 0; i < gameBoard.length; i++) {
			for(int j = 0; j < gameBoard[0].length; j++) {
				if(gameBoard[i][j] != null) {
					if( (gameBoard[i][j] instanceof King) && (gameBoard[i][j].getTeam() == team)) {
						kingRow = i;
						kingCol = j;
						break;
					}
				}
			}
		}
		
		kingPos[0] = kingRow;
		kingPos[1] = kingCol;
		
		return kingPos;
	}
}