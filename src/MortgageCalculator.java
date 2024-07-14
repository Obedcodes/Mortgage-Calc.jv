import java.util.Scanner;

public class MortgageCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // formula for what we are trying to solve... Monthly payment = loan amount * monthly interest / 1 - (1 + Monthly interest)
        // Type in loan
        System.out.println("Input loan amount:\t");
        long loanAmount = scanner.nextLong();

        // Input annual annoal interest rate percent
        System.out.println("Input interest rate annually (EG. 1 for 1%)\t");
        double annualInterestRate = scanner.nextDouble();

        //Input how long loan would take (in years please)
        System.out.println("Enter loan term (in years)\t");
        int loanTermInYears = scanner.nextInt();

        //this is the scanner closer
        scanner.close();

        // calculating the interest rate
        double monthlyInterestRate = annualInterestRate / 100 / 12;

        // converting monthly payment using formula
        int numberOfPayments = loanTermInYears * 12;

        /*calculating monthly payment using the formula above...... also note that i dont really know how to
        use math.pow so yeah i searched this part out because code wasnt running..... still yet to ask on (printf) too*/

        double monthlyPayment = (loanAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, - numberOfPayments));

        System.out.printf("Monthly payment: %.2f\n", monthlyPayment);
    }
}