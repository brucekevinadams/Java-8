/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 *
This Java 8 program computes the binomial distribution probability. This is from a Hackerrank problem.

Objective
In this challenge, we learn about binomial distributions.

Task
The ratio of boys to girls for babies born in Russia is 1.09:1. If there is child born per birth, what proportion of
Russian families with exactly 6 children will have at least 3 boys?
Write a program to compute the answer using the above parameters. Then print your result, rounded to a scale
of decimal places (i.e.,1.234 format).

Input Format
A single line containing the following values:
1.09 1
If you do not wish to read this information from stdin, you can hard-code it into your program.

Output Format
Print a single line denoting the answer, rounded to a scale of decimal places (i.e.,1.234 format).
*/

public class JavaBinomialDistribution {
    public static final double BR= 1.09;
    public static final double GR= 1;
    static  int  factorial(int n)
    {
        if(n==0)
            return 1;
        return n*factorial(n-1);
    }

    static double  combination(int r)
    {
        return (factorial(6)/(factorial(r) * factorial(6-r)));
    }
    public static void main(String[] args)
    {
        double p= (BR)/(BR+GR);
        double q=1-p;

        double probability=0.0;
        for(int i =6 ;i >= 3;i--)
        {
            probability +=  combination(i)*Math.pow(p,i) * Math.pow(q,6-i);
        }
        System.out.printf("%.3f",probability);
    }
}