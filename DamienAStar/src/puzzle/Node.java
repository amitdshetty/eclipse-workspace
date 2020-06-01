package puzzle;

import java.io.IOException;

public class Node {
	public Matrix Mat;
	public int action; //0-3, 4 root node
	private int estimatedCost;
	private int actualCost=0;
	public Node parent=null, sons[];//=new Node[4];
	
	public int ECost(){return estimatedCost;}
	public int ACost(){return actualCost;}
	
	public void ExploreSons(){ //action: up, down, left and right // 0,1,2,3
			try {
				sons= new Node[4];
				if(Mat.X()!=0) //up
					sons[0]=new Node(this,0);
				if(Mat.X()!=2) //down
					sons[1]=new Node(this,1);
				if(Mat.Y()!=0) //left
					sons[2]=new Node(this,2);
				if(Mat.Y()!=2) //right
					sons[3]=new Node(this,3);
			}
			catch (IOException e) 
			{e.printStackTrace();}
	}
	
	public Node(Node Parent, int action) throws IOException{
		parent=Parent;
		if(parent!=null) actualCost=parent.ACost();
		this.action=action;
		if(null!=Parent)
			Mat=new Matrix(Parent.Mat);
		else { 
			Mat=new Matrix();
			estimatedCost=Mat.Dist();
		}
		if(action==4) return;
		//action: up, down, left and right // 0,1,2,3
		switch(action){
		case 0: {
			Mat.M[Mat.X()][Mat.Y()]=Mat.M[Mat.X()-1][Mat.Y()];
			Mat.setX(Mat.X()-1); 
			Mat.M[Mat.X()][Mat.Y()]=0;
			actualCost++;
			Mat.Check0();
			break;
			}
		case 1: {
			Mat.M[Mat.X()][Mat.Y()]=Mat.M[Mat.X()+1][Mat.Y()];
			Mat.setX(Mat.X()+1); 
			Mat.M[Mat.X()][Mat.Y()]=0;  
			actualCost++;
			Mat.Check0();
			break;
			}
		case 2: {
			Mat.M[Mat.X()][Mat.Y()]=Mat.M[Mat.X()][Mat.Y()-1];
			Mat.setY(Mat.Y()-1);
			Mat.M[Mat.X()][Mat.Y()]=0; 
			actualCost++;
			Mat.Check0();
			break;
			}
		case 3: {
			Mat.M[Mat.X()][Mat.Y()]=Mat.M[Mat.X()][Mat.Y()+1];
			Mat.setY(Mat.Y()+1);
			Mat.M[Mat.X()][Mat.Y()]=0;
			actualCost++;
			Mat.Check0();
			break;
			}
		default: break;
		}
		estimatedCost=Mat.Dist();		
	}
	
	
	public int PathCost(){return estimatedCost+actualCost;}
}
