import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author amitshetty
 * Problem Statement : 
 * Split any number given by the user into its individual digits
 */

public class NumberSplitterApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in  = new Scanner(System.in);
		System.out.println("Enter a number to split");
		int number  = in.nextInt();
		if(number <= 0) {
			System.out.println("Please enter a number greater than zero");
			System.exit(1);
		}
		List<Integer> splitWise = new ArrayList<>();
		splitWise = splitTheNumber(number, splitWise);
		Collections.reverse(splitWise);
		System.out.println("The final Solution ==> " + Arrays.toString(splitWise.toArray()));
	}

	public static List<Integer> splitTheNumber(int n, List<Integer> l) {
		int m = n % 10;
		l.add(m);
		int o = n / 10;
		if (o > 0) {
			splitTheNumber(o, l);
		}
		return l;
	}

}
