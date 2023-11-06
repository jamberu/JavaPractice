import java.util.Scanner;

public class Minimum {
    public static void main(String[] args) {
        Scanner entry = new Scanner(System.in);

        System.out.print("Enter the 1st number: ");
        int var1 = entry.nextInt();
        System.out.print("Enter the 2nd number: ");
        int var2 = entry.nextInt();
        System.out.print("Enter the 3rd number: ");
        int var3 = entry.nextInt();  

        entry.close();

        if (var1 < var2 && var1 < var3) {
            System.out.print("The smallest number is " + var1);
        }
        else if (var2 < var3) {
            System.out.print("The smallest number is " + var2);
            }
        else if (var3 < var1) {
            System.out.print("The smallest number is " + var3);
        }
    }

}
