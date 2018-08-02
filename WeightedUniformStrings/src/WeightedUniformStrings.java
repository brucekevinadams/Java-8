/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 * 
 Java program from a Hackerrank problem. The program takes input in the form of a string of
 letters and then parses that string to find how many letters were entered and what their
 "weight" is. For example, an 'a' is weight 1, and a 'b' is weight 2, and so on until 'z' 
 which has weight 26. It adds up contiguous letters such as 'aaa' in the string for their
 weight, ('aaa' has weight of 3).
 Further, the program asks for how many weight queries the user will make, and then outputs whether
 those queries are in the input with a 'YES' or a 'NO'
 The program will append YES or NO to the end of the file output.txt.
*/

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
        System.out.println("How many queries?");
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
