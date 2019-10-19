package Chess;

public class King extends Piece {
	public char team;
	public String type = "King";
	boolean firstM = true;
	
	public King(char team) {
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
}
