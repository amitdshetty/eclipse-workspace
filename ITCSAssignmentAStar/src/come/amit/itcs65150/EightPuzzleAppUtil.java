package come.amit.itcs65150;

import java.util.Arrays;
import java.util.Scanner;

/**
 * This class contains common utilities that are used by the app
 * @author Amit
 * @since 2019-02-10
 */

public class EightPuzzleAppUtil {
	
	/**
	 * This constant determines how long each heuristic technique will run based on the size of the Priority Queue
	 * This will not be required if the goal state is not given by the user and is kept at the standard solution for the 8 puzzle problem.
	 * If the solution is fixed mathematical inversion (http://www.cs.bham.ac.uk/~mdr/teaching/modules04/java2/TilesSolvability.html) 
	 * can be applied to check if solution is possible
	 * NOTE: Set it to a high enough number based on the solution needed. A lower value will prematurely end the program without giving the solution
	 */
	public static final int THRESHOLD = 20000;
	
	/**
	 * Method prints the following variables per expanded node 
	 * The current state of the puzzle
	 * g(n) ==> Current level of the tree
	 * f(n) ==> The distance A star algorithm uses to calculate the next best move 
	 * @param gameStatesBean ==> The current state of the puzzle game
	 */
	public static <T extends GameStatesBean> void printMoveStats(T gameStatesBean) {
		System.out.println(Arrays.deepToString(gameStatesBean.stateOfPuzzle).replace("[", "").replace("], ", "\n").replace("[[", "").replace("]]", "").replace(",", "\t"));
		System.out.println("\ng(n) ==> " 		+ gameStatesBean.level);
		System.out.println("f(n) ==> " 		+ gameStatesBean.aStarDistance + "\n");
	}
	
	/**
	 * Common method that takes input from user. Contains sanity check for input.
	 * User cannot enter an input less than 0 or greater than 8
	 * If they do, the program exits with a 'Try Again' Message
	 * @param input java.util.Scanner class object
	 */
	public static int[][] generate2dArrayFromUserInput(Scanner input) {
		int[][] puzzleInput = new int[3][3];
		for (int i = 0; i < puzzleInput.length; i++) {
			for (int j = 0; j < puzzleInput[i].length; j++) {
				puzzleInput[i][j] = input.nextInt();
				if(puzzleInput[i][j] < 0 || puzzleInput[i][j]/9 > 0) {
					System.out.println("Invalid Entry. Try Again...");
					System.exit(0);
				}
			}
		}
		return puzzleInput;
	}
	
	/**
	 * Moves the 0 element by swapping
	 * @param currentPuzzlePlay Current state of the game
	 * @param row1				Current row position of 0
	 * @param column1				Current column position of 0
	 * @param row2				Current row position of element to be swapped
	 * @param column2				Current column position of element to be swapped
	 * @return					The puzzle with the move applied
	 */
	public static int[][] movePiece(int[][] currentPuzzlePlay, int row1, int column1, int row2, int column2) {
		int tmp = currentPuzzlePlay[row1][column1];
		currentPuzzlePlay[row1][column1] = currentPuzzlePlay[row2][column2];
		currentPuzzlePlay[row2][column2] = tmp;
		return currentPuzzlePlay;
	}
}
