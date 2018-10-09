import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

@SuppressWarnings("ALL")
public class BeautifulBinaryString {

    // Complete the beautifulBinaryString function below.
    static int beautifulBinaryString(String B) {
        int answer = ((B.length() - B.replaceAll("010", "").length()) / 3);
        return answer;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String output = "output.txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(output));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String b = scanner.nextLine();

        int result = beautifulBinaryString(b);

        bufferedWriter.write(String.valueOf(result));
        System.out.println(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}