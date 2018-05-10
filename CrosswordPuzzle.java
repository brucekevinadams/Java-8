import java.util.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CrosswordPuzzle {

	private static void print(char[][] board) {
		for (int r = 0; r < 10; r++) {
			System.out.println(new String(board[r]));
		}
		// System.out.println();
	}

	private static boolean solve(char[][] board, List<String> words, List<Integer[]> h, List<Integer[]> v,
			Set<String> used) {

		if (used.size() == words.size()) {
			print(board);
			return true;
		}

		for (String w : words) {
			if (!used.contains(w)) {

				// HORIZONTAL

				for (Integer[] pos : h) {
					@SuppressWarnings("boxing")
					int row = pos[0];
					@SuppressWarnings("boxing")
					int col = pos[1];
					// System.out.print("Testing position "+row+","+col+" for word "+w+"...");
					boolean fit = true;

					// Backup
					char[] backup = Arrays.copyOf(board[row], 10);

					// Place the word
					for (int i = col; i < col + w.length(); i++) {
						if (i >= 10 || board[row][i] == '+'
								|| (board[row][i] != '-' && board[row][i] != w.charAt(i - col))) {
							fit = false;
							break;
						}
						board[row][i] = w.charAt(i - col);
					}

					// System.out.println("fit="+fit);

					// Recursive call
					if (fit) {
						used.add(w);
						boolean found = solve(board, words, h, v, used);

						if (found) {
							return true;
						}

						used.remove(w);
					}

					// Restore
					board[row] = Arrays.copyOf(backup, 10);
				}

				// VERTICAL

				for (Integer[] pos : v) {
					@SuppressWarnings("boxing")
					int row = pos[0];
					@SuppressWarnings("boxing")
					int col = pos[1];
					boolean fit = true;

					// Backup
					char[] backup = new char[10];
					for (int r = 0; r < 10; r++) {
						backup[r] = board[r][col];
					}

					// Place the word
					for (int i = row; i < row + w.length(); i++) {
						if (i >= 10 || board[i][col] == '+'
								|| (board[i][col] != '-' && board[i][col] != w.charAt(i - row))) {
							fit = false;
							break;
						}
						board[i][col] = w.charAt(i - row);
					}

					// System.out.println("fit="+fit);

					// Recursive call
					if (fit) {
						used.add(w);
						boolean found = solve(board, words, h, v, used);

						if (found) {
							return true;
						}
						used.remove(w);
					}

					// Restore
					for (int r = 0; r < 10; r++) {
						board[r][col] = backup[r];
					}
				}

			}
		}

		return false;
	}

	@SuppressWarnings("boxing")
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/eclipse-workspace/CrosswordPuzzle/src/" + "in.txt"));
		Scanner in = new Scanner(System.in);

		char[][] board = new char[10][10];
		for (int r = 0; r < 10; r++) {
			board[r] = in.next().toCharArray();
		}

		String[] w = in.next().split(";");

		List<String> words = new ArrayList<String>();
		for (String word : w) {
			words.add(word);
		}

		List<Integer[]> h = new ArrayList<Integer[]>();
		List<Integer[]> v = new ArrayList<Integer[]>();
		for (int r = 0; r < 10; r++) {
			for (int c = 0; c < 10; c++) {
				if (board[r][c] == '-') {
					// HORIZONTAL
					// Go all the way to the left
					int start = c;
					while (start > 0 && board[r][start - 1] == '-') {
						start--;
					}
					h.add(new Integer[] { r, start });

					// VERTICAL
					// Go all the way up
					start = r;
					while (start > 0 && board[start - 1][c] == '-') {
						start--;
					}
					v.add(new Integer[] { start, c });
				}
			}
		}

		solve(board, words, h, v, new HashSet<String>());
		in.close();
	}

}
