/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 * 
Anna and Brian are sharing a meal at a restaurant and they agree to split the bill equally. Brian wants to order
something that Anna is allergic to though, and they agree that Anna won't pay for that item. Brian gets the check
and calculates Anna's portion. You must determine if his calculation is correct.

For example, assume the bill has the following prices: bill = [2,4,6]. Anna declines to eat item k = bill[2] which
costs 6. If Brian calculates the bill correctly, Anna will pay (2 + 4) /2 = 3. If he includes the cost of bill[2],
he will calculate (2+4+6)/2 = 6 . In the second case, he should refund 3 to Anna.

You are given an array of prices, bill , the cost of each of the n items, k, the item Anna doesn't eat, and b, the
total amount of money that Brian charged Anna for her portion of the bill. If the bill is fairly split, 
print Bon Appetit. Otherwise, print the integer amount of money that Brian must refund to Anna.

Input Format

The first line contains two space-separated integers n and k, the number of items ordered and the 0-based index
of the item that Anna did not eat.
The second line contains n space-separated integers where bill[i] where 0 <= i < n .
The third line contains an integer, b, the amount of money that Brian charged Anna for her share of the bill.
*/
import java.util.Scanner;

public class BonAppetit {

    @SuppressWarnings("boxing")
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int total = 0;
        
        for (int i = 0; i < n; i++) {
            int price = scanner.nextInt();
            if (i != k) total += price;
        }
        
        int charged = scanner.nextInt();
        
        System.out.println(total / 2 == charged ? "Bon Appetit" : charged - (total/2));
        scanner.close();
    }
}