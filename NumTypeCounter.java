import java.util.Scanner;

public class NumTypeCounter {
    public static void main(String[] args) {
        Scanner entry = new Scanner(System.in);

        System.out.print("Enter the limit of inputs: ");
        int limit = entry.nextInt();
        int oddCount = 0;
        int evenCount = 0;

        for (int incre = 1; incre <= limit; incre++) {
            System.out.printf("Enter your variable #%d: ", incre);
            int var = entry.nextInt();

            if (var % 2 == 0) {
                evenCount++;
                continue;
            }

            oddCount++;
        }

        entry.close();

        System.out.printf("The count of odd numbers is %d and the count of even numbers is %d", oddCount, evenCount);
    }
}
