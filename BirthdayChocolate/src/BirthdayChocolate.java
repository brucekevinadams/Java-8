/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 * 
This Java 8 program is from a Hackerrank problem.
*/

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class BirthdayChocolate {

    // Complete the birthday function below.
    static int birthday(int n, int[] s, int d, int m) {
        int startingIndex = 0;
        int result = 0;
        int total = 0;

        for (int i = 0; i < n; i++) {
            startingIndex = i;

            try {
                for (int j = 0; j < m; j++) {
                    total += s[startingIndex + j];
                }
            } catch (Exception e) {
                break;
            }

            if (total == d) {
                result++;
            }
            total = 0;
        }
        return result;
    }


    public static void main(String[] args) throws IOException {
        String fileName = "output.txt";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true));
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        String[] dm = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d = Integer.parseInt(dm[0]);
        int m = Integer.parseInt(dm[1]);

        // We must convert the List of s to an Int array by creating the int[] array arr_s,
        // otherwise it doesn't parse the List properly when sent as a parameter to the 
        // birthday function above
        int[] arr_s = s.stream().mapToInt(Integer::intValue).toArray();
        int result = birthday(n, arr_s, d, m);

        bufferedWriter.write(String.valueOf(result));
        System.out.println(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
