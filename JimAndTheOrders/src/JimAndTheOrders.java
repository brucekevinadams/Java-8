/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 *
 * Java program from a Hackerrank problem.
*/

import java.util.*;

public class JimAndTheOrders {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < n; i++) {
            int t = in.nextInt();
            int d = in.nextInt();
            int f = t + d;//finish time
            if (map.containsKey(f)) {
                List<Integer> list = map.get(f);
                list.add(i + 1);
                map.put(f, list);
            } else {
                List<Integer> list = new ArrayList<>(Arrays.asList(i + 1));
                map.put(f, list);//f_time, i-th
            }
        }
        List<Map.Entry<Integer, List<Integer>>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, List<Integer>>>() {
            public int compare(Map.Entry<Integer, List<Integer>> e1, Map.Entry<Integer, List<Integer>> e2) {

                return e1.getKey().compareTo(e2.getKey());
            }
        });
        for (Map.Entry e : list) {
            for (Integer i : (List<Integer>) e.getValue()) {
                System.out.print(i + " ");
            }
        }
    }
}
