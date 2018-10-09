import java.util.Scanner;

public class AlternatingCharacters {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testcases = in.nextInt();

        for (int i = 1; i <= testcases; i++) {
            String test = in.next();
            int count = 0;
            for (int j = 0; j < test.length() - 1; j++) {
                if (test.charAt(j) == test.charAt(j + 1))
                    count++;
            }
            System.out.println(count);
        }
    }

}