import java.util.HashMap;
import java.util.Scanner;

public class LargestPermutation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, k, i, count;
        HashMap<Integer, Integer> hm = new HashMap<>();
        n = sc.nextInt();
        int[] a = new int[n];
        k = sc.nextInt();
        for (i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            hm.put(a[i], i);
        }
        count = 0;
        i = 0;
        while (i < n && count < k) {
            int hold = hm.get(n - i);
            if (i != hold) {
                hm.put(n - i, i);
                hm.put(a[i], hold);
                int temp = a[i];
                a[i] = a[hold];
                a[hold] = temp;
                count += 1;
            }
            i += 1;
        }
        for (i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

}