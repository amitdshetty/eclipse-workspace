import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class ExtractMin {

	public static void main(String args[]) {
		int m, n;
//		Scanner sc = new Scanner(System.in);
//		System.out.println("enter size of array");
//		m = sc.nextInt();
//		n = sc.nextInt();
		int[][] arr = new int[][] { { Integer.MAX_VALUE,7,3,8 }, { 7,4,3,Integer.MAX_VALUE}, { 5,4,Integer.MAX_VALUE,Integer.MAX_VALUE }};
		System.out.println("enter elements of array");
//		for (int i = 0; i < m; i++)
//			for (int j = 0; j < n; j++) {
//				arr[i][j] = sc.nextInt();
//			}
//		sc.close();
		System.out.println("input:");
		System.out.println(Arrays.deepToString(arr));
		System.out.println(Arrays.deepToString(extract_min(arr)));
	}

	public static int[][] extract_min(int [][]youngT){
	    int x = youngT[0][0];
	    youngT[0][0] = Integer.MAX_VALUE;
	    youngify(youngT, 0, 0, youngT.length, youngT[0].length);
	    return youngT;
	}

	public static void youngify(int [][] young_t, int i, int j, int m, int n) {
	    int x, y;
	    x = i;
	    y = j;
	    int temp;
	    if (i + 1 < m){
	        if (young_t[i][j] > young_t[i+1][j]){
	            x = i + 1;
	            y = j;
	        }
	    }
	     
	    if (j+1 < n){
	        if (young_t[x][y] > young_t[i][j+1]){
	            x = i;
	            y = j+1;
	        }
	    }
	     
	    if(x != i || y != j){
	        temp = young_t[x][y];
	        young_t[x][y] = young_t[i][j];
	        young_t[i][j] = temp;
	        youngify(young_t, x, y, young_t.length, young_t[0].length);
	    }
	}
}
