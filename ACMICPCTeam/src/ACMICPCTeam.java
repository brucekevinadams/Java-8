import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ACMICPCTeam {

    // Complete the acmTeam function below.
    static int[] acmTeam(String[] topic) {
        int attendance = topic.length;
        int prevCount = 0;
        int maxSuccess = 0;
        ArrayList<Integer> al = new ArrayList<Integer>();
        for (int i = 0; i < attendance - 1; i++) {
            for (int j = i + 1; j < attendance; j++) {
                int count = 0;
                for (int k = 0; k < topic[i].length(); k++) {
                    if ((topic[i].charAt(k) != '0') || (topic[j].charAt(k) != '0')) {
                        count++;
                    }
                }
                if (prevCount < count) {
                    prevCount = count;
                }
                al.add(count);
            }
        }
        System.out.println(al);
        for (int n : al) {
            if (n == prevCount) {
                maxSuccess++;
            }
        }
        int[] result = new int[2];
        result[0] = prevCount;
        result[1] = maxSuccess;
        return result;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String fileName = "output.txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName,true));
        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        String[] topic = new String[n];

        for (int i = 0; i < n; i++) {
            String topicItem = scanner.nextLine();
            topic[i] = topicItem;
        }

        int[] result = acmTeam(topic);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));
            System.out.println(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
