import java.util.Arrays;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		// This is to be used for testing
		int[][] startPuzzleState = { { 1, 2, 3 }, { 4, 5, 6 }, { 0, 7, 8 } };
		int[][] goalPuzzleState = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 0 } };
		int gOfN = 0;

		System.out.println("Start State : ");
		System.out.println(Arrays.deepToString(startPuzzleState).replace("[", "").replace("], ", "\n").replace("[[", "").replace("]]", ""));
		// System.out.println("\nGoal State : ");
		// System.out.println(Arrays.deepToString(goalPuzzleState).replace("[",
		// "").replace("], ", "\n").replace("[[", "").replace("]]", ""));
		if(isGoalStateReached(startPuzzleState,goalPuzzleState)) {
			System.out.println("Goal State has been reached");
			System.exit(0);
		}
		solveThis(startPuzzleState, goalPuzzleState, gOfN);
	}

	public static void solveThis(int[][] startPuzzleState, int[][] goalPuzzleState, int g) {
		//Increment by 1 for every move after selecting best heuristic
		g += 1;
		int[] currLocof0 = checkPosition(startPuzzleState, 0);
		System.out.println("Location of 0 is : " + Arrays.toString(currLocof0));
		/*
		 * Move puzzle block one step up down left and right Step 1 Prev position 0,0
		 * New Position 0,1 Swap positions with 0 for elements in all directions
		 */
		// transfer to temp array
		int[][] puzzlePlay1 = new int[3][3];
		int[][] puzzlePlay2 = new int[3][3];
		int[][] puzzlePlay3 = new int[3][3];
		int[][] puzzlePlay4 = new int[3][3];

		for (int i = 0; i < startPuzzleState.length; i++) {
			for (int j = 0; j < startPuzzleState[i].length; j++) {
				puzzlePlay1[i][j] = startPuzzleState[i][j];
				puzzlePlay2[i][j] = startPuzzleState[i][j];
				puzzlePlay3[i][j] = startPuzzleState[i][j];
				puzzlePlay4[i][j] = startPuzzleState[i][j];
			}
		}

		int[] temp = new int[1];
		// Co-ordinates of Zero
		int x = currLocof0[0];
		int y = currLocof0[1];
		boolean up = false;
		boolean down = false;
		boolean left = false;
		boolean right = false;
		//up down left right
		int[] operations = {x-1,x+1,y-1,y+1};
		if(operations[0] >= 0)
			up = true;
		if(operations[1] < 3)
			down = true;
		if(operations[2] >= 0)
			left = true;
		if(operations[3] < 3)
			right = true;
		//g(n)
		int[] heuristic = new int[4];
		// Up
		if (up) {
			temp[0] = puzzlePlay1[x][y];
			puzzlePlay1[x][y] = puzzlePlay1[x - 1][y];
			puzzlePlay1[x - 1][y] = temp[0];
			heuristic[0] = getHeuristic(puzzlePlay1, goalPuzzleState) + g;
		}
		// Down
		if(down) {
			temp[0] = puzzlePlay2[x][y];
			puzzlePlay2[x][y] = puzzlePlay2[x + 1][y];
			puzzlePlay2[x + 1][y] = temp[0];
			heuristic[1] = getHeuristic(puzzlePlay2, goalPuzzleState) + g;
		}
		// Left
		if(left) {
			temp[0] = puzzlePlay3[x][y];
			puzzlePlay3[x][y] = puzzlePlay3[x][y - 1];
			puzzlePlay3[x][y - 1] = temp[0];
			heuristic[2] = getHeuristic(puzzlePlay3, goalPuzzleState) + g;
		}
		// Right
		if(right) {
			temp[0] = puzzlePlay4[x][y];
			puzzlePlay4[x][y] = puzzlePlay4[x][y + 1];
			puzzlePlay4[x][y + 1] = temp[0];
			heuristic[3] = getHeuristic(puzzlePlay4, goalPuzzleState) + g;
		}
		
		System.out.println(Arrays.toString(heuristic));
		int bestHeuristicIndex = getMinimumHeuristic(heuristic);
		int[][] newStartState  = new int[3][3];
		
		switch(bestHeuristicIndex) {
			case 0:
				newStartState = puzzlePlay1;
				break;
			case 1:
				newStartState = puzzlePlay2;
				break;
			case 2:
				newStartState = puzzlePlay3;
				break;
			case 3:
				newStartState = puzzlePlay4;
		}
		
		//Check if puzzle has reached final goal
		if(isGoalStateReached(newStartState, goalPuzzleState) || g==1000) {
			System.out.println("Goal State Reached");
			System.out.println(Arrays.deepToString(newStartState).replace("[", "").replace("], ", "\n").replace("[[", "").replace("]]", ""));
		} else {
			System.out.println(Arrays.deepToString(newStartState).replace("[", "").replace("], ", "\n").replace("[[", "").replace("]]", ""));
			System.out.println("GofN : " + g);
			solveThis(newStartState, goalPuzzleState, g);
		}
		
		//Decide best puzzle 

//		System.out.println("After one move, child states");
//		System.out.println("Puzzle Play Up : ");
//		System.out.println(Arrays.deepToString(puzzlePlay1).replace("[", "").replace("], ", "\n").replace("[[", "").replace("]]", ""));
//		System.out.println("Puzzle Play Down : ");
//		System.out.println(Arrays.deepToString(puzzlePlay2).replace("[", "").replace("], ", "\n").replace("[[", "").replace("]]", ""));
//		System.out.println("Puzzle Play Left : ");
//		System.out.println(Arrays.deepToString(puzzlePlay3).replace("[", "").replace("], ", "\n").replace("[[", "").replace("]]", ""));
//		System.out.println("Puzzle Play Right : ");
//		System.out.println(Arrays.deepToString(puzzlePlay4).replace("[", "").replace("], ", "\n").replace("[[", "").replace("]]", ""));
	}
	
	public static int getMinimumHeuristic(int[] heuristic) {
		int smallest = Integer.MAX_VALUE;
		int index = 0;
		for (int i = 0; i < heuristic.length; i++) {
			for (int j = 0; j < heuristic.length; j++) {
				if(heuristic[i] > 0 && heuristic[i] < smallest) {
					smallest = heuristic[i];
					index = i;
				}
			}
		}
		System.out.println("The best heuristic is ==> " + smallest);
		return index;
	}
	
	public static int getHeuristic(int[][] childStateArray, int[][] goalArray) {
		int count = 0;
		for(int i=0; i<goalArray.length; i++) {
			for(int j = 0 ; j < goalArray[i].length; j++) {
				if(childStateArray[i][j] != goalArray[i][j])
					count++;
			}
		}
		return count - 1;
	}

	public static int[] checkPosition(int[][] array, int element) {
		int[] loc = new int[2];
		for (int i = 0; i < array.length; ++i) {
			for (int j = 0; j < array[i].length; ++j) {
				if (array[i][j] == element) {
					loc[0] = i;
					loc[1] = j;
				}
			}
		}
		return loc;
	}

	// Use this to check if goal state has been reached
	public static boolean isGoalStateReached(int[][] puzzleArray, int[][] goalPuzzleArray) {
		return Arrays.deepEquals(puzzleArray, goalPuzzleArray);
	}

	// To be used for getting user input later
	public static int[][] generate2dArrayFromUserInput() {
		int[][] puzzleInput = new int[3][3];
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the start state of the puzzle");
		for (int i = 0; i < puzzleInput.length; i++) {
			for (int j = 0; j < puzzleInput[i].length; j++) {
				puzzleInput[i][j] = in.nextInt();
			}
		}
		return puzzleInput;
	}
}
