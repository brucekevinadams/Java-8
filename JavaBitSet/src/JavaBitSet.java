/**

 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 *
 This is a HackerRank Java problem:
 Java's BitSet class implements a vector of bit values (i.e.: False(0) or True(1) ) that grows as needed, allowing
 us to easily manipulate bits while optimizing space (when compared to other collections). Any element having a bit
 value of is called a set bit.

 Given 2 BitSets, B1 and B2, of size N where all bits in both BitSets are initialized to 0, perform a series of
 M operations. After each operation, print the number of set bits in the respective BitSets as two space-separated
 integers on a new line.

 Input Format

 The first line contains 2 space-separated integers, (the length of both BitSets and ) and (the number of operations to perform), respectively.
 The subsequent lines each contain an operation in one of the following forms:

 AND <set> <set>
 OR <set> <set>
 XOR <set> <set>
 FLIP <set> <index>
 SET <set> <index>

 In the list above, <set> is the integer 1 or 2, where 1 denotes B1 and 2 denotes B2.
 <index> is an integer denoting a bit's index in the BitSet corresponding to <set>.

 For the binary operations AND, OR, and XOR, operands are read from left to right and the BitSet
 resulting from the operation replaces the contents of the first operand.

 Sample Input
 5 4
 AND 1 2
 SET 1 4
 FLIP 2 2
 OR 2 1

 Sample Output
 0 0
 1 0
 1 1
 1 2

 **/

import java.util.BitSet;
import java.util.Scanner;

public class JavaBitSet {

    public static void main(String[] args) {
        Scanner get = new Scanner(System.in);
        int n = get.nextInt();
        int m = get.nextInt();

        BitSet b1 = new BitSet(n);
        BitSet b2 = new BitSet(n);
        BitSet[] bitset = new BitSet[3];

        bitset[1] = b1;
        bitset[2] = b2;

        while ( 0 < m-- ) {
            String op = get.next();
            int x = get.nextInt();
            int y = get.nextInt();

            switch (op) {
                case "AND":
                    bitset[x].and(bitset[y]);
                    break;
                case "OR":
                    bitset[x].or(bitset[y]);
                    break;
                case "XOR":
                    bitset[x].xor(bitset[y]);
                    break;
                case "FLIP":
                    bitset[x].flip(y);
                    break;
                case "SET":
                    bitset[x].set(y);
            }

            System.out.printf("%d %d%n", b1.cardinality(), b2.cardinality());
        }
    }
}
