package come.amit.itcs65150;

import java.util.ArrayList;

/**
 * The class performance the movements of the 8 puzzle game while at the same time generating the child nodes for each move.
 * The best move for each level is calculated on the basis of the Manhattan Distance concept where the distance between the 
 * tile in the current puzzle state and its counterpart in the goal state are calculated
 * 
 * @author Amit
 * @since 2019-02-10
 */
public class GameStatesBeanH2 extends GameStatesBean implements Comparable<GameStatesBeanH2> {

	public GameStatesBeanH2(int[][] array, int level) {
		int lengthOfArray = array.length;
		this.stateOfPuzzle = new int[lengthOfArray][lengthOfArray];
		for (int i = 0; i < lengthOfArray; i++) {
			for (int j = 0; j < lengthOfArray; j++) {
				this.stateOfPuzzle[i][j] = array[i][j];
			}
		}
		this.level = level;
		this.aStarDistance = calculateManhattanDistance() + level;
	}

	/**
	 * Below function calculates the Manhattan distance(heuristic value) for each
	 * state or node. I.e the sum of the distances of the tiles from their goal
	 * positions
	 */
	private int calculateManhattanDistance() {
		int manhattanDistance = 0;
		int[] index = new int[2];
		int lengthOfArray = EightPuzzleApp.goalState.length;
		for (int i = 0; i < lengthOfArray; i++) {
			for (int j = 0; j < lengthOfArray; j++) {
				if (this.stateOfPuzzle[i][j] == 0) {
					continue;
				}
				index = checkPosition(EightPuzzleApp.goalState, this.stateOfPuzzle[i][j]);
				manhattanDistance += (Math.abs(i - index[0]) + Math.abs(j - index[1]));
			}
		}
		return manhattanDistance;
	}

	/**
	 * Returns the current position of the element in the puzzle state provided as argument
	 * @param currentPuzzleState The current puzzle state being processed
	 * @param element The element to be located in the current puzzle state
	 * @return The location of the element in the current puzzle state showing the X and Y co-ordinates in an array
	 * 
	 */
	public static int[] checkPosition(int[][] currentPuzzleState, int element) {
		int[] location = new int[2];
		for (int i = 0; i < currentPuzzleState.length; ++i) {
			for (int j = 0; j < currentPuzzleState.length; ++j) {
				if (currentPuzzleState[i][j] == element) {
					location[0] = i;
					location[1] = j;
				}
			}
		}
		return location;
	}
	
	/**
	 * Generates child nodes by searching for '0' which is the free space and moving it in all possible directions.
	 * For each of the movies the child puzzle state is added to the childNodeslist for further processing.
	 * @param parentNode Puzzle state that is currently being checked
	 * @return List of possible child states for the parentNode
	 */
	public ArrayList<GameStatesBeanH2> generatePossibleStates(GameStatesBeanH2 parentNode) {
		ArrayList<GameStatesBeanH2> childNodes = new ArrayList<GameStatesBeanH2>();
		/*
		 * Puzzle moves on an XY axis or in this case row-column axis 
		 * Up => column - 1 
		 * Down => column + 1
		 * Left => row - 1
		 * Right => row + 1
		 */

		for (int row = 0; row < 3; row++) {
			for (int column = 0; column < 3; column++) {
				if (parentNode.stateOfPuzzle[row][column] == 0) {
					//Up
					if (column - 1 >= 0) {
						int[][] a = new int[3][3];
						for (int row1 = 0; row1 < 3; row1++) {
							for (int column1 = 0; column1 < 3; column1++) {
								a[row1][column1] = parentNode.stateOfPuzzle[row1][column1];
							}
						}
						a = EightPuzzleAppUtil.movePiece(a, row, column, row, column - 1);
						addChildNodesToList(parentNode, childNodes, a);
					}
					//Down
					if (column + 1 < 3) {
						int[][] a = new int[3][3];
						for (int row2 = 0; row2 < 3; row2++) {
							for (int column2 = 0; column2 < 3; column2++) {
								a[row2][column2] = parentNode.stateOfPuzzle[row2][column2];
							}
						}
						a = EightPuzzleAppUtil.movePiece(a, row, column, row, column + 1);
						addChildNodesToList(parentNode, childNodes, a);
					}
					//Left
					if (row - 1 >= 0) {
						int[][] a = new int[3][3];
						for (int row3 = 0; row3 < 3; row3++) {
							for (int column3 = 0; column3 < 3; column3++) {
								a[row3][column3] = parentNode.stateOfPuzzle[row3][column3];
							}
						}
						a = EightPuzzleAppUtil.movePiece(a, row, column, row - 1, column);
						addChildNodesToList(parentNode, childNodes, a);
					}
					//Right
					if (row + 1 < 3) {
						int[][] a = new int[3][3];
						for (int row4 = 0; row4 < 3; row4++) {
							for (int column4 = 0; column4 < 3; column4++) {
								a[row4][column4] = parentNode.stateOfPuzzle[row4][column4];
							}
						}
						a = EightPuzzleAppUtil.movePiece(a, row, column, row + 1, column);
						addChildNodesToList(parentNode, childNodes, a);
					}
				}
			}
		}
		return childNodes;
	}
	
	/**
	 * For every move of the tiles, g(n) i.e. the current level of the puzzle is incremented by one for every expansion
	 * @param parentNode Puzzle state that is to be expanded
	 * @param childNodes List containing all possible moves from the parent node
	 * @param a 		 The puzzle state with the current up/down/left/right move 
	 */
	public void addChildNodesToList(GameStatesBeanH2 parentNode, ArrayList<GameStatesBeanH2> childNodes, int[][] a) {
		GameStatesBeanH2 childNode = new GameStatesBeanH2(a, parentNode.level + 1);
		childNodes.add(childNode);
	}
	
	/**
	 * The comparator determines the order in which the elements are accessed in the PriorotyQueue 
	 * which in this case is based on the Manhattan Distance
	 * @param gameStatesBean The bean containing the current puzzle state's misplaced tiles count
	 * @return Order of the bean in the Priority Queue based on the manhattan distance count
	 */
	@Override
	public int compareTo(GameStatesBeanH2 gameStatesBean) {
		return this.aStarDistance > gameStatesBean.aStarDistance ? 1 : this.aStarDistance < gameStatesBean.aStarDistance ? -1 : 0;
	}
}