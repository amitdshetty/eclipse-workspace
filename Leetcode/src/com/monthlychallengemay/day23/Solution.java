package com.monthlychallengemay.day23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> list = new ArrayList<>();
        int i = 0, j = 0;
        while(i < A.length && j < B.length){
            int maxStart = Math.max(A[i][0], B[j][0]);
            int minEnd = Math.min(A[i][1], B[j][1]);
            if(maxStart <= minEnd){
                list.add(new int[]{maxStart, minEnd});
            }
            // increment 1st set if end for first less than end for second
            if(A[i][1] < B[j][1]){
                i++;
            }
            else{
                j++;
            }
        }
        
        int[][] res = new int[list.size()][2];
        i = 0;
        for(int[] arr : list){
            res[i++] = arr;
        }
        
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
		int[][] A = { { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 } };
		int[][] B = { { 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 } };

		Solution sol = new Solution();
		int[][] result = sol.intervalIntersection(A, B);
		for (int i = 0; i < result.length; i++) {         //this equals to the row in our matrix.
	         for (int j = 0; j < result[i].length; j++) {   //this equals to the column in each row.
	            System.out.print(result[i][j] + " ");
	         }
	         System.out.println(); //change line on console as row comes to end in the matrix.
	      }
	}

}
