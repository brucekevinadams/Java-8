/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 *
 * Java program from a Hackerrank problem.
*/

import java.util.Scanner;

public class CountLuck {
    static private int count = 0;
    static private int[] dx = {1, 0, -1, 0};
    static private int[] dy = {0, 1, 0, -1};

    private static boolean dfs(char[][] board, int sx, int sy, int M, int N) {
        if (sx < 0 || sx >= M || sy < 0 || sy >= N || board[sx][sy] == 'X' || board[sx][sy] == '@')
            return false;
        if (board[sx][sy] == '*')
            return true;
        int choices = countDirection(board, sx, sy, M, N);
        if (choices == 0)
            return false;
        char rollback = board[sx][sy];
        board[sx][sy] = '@';
        for (int i = 0; i < 4; i++) {
            int tx = sx + dx[i];
            int ty = sy + dy[i];
            if (dfs(board, tx, ty, M, N)) {
                if (choices > 1)
                    count++;
                return true;
            }
        }
        board[sx][sy] = rollback;
        return false;
    }

    private static int countDirection(char[][] board, int sx, int sy, int M, int N) {
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int tx = sx + dx[i];
            int ty = sy + dy[i];
            if (tx < 0 || tx >= M || ty < 0 || ty >= N || board[tx][ty] == 'X' || board[tx][ty] == 'M' || board[tx][ty] == '@')
                continue;
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int M = sc.nextInt();
            int N = sc.nextInt();
            char[][] board = new char[M][N];
            int sx = -1, sy = -1, tx = -1, ty = -1;
            for (int i = 0; i < M; i++) {
                String line = sc.next();
                board[i] = line.toCharArray();
                for (int j = 0; j < N; j++) {
                    if (board[i][j] == 'M') {
                        sx = i;
                        sy = j;
                    }
                }
            }
            int K = sc.nextInt();
            dfs(board, sx, sy, M, N);
            if (count == K)
                System.out.println("Impressed");
            else
                System.out.println("Oops!");
            count = 0;
        }
    }
}
