package Chess;

public class Queen extends Piece {
	public char team;
	public String type = "Queen";

	public Queen(char team) {
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
		
		return new Rook(team).checkMove(gameBoard, x1, y2, x2, y2) 
				|| new Bishop(team).checkMove(gameBoard, x1, y1, x2, y2);
		
	}
}