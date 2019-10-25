package Chess;

public class Knight extends Piece {
	public char team;
	public String type = "Knight";
	boolean firstM = true;
	
	public Knight(char team) {
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