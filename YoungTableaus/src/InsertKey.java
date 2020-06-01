import java.util.Arrays;
import java.util.Scanner;

public class InsertKey{
public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[][] { { 2, 3, 12, 14 }, { 4, 8, 16, Integer.MAX_VALUE }, { 5, 9, Integer.MAX_VALUE, Integer.MAX_VALUE }, 
			{ Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE } };
		int m = arr.length;
		int n = arr[0].length;
		System.out.println("Enter element to be inserted");
		int key = sc.nextInt();
		sc.close();
		insert_key(arr, key, m - 1, n - 1);
	}

public static int[][] insert_key(int a[][],int k,int m1, int n1)
  {
	int i,j,y;
	if(a[m1-1][n1-1]!=Integer.MAX_VALUE)
	 {
		 System.out.println("Cannot insert element");
		 return a;
	 }
	 a[m1-1][n1-1]= k;
	 i=m1-1;
	 j=n1-1;
	  while((i>0)&&(j>0))
	  {
	    if((k>a[i-1][j]) && (k>a[i][j-1]))
		   return a;
	    else
		   if((k<a[i-1][j])||(k<a[i][j-1]))
		   {
		     if(a[i][j-1]<=a[i-1][j])
		     {
			   y=a[i-1][j];
			   a[i-1][j]=a[i][j];
			   a[i][j]=y;
			   i--;
		     }
		     else 
		     {
			   y=a[i][j-1];
			   a[i][j-1]=a[i][j];
			   a[i][j]=y;
			   j--;
		     }
		   }
		 }
	 System.out.println("The element is inserted at a["+ i + "][" + j+"]");
	 System.out.println(Arrays.deepToString(a).replace("[[", "").replace("], ", "\n").replace("[", "").replace("]]", ""));
	
	 return a;
  }
}
