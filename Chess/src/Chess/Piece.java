package Chess;

public class Piece {
	public String type;
	public char team;
	public int x;
	public int y;
	
	public Piece(String type, char team, int x, int y) {
		this.type = type;
		this.team = team;
		this.x = x;
		this.y = y;
	}
	
}
