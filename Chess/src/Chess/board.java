package Chess;

public class board {
	
	private Piece[][] gameBoard = new Piece[8][8];
	private boolean inPlay;
	//private String[][] shownBoard = new String[8][8];
	
	public board() {
		this.inPlay = true;
	}
	
	public void setBoard() {		
		for(int i = 0; i < 8; i++) {
			gameBoard[1][i] = new Pawn('b', 1, i);
			gameBoard[6][i] = new Pawn('w', 6, i); 
		}
		gameBoard[0][0] = new Rook('b', 0, 0);
		gameBoard[0][7] = new Rook('b', 0, 7);
		gameBoard[0][1] = new Knight('b', 0, 1);
		gameBoard[0][6] = new Knight('b', 0, 6);
		gameBoard[0][2] = new Bishop('b', 0, 2);
		gameBoard[0][5] = new Bishop('b', 0, 5);
		gameBoard[0][3] = new Queen('b', 0, 3);
		gameBoard[0][4] = new King('b', 0, 4);
		gameBoard[7][0] = new Rook('w', 7, 0);
		gameBoard[7][7] = new Rook('w', 7, 7);
		gameBoard[7][1] = new Knight('w', 7, 1);
		gameBoard[7][6] = new Knight('w', 7, 6);
		gameBoard[7][2] = new Bishop('w', 7, 2);
		gameBoard[7][5] = new Bishop('w', 7, 5);
		gameBoard[7][3] = new Queen('w', 7, 3);
		gameBoard[7][4] = new King('w', 7, 4);
	}
	
	public boolean movePiece(String move) {
		if(move.length() > 5)
			return false;
		int x1, y1, x2, y2;
		x1 = Math.abs(move.charAt(0) - 56);
		y1 = yTran(move.charAt(1));
		x2 = Math.abs(move.charAt(3));
		y2 = yTran(move.charAt(4));
		if((x1 > 8 || x1 < 1) || (x2 > 8 || x2 < 1) ||
				(y1 > 8 || y1 < 1) ||(y2 > 8 || y2 < 1) )
			return false;
		if(gameBoard[x1][y1].check(x1,y1,x2,y2)) {
			gameBoard[x1][y1].move(x2,y2);
			gameBoard[x2][y2] = gameBoard[x1][y1];
			gameBoard[x1][y1] = null;
			return true;
		}
		else
			return false;
	}
	
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
					if(gameBoard[x][y].team == 'w')
						p += 'w';
					else
						p += 'b';
					String type = gameBoard[x][y].type;
					switch (type) {
					case "Pawn":
						p += "p";
						break;
					case "Rook":
						p += "R";
						break;
					case "Knight":
						p += "N";
						break;
					case "Bishop":
						p += "B";
						break;
					case "Queen":
						p += "Q";
						break;
					case "King":
						p += "K";
						break;
					default: 
						break;					
					}
					System.out.print(p + " ");
				}
			}
			System.out.print(8 - x + "\n");
		}
		System.out.print(" a  b  c  d  e  f  g  h ");
	}
	
	public int yTran(char i) {
		int val; 
		switch (i) {
			case 'a':
				return 0;
			case 'b':
				return 1;
			case 'c':
				return 2;
			case 'd':
				return 3;
			case 'e':
				return 4;
			case 'f':
				return 5;
			case 'g':
				return 6;
			case 'h':
				return 7;
			default:
				return 8;
		}
	}
}
