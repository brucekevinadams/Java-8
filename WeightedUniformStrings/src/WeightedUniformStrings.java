import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WeightedUniformStrings {

    static String[] weightedUniformStrings(String s, int[] queries) {

        s = s + "\0";
        int[] char_num = new int[27];
        int local_len = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                char_num[s.charAt(i - 1) - 'a' + 1] = Math.max(char_num[s.charAt(i - 1) - 'a' + 1], local_len);
                local_len = 1;
            } else local_len++;
        }

        String[] ans = new String[queries.length];

        for (int i = 0; i < queries.length; i++) {
            boolean flag = false;
            int j = 1;
            while (j < char_num.length) {
                if (char_num[j] > 0 && queries[i] % j == 0 && queries[i] / j <= char_num[j]) {
                    ans[i] = "Yes";
                    flag = true;
                    break;
                }
                j++;
            }
            if (!flag) ans[i] = "No";
        }
        return ans;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String fileName = "output.txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true));
        String s = scanner.nextLine();

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] queries = new int[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            int queriesItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            queries[i] = queriesItem;
        }

        String[] result = weightedUniformStrings(s, queries);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.append(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
