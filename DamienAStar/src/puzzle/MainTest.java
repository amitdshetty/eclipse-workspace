package puzzle;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainTest {
	public static void SetUp(){
		try {
			Matrix.SetGoalState();
			Queue Q=new Queue();
			Node root=new Node(null,4);
			int x=root.Mat.Check();
			if(x==0) {System.out.println("Bad initial state input!"); return;}
			x=Matrix.CheckG();
			if(x==0) {System.out.println("Bad goal state input!"); return;}
			Q.QInsert(root);
			Q.RUN();
			return;
		} catch (IOException e){
			e.printStackTrace();
		}
		catch (OutOfMemoryError E){
			System.out.println("***Out of Memory!***");
			System.out.println("Puzzle too hard.");
		}
	}
	
	public static void main(String[] args) {
		SetUp();

	}

}
