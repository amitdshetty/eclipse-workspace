package puzzle;
import java.io.FileWriter;

public class Queue {
	private Elem prvi = null;
	private Elem goal;
	public boolean PrviNULL(){return prvi==null;}
	public Elem Prvi(){return prvi;}
	public void Prvi(Elem tek){prvi=tek;}
	public void QInsert(Node V){new Elem(V);}
	public int Explore(){ 
 		Elem tek=prvi;
		prvi=prvi.sled;
		if (tek.nod.ECost()!=0){
			tek.nod.ExploreSons();
			for(int i=0; i<4; i++)
				if(tek.nod.sons[i]!=null) 
					QInsert(tek.nod.sons[i]);
			return 0;
		}		
		else goal=tek;
		return 1;
	}
	
	public void RUN(){
		int i=1;
		FileWriter fWriter = null;
	    try {
		    fWriter = new FileWriter("8_puzzle_solution.txt");
		    fWriter.close();
	    } catch (Exception e){}
		while (Explore()!=1);// System.out.println("Iteration:"+ i++);
		goal.nod.Mat.PrintM();
		System.out.println("Success!"); //delete
		Node hlp=goal.nod;
		while(hlp!=null){
			hlp.Mat.WriteTXT();
			hlp=hlp.parent;
		}
		//goal.nod.Mat.WriteTXT();
	}
	public class Elem {
	    Node nod; 
	    Elem sled = null;
	    Elem(Node v) {
	      nod = v;
	      if (PrviNULL()){ prvi = this; return;}
	      Elem tek=Prvi(), pret=null;
	      if(tek.nod.PathCost()>=v.PathCost()) { 
	    	  this.sled=tek;
	    	  Prvi(this);
	    	  return;
	      }
	      else
	      while(tek.nod.PathCost()<v.PathCost()){ //2nd pass, dafaq?
	    	  pret=tek; 
	    	  tek=tek.sled;
	    	  if(tek==null) break; //Y null, Y
	      }
	      this.sled = tek; 
	      if(pret!=null) pret.sled=this;
	    }
	}
	
}
