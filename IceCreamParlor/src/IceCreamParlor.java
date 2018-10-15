/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 * Java 8 program
 * Hackerrank problem
*/

import java.util.*;

public class IceCreamParlor {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            int numberOfTestCases = scanner.nextInt();
            for (int i = 0; i < numberOfTestCases; i++) {
                buyIcecream(scanner);
            }
        }
    }

    private static void buyIcecream(Scanner scanner) {

        int m = scanner.nextInt();
        int n = scanner.nextInt();
        ArrayList<Integer> costTable = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int price = scanner.nextInt();
            costTable.add(price);
        }

        Map<Integer, List<Integer>> positionMap = new HashMap<>();
        for (int i = 0; i < costTable.size(); i++) {
            Integer price = costTable.get(i);
            positionMap.putIfAbsent(price, new ArrayList<>());
            positionMap.get(price).add(i);
        }

        int lower = 0;
        int higher = 0;

        int slider = 0;
        boolean found = false;
        while (slider < costTable.size() && !found) {

            int leftvalue = costTable.get(slider);
            int lookup = m - leftvalue;
            List<Integer> positions = positionMap.get(lookup);
            if (positions != null) {
                Integer max = Collections.max(positions);
                if (slider < max) {
                    found = true;
                    lower = slider;
                    higher = max;
                }
            }
            slider++;
        }

        System.out.printf("%d %d%n", lower + 1, higher + 1);
    }

}