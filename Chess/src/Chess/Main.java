package Chess;
import java.util.Scanner;
<<<<<<< HEAD
=======

/**
 * The Main class runs the full game
 * @author Wesley Cheung
 * @author Dennis Yu
 */
>>>>>>> 552b1af11c0d1511cd3327d36a91cc3cd22d0a99

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
<<<<<<< HEAD
					System.out.println("Invalid move\n");
=======
					System.out.println("Invalid move, try again\n");
>>>>>>> 552b1af11c0d1511cd3327d36a91cc3cd22d0a99
					continue;
				}
			}
			else if(input.length() == 7) {
<<<<<<< HEAD
				if(!Game.specialMove(input)) {
					System.out.println("Invalid move\n");
=======
				if(!Game.promotion(input)) {
					System.out.println("Invalid move, try again\n");
>>>>>>> 552b1af11c0d1511cd3327d36a91cc3cd22d0a99
					continue;
				}
			} 
			else {
<<<<<<< HEAD
				System.out.println("Invalid move\n");
=======
				System.out.println("Invalid move,try again\n");
>>>>>>> 552b1af11c0d1511cd3327d36a91cc3cd22d0a99
				continue;
			}
			
			Game.printBoard();
		}
	}

}
