package com.monthlychallengemay.day30;

import java.util.PriorityQueue;

public class KPointsClosestToOrigin {

	public int[][] kClosest(int[][] points, int K) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
			int dist_a = (int) (Math.pow(a[0], 2) + Math.pow(a[1], 2));
			int dist_b = (int) (Math.pow(b[0], 2) + Math.pow(b[1], 2));

			return dist_a - dist_b;
		});
		
		int[][] res = new int[K][2];
		
		for(int i = 0; i< points.length; i++) {
			pq.offer(new int[] {points[i][0], points[i][1]});
		}
		
		for(int j = K; j > 0; j--) {
			int[] temp = pq.poll();
			res[j][0] = temp[0];
			res[j][1] = temp[1];
			
		}
		
		return res;
	}

}
