package com.monthlychallengemay.day25;

import java.util.stream.IntStream;

public class UncrossedLines {
	
    public int maxUncrossedLines(int[] A, int[] B) {
        int[][] dp = new int[A.length][B.length];
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < B.length; j++){
                dp[i][j] = -1;
            }
        }
        
        return lcs(A, B, 0, 0, dp);
    }
    
    
    int lcs(int[] A, int[] B, int i, int j, int[][] dp){
        if(i == A.length || j == B.length){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        if(A[i] == B[j]){
            return dp[i][j] = 1 + lcs(A, B, i + 1, j + 1, dp);
        }
        else{
            return dp[i][j] = Math.max(lcs(A, B, i + 1, j, dp), lcs(A, B, i, j + 1, dp));
        }
    }

	public int maxUncrossedLines1(int[] A, int[] B) {
		
		int localmax = Integer.MIN_VALUE;
		int globalmax = Integer.MIN_VALUE;
		int count = 0;
		
		for(int i = 0; i < A.length; i++) {
			// filter function variable needs to be a type of constant or final. 
			// Circumvented this by assigning the value
			int num = A[i];
			int bIndex = IntStream.range((localmax == Integer.MIN_VALUE) ? 0 : localmax + 1, B.length)
					.filter(j -> num == B[j])
					.findFirst()
					.orElse(-1);
			// if index is not found simply break from the current loop or in this case continue
			if(bIndex == -1)
				continue;
			if(bIndex > localmax) {
				count++;
			} else {
				globalmax = Math.max(globalmax, count);
				count = 1;
			}
			localmax = bIndex;
		}
		/*
		 * Running it one more time since the global max function will not run again till the end of the loop
		 */
		return Math.max(globalmax, count);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Loop through first array only check what index the value is at on the 2nd
		 * array and check if it is greater than max if it is then count + 1 and set it
		 * as new max if the value is less than the max reset counter and maintain
		 * global max run the max function once again for global max and return global
		 * max
		 */

		int[] A = { 2, 1, 2 };
		int[] B = { 2, 2, 2 };

		UncrossedLines ul = new UncrossedLines();
		System.out.println(ul.maxUncrossedLines(A, B));
	}

}
