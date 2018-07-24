/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 *
 * This is from a Hackerrank problem
 *
Objective
In this challenge, we go further with binomial distributions. We recommend reviewing the previous challenge's
Tutorial before attempting this problem.

Task
A manufacturer of metal pistons finds that, on average, of the pistons they manufacture are rejected because
they are incorrectly sized. What is the probability that a batch of pistons will contain:

    No more than rejects?
    At least rejects?

Input Format

A single line containing the following values (denoting the respective percentage of defective pistons
and the size of the current batch of pistons):

12 10

*/

public class BinomialDistribution2 { public static final double q= 0.88; public static final double p= 0.12;
static int factorial(int n) { if(n==0) return 1; return n*factorial(n-1); }

    static double  combination(int r)
    {
        return (factorial(10)/(factorial(r) * factorial(10-r)));
    }
    public static void main(String[] args)
    {

        double probability=0.0, probability1=0.0, k=0.0;

        for(int j =10 ;j >= 2;j--)
        {
            probability +=  combination(j)*Math.pow(p,j) * Math.pow(q,10-j);
        }
        k =  combination(2)*Math.pow(p,2)*Math.pow(q,8);

        probability1 = k + 1 - probability;
        System.out.printf("%.3f",probability1);
        System.out.println();
        System.out.printf("%.3f",probability);

    }

}