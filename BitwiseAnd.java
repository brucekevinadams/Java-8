import java.util.*;

public class BitwiseAnd {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			int k = in.nextInt();
			if (((k - 1) | k) > n && k % 2 == 0) {
				System.out.println(k - 2);
			} else {
				System.out.println(k - 1);
			}
		}
		in.close();
	}
}