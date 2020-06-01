import java.util.Scanner;

public class FindKey {

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[][] { { 2, 3, 12, 14 }, { 4, 8, 16, Integer.MAX_VALUE }, { 5, 9, Integer.MAX_VALUE, Integer.MAX_VALUE }, 
			{ Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE } };
		int m = arr.length;
		int n = arr[0].length;
		System.out.println("Enter element to find");
		int key = sc.nextInt();
		sc.close();
		find(arr, m, n, key);
	}

	public static void find(int[][] t, int m, int n, int key) {
		int i = m - 1, j = 0;
		int x = 0;
		while (i >= 0 && j < n) {
			if (t[i][j] == key) {
				System.out.println("Element at [" + i + ", " + j + "] position");
				x = 1;
				break;
			}

			else if (t[i][j] < key)
				j++;
			else
				i--;
		}
		if (x == 0)
			System.out.println("Element does not exist");
	}
}
