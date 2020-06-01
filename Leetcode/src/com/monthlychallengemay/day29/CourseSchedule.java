package com.monthlychallengemay.day29;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
	
	List<Integer>[] adj;
	boolean[] visited;
	boolean[] explored;

	@SuppressWarnings("unchecked")
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		
		adj = new ArrayList[numCourses];
		
		for(int i = 0; i < numCourses; i++) {
			adj[i] = new ArrayList<>();
		}
		
		/*
		 * This array shows which nodes were parsed while exploring neighbors
		 */
		visited = new boolean[numCourses];
		/*
		 * This array shows courses explored once all neighbors of one course are explored
		 */
		explored = new boolean[numCourses];
		
		for(int i = 0; i < prerequisites.length; i++) {
			adj[prerequisites[i][0]].add(prerequisites[i][1]);
		}
		
		for(int i = 0; i< numCourses; i++) {
			if(!visited[i]) {
				if(isCyclic(i)) {
					return false;
				}
			}
		}
		return true;

	}
	
	public boolean isCyclic(int courses) {
		
		visited[courses] = true;
		for(Integer course : adj[courses]) {
			if(!visited[course]) {
				if(isCyclic(course)) {
					return true;
				}
			} else if (!explored[course]) {
				return true;
			}
		}
		explored[courses] = true;
		return false;
	}
	
	public static void main(String[] args) {
		
		CourseSchedule cs = new CourseSchedule();
		//numCourses = 2, prerequisites = [[1,0],[0,1]]
		int numCourses = 2;
		int[][] prerequisites = {{1, 0}, {0, 1}};
		
		System.out.println(cs.canFinish(numCourses, prerequisites));
		
	}

}
