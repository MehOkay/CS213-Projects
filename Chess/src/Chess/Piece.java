package Chess;

public abstract class Piece {
	public String type;
	public char team;
	
	public abstract char getTeam();
	public abstract String getType();
	public abstract boolean check(Piece gameBoard[][], 
			int x1, int y1, 
			int x2, int y2);
}
