import java.util.Scanner;

public class LimSum {
    public static long summationLimitRecursion(long n) {
        // Applied recursion which where a function calls itself inside it to perform repeated executions
        
        /*In this case, if the argument 'n' is not 1, 
        the function will add n to the result of the function 
        until 'n' reaches 1 to which it will break itself */

        if (n == 1) {
            return 1;
        }

        return n + summationLimitRecursion(n - 1);
    }

    public static void main(String[] args) {
        Scanner entry = new Scanner(System.in);

        System.out.print("Enter the summation limit (must be positive & not zero): ");

        long limit = entry.nextLong();

        entry.close();
        long sum = 0;

        if (limit <= 0) {
            System.out.print("The summation limit input is not valid.");
            System.exit(1);
        }

        // Below is an example on how to perfom the recursion using a for loop
        
        /*for (long incre = 1; incre <= limit; incre++){
            sum += incre;
        }*/

        sum += summationLimitRecursion(limit);

        System.out.printf("The sum of the numbers below %d is %d.", limit, sum);
    }   
}
