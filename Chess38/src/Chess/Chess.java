package Chess;
import java.util.Scanner;

/**
 * The Main class runs the full game
 * @author Wesley Cheung
 * @author Dennis Yu
 */

public class Chess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		board Game = new board(); 
		Game.setBoard();
		Game.printBoard();
		boolean isWhiteInCheck = false;
		boolean isBlackInCheck = false;
		
		Scanner in = new Scanner(System.in);
		while(Game.getInPlay()) {
			String input;
			
			if(Game.getTurns() % 2 == 0) {
				if(isWhiteInCheck == true) {
					System.out.println("\n\nCheck");
				}
				System.out.println("\n\nWhite's Move: ");
			}
			else {
				if(isBlackInCheck == true) {
					System.out.println("\n\nCheck");
				}
				System.out.println("\n\nBlack's Move: ");
			}
			input = in.nextLine();
			if(input.length() == 5) {
				if(!Game.movePiece(input)) {
					System.out.println("Invalid move, try again");
					continue;
				}
			}
			else if(input.length() == 7) {

				if(!Game.promotion(input)) {
					System.out.println("Invalid move, try again");
					continue;
				}
			} 
			else {

				System.out.println("Invalid move,try again\n");

				continue;
			}
			
			Game.printBoard();
			
			//move is valid. now need to see if king is in check for either team
			//at this point, turn has increased by 1
			if(Game.getTurns() % 2 == 0) {
				if(Game.check(Game.getGameBoard(), 'w') == true) {
					isWhiteInCheck = true;
					if(Game.checkmate(Game.getGameBoard(), 'w') == true) {
						System.out.println("\n\nCheckmate, Black Wins!");
						return;
					}
				}
				else if(Game.check(Game.getGameBoard(), 'w') != true) {
					isWhiteInCheck = false;
				}
			}
			else if(Game.getTurns() % 2 != 0) {
				if(Game.check(Game.getGameBoard(), 'b') == true) {
					isBlackInCheck = true;
					if(Game.checkmate(Game.getGameBoard(), 'b') == true) {
						System.out.println("\n\nCheckmate, White Wins!");
						return;
					}
				}
				else if(Game.check(Game.getGameBoard(), 'b') != true) {
					isBlackInCheck = false;
				}
			}
			
		}
	}

}
