import java.util.*;

public class DynamicArrays {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int Q = scan.nextInt();
		ArrayList<Integer>[] seqList = new ArrayList[N];

		int lastAnswer = 0;

		for (int i = 0; i < Q; i++) {
			int queryNo = scan.nextInt();
			int x = scan.nextInt();
			int y = scan.nextInt();

			lastAnswer = performQuery(seqList, N, queryNo, x, y, lastAnswer);
		}
		
		scan.close();
	}

	public static int performQuery(ArrayList[] seqList, int N, int queryNo, int x, int y, int lastAnswer) {

		int seqIndex = (x ^ lastAnswer) % N;
		if (seqList[seqIndex] == null) {
			seqList[seqIndex] = new ArrayList<Integer>();
		}

		if (queryNo == 1) {
			seqList[seqIndex].add(y);
		}

		else if (queryNo == 2) {
			int elementIndex = (y % (seqList[seqIndex].size()));
			lastAnswer = (int) seqList[seqIndex].get(elementIndex);
			System.out.println(lastAnswer);
		}

		return lastAnswer;
	}
}