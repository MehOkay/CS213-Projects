package Chess;

public class Pawn extends Piece {
	public char team;
	public String type = "Pawn";
	boolean firstM = true;
	
	public Pawn(char team) {
		this.team = team;
	}
	public char getTeam() {
		return this.team;
	}
	public String getType() {
		return this.type;
	}
	
	public boolean check(Piece gameBoard[][], 
			int x1, int y1, 
			int x2, int y2) {
		
		return true; 
	}
	/*
	public boolean check(int x2, int y2) {
		//first move
		if(this.firstM) {
			this.firstM = false;
			if(this.team == 'b') {
				if(y2 - this.y == 2 || y2 - this.y == 1)
					return true;
				else 
					return false;
			}
			else if(this.team == 'w') {
				if(y2 - this.y == -2 || y2 - this.y == -1)
					return true;
				else 
					return false;
			}
			else 
				return false;		
		}
		//move and kill
		if(this.team == 'b') {
			if(y2 - this.y == 1)
				if(x2 - this.x == 1 || x2 - this.x == 0)
					return true;
				else 
					return false;
			else 
				return false;
		}
		else if(this.team == 'w') {
			if(y2 - this.y == -1)
				if(x2 - this.x == 1 || x2 - this.x == 0)
					return true;
				else 
					return false;
			else 
				return false;
		}
		return true;
	}
	
	public void convert() {
	}
	*/
}

