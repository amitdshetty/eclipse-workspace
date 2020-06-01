package puzzle;
import java.lang.Math;
import java.io.*;

public class Matrix {
	private int x, y;
	public int M[][];
	private static int G[][]=new int[3][3];
	
	
	public int X(){return x;}
	public int Y(){return y;}
	public void setX(int a){x=a;}
	public void setY(int a){y=a;}
	
	public Matrix() throws IOException{
		M=new int[3][3];
		SetInitialState();
		Check0();
		//G=new int[3][3];
	}
	public Matrix(Matrix C){
		M=new int[3][3];
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
					M[i][j]=C.M[i][j];
		Check0();
	}
	
	public void Check0(){
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				if(M[i][j]==0)
				{ x=i; y=j; return;}
				
}
	public int Check(){
		int cnt=0;
		
		for(int x=0; x<9; x++)
lopz:		for(int i=0;i<3;i++)
				for(int j=0;j<3;j++)
					if(M[i][j]==cnt) {cnt++; break lopz;}
		if (cnt==9) 
		return 1;
		else return 0;
	}
	
	static public int CheckG(){
		int cnt=0;
		
		for(int x=0; x<9; x++)
lopz:		for(int i=0;i<3;i++)
				for(int j=0;j<3;j++)
					if(G[i][j]==cnt) {cnt++; break lopz;}
		if (cnt==9) 
		return 1;
		else return 0;
	}
	
	public int SetInitialState() throws IOException{ 
		BufferedReader br = new BufferedReader(
		new InputStreamReader(new FileInputStream("8_puzzle_initial.txt"))); //8_puzzle_goal.txt
		try {
		    String line; int i = 0;
		    while ((line = br.readLine()) != null) {
		    	M[i][0]=Character.getNumericValue(line.charAt(0));
			    M[i][1]=Character.getNumericValue(line.charAt(2));
				M[i][2]=Character.getNumericValue(line.charAt(4));
		        i++;
		    }
		} finally {
		    br.close();
		}
		Check0();
		return 1;
	} 
	public static int SetGoalState() throws IOException{ 
		BufferedReader br = new BufferedReader(
		new InputStreamReader(new FileInputStream("8_puzzle_goal.txt"))); //8_puzzle_goal.txt
		try {
			String line; int i = 0;
			while ((line = br.readLine()) != null) {
				G[i][0]=Character.getNumericValue(line.charAt(0));
			    G[i][1]=Character.getNumericValue(line.charAt(2));
				G[i][2]=Character.getNumericValue(line.charAt(4));
				i++;
			}
		} finally {
				    br.close();
		}
		return 1;
	}

	public void WriteTXT(){
	    FileWriter fWriter = null;
	    BufferedWriter writer = null;
	    try {
	    fWriter = new FileWriter("8_puzzle_solution.txt",true);
	    writer = new BufferedWriter(fWriter);
	    for(int i=0; i<3;i++){
	    	writer.write(M[i][0]+" "+M[i][1]+" "+M[i][2]);
	    	writer.newLine();
	    }
	    writer.newLine();
	    writer.close();
	    } catch (Exception e) {
	    }
	}
	public void PrintM(){
		System.out.print("***---***");
		for(int i=0;i<3;i++)
		{
			System.out.print("\n");
			for(int j=0;j<3;j++) 
				System.out.print(M[i][j]+"  ");
		}
		System.out.print("\n");
	}
	
	public int Dist(){ 
		int sum=0;
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				loopy:
				for(int k=0;k<3;k++)
					for(int l=0;l<3;l++)
						if(M[i][j]==G[k][l] && M[i][j]!=0){
							sum=sum+Math.abs(i-k)+Math.abs(j-l);
							break loopy;
						}
		return sum;
		}
	
}
