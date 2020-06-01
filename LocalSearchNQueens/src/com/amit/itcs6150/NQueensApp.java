package com.amit.itcs6150;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author amitshetty
 *
 */

public class NQueensApp {

	public static int calculateHeuristicCost(int[] currentBoard) {

		int hCost = 0;
		// increment cost if two queens are in same row or in same diagonal.
		for (int i = 0; i < currentBoard.length; i++) {
			for (int j = i + 1; j < currentBoard.length; j++) {
				if (currentBoard[i] == currentBoard[j] || Math.abs(currentBoard[i] - currentBoard[j]) == j - i) {
					hCost += 1;
				}
			}
		}

		return hCost;
	}

	public static int[] generateRandomStartState(int numberOfQueens) {
		int[] board = new int[numberOfQueens];
		for (int i = 0; i < board.length; i++) {
			board[i] = (int) (Math.random() * board.length);
		}
		return board;
	}

	public static int[] solveUsingSteepestHillClimb(int numberOfQueens, int numberOfIterations) {
		int[] chessBoard = generateRandomStartState(numberOfQueens);
		System.out.println("Initial State ==> ");
		printFinalBoard(numberOfQueens, chessBoard);
		int heuristicCost = calculateHeuristicCost(chessBoard);
		int processedCount = 0;

		for (int i = 0; i < numberOfIterations; i++) {
			if (heuristicCost <= 0) {
				break;
			} else {
//				int tempHeuristicCost = heuristicCost;
				for (int j = 0; j < numberOfQueens; j++) {
					for (int k = 0; k < numberOfQueens; k++) {
						if (k == chessBoard[j]) {
							continue;
						}
						int[] chessBoardCopy = Arrays.copyOf(chessBoard, numberOfQueens);
						chessBoardCopy[j] = k;
						int getCurrentCostOfBoard = calculateHeuristicCost(chessBoardCopy);
						if (heuristicCost > getCurrentCostOfBoard) {
							chessBoard[j] = k;
							heuristicCost = getCurrentCostOfBoard;
							break;
						}
					}
				}
//				TBD : Check if local maxima has been reached. Not sure if steepest hill climbing allows for recall of new start state
//				if (tempHeuristicCost == heuristicCost) {
//					chessBoard = generateRandomStartState(numberOfQueens);
//				}
			}
			processedCount++;
		}
		System.out.println("Number of Iterations that have been processed ==> " + processedCount);
		if (heuristicCost == 0) {
			return chessBoard;
		}
		return null;
	}

	public static void main(String[] args) {
		int noOfQueens = 0;
		int noOfIterations = 0;
		boolean testFlag = true;
		if (testFlag) {
			noOfQueens = 8;
			noOfIterations = 300;
			System.out.println("Current Run ==> ");
			System.out.println("Number of Queens ==> " + noOfQueens);
			System.out.println("Number if Iterations ==> " + noOfIterations);
		} else {
			Scanner in = new Scanner(System.in);
			System.out.println("Enter the number of queens you want to place on the board");
			noOfQueens = in.nextInt();
			System.out.println("Enter the number of iterations you would like to solve the problem in");
			noOfIterations = in.nextInt();
		}
		if (noOfQueens <= 0) {
			System.out.println("You have entered an invalid input for the number of queens. Please try again.");
			System.exit(1);
		} else if (noOfIterations <= 0) {
			System.out.println("Please enter a number greater than 0 for the number of iterations and try again");
			System.exit(1);
		} else {
			int[] solution;
			do {
				solution = solveUsingSteepestHillClimb(noOfQueens, noOfIterations);
			} while(solution == null);
			if(testFlag) {
				System.out.println(Arrays.toString(solution));
			}
			printFinalBoard(noOfQueens, solution);
		}
	}

	public static void printFinalBoard(int noOfQueens, int[] chessBoard) {
		if (chessBoard != null && chessBoard.length > 0) {
			String[][] finalBoard = new String[noOfQueens][noOfQueens];
			for (int i = 0; i < finalBoard.length; i++) {
				for (int j = 0; j < finalBoard[i].length; j++) {
					finalBoard[i][j] = "_";
					if (j == chessBoard[i])
						finalBoard[i][chessBoard[i]] = "Q";
				}
			}
			System.out.println(Arrays.deepToString(finalBoard).replace("], [", "\n").replace("[[", "").replace("]]", "").replace(",", ""));
		} else {
			System.out.println("Solution could not be found");
		}
	}

}