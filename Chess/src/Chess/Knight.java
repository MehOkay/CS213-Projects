package Chess;

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
	
	public boolean checkMove(Piece gameBoard[][], 
			int x1, int y1, 
			int x2, int y2) {
		
		if(checkHelper(gameBoard, x1, y1, x2, y2) == true) {
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
		
		else {
		//not a valid Knight move
			return false;
		}
	}
	
	private boolean checkHelper(Piece gameBoard[][], 
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