package Chess;
import java.util.Scanner;

/**
 * The Main class runs the full game
 * @author Wesley Cheung
 * @author Dennis Yu
 */

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		board Game = new board(); 
		Game.setBoard();
		Game.printBoard();
		Scanner in = new Scanner(System.in);
		while(Game.getInPlay()) {
			String input;
			if(Game.getTurns() % 2 == 1) 
				System.out.println("White's Move: ");
			
			else
				System.out.println("Black's Move: ");
			input = in.nextLine();
			if(input.length() == 5) {
				if(!Game.movePiece(input)) {

					System.out.println("Invalid move, try again\n");
					continue;
				}
			}
			else if(input.length() == 7) {

				if(!Game.promotion(input)) {
					System.out.println("Invalid move, try again\n");
					continue;
				}
			} 
			else {

				System.out.println("Invalid move,try again\n");

				continue;
			}
			
			Game.printBoard();
		}
	}

}
