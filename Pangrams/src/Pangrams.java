import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Pangrams {

    // Complete the pangrams function below.
    private static String pangrams(String s) {
        boolean pangram = false;
        String test = s.toLowerCase();
        char alpha[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
                'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        int arrVal[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < 26; i++) {

            for (int j = 0; j < test.length(); j++) {
                pangram = false;
                char c = test.charAt(j);
                if (c == alpha[i]) {
                    arrVal[i] = 1;
                }
            }
        }

        for (int i = 0; i < 26; i++)
            if (arrVal[i] == 0) {
                pangram = Boolean.parseBoolean("false");
                break;
            } else pangram = true;
        if (pangram) return "pangram";
        else return "not pangram";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String output = "output.txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(output));

        String s = scanner.nextLine();

        String result = pangrams(s);

        bufferedWriter.write(result);
        System.out.println(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}