
import java.util.Arrays;

public class KClosestDevice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] x = { -1, 2, -4, 2, 4 };
		int[] y = { 1, 2, -4, 2, -1 };
		int k = 4;

		int n1 = x.length;
		int n2 = y.length;

		if (n1 != n2) {
			System.out.println("Invalid entry");
			System.exit(0);
		} else {
			double[] z = new double[n1];
			for (int i = 0; i < n1; i++) {
				z[i] = Math.sqrt(Math.pow(x[i], 2) + Math.pow(y[i], 2));
			}
			Arrays.sort(z);
			System.out.println("Result for 4th position is " + Math.ceil(z[k - 1]));
		}

	}

}
