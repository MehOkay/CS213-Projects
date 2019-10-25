package Chess;

public class King extends Piece {
	public char team;
	public String type = "King";
	
	public King(char team) {
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
		return true; 
	}
}
