import java.util.Scanner;

public class MortgageCalculator {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        int principal = 0;
        double annualInterest = 0;
        double monthlyInterest = 0;
        int numberOfPayments = 0;

        Scanner scanner = new Scanner(System.in);

        // formula for what we are trying to solve... Monthly payment = loan amount * monthly interest / 1 - (1 + Monthly interest)
        // Type in loan
        while (true) {
            System.out.print("Principal: ");
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1_000_000)
                break;
            System.out.println("Enter a value between 1000 and 1000000");
        }

        // Input annual annual interest rate percent
        while (true) {
            System.out.println("Input interest rate annually (EG. 1 for 1%)\t");
            annualInterest = scanner.nextDouble();
            if (annualInterest >= 1 && annualInterest <= 30) {
                monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
                break;
            }
        }

        //Input how long loan would take (in years please)
        while (true) {
            System.out.print("Period (in years): ");
            byte years = scanner.nextByte();
            if (years >= 1 && years <= 30) {
                numberOfPayments = years * MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30.");
        }

        //this is the scanner closer
        scanner.close();

        /*calculating monthly payment using the formula above...*/
        double mortgage = (principal
                * monthlyInterest)
                / (1 - Math.pow(1 + monthlyInterest, - numberOfPayments));

        System.out.printf("Monthly payment: %.2f\n", mortgage);


    }
}