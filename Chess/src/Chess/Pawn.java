package Chess;

public class Pawn extends Piece {
	
	public Pawn(char team, int x, int y) {
		super("Pawn", team, x ,y);
	}
	public boolean move(int x, int y) {
		if(this.y - y != 1) {
			return false;
		}
		else 
			this.x ++;
		return true;
	}
	public boolean check(int x1, int y1, int x2, int y2) {
		
		
	}
	
	public void convert() {
		
	}
}
