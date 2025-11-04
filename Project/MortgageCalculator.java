import java.util.Scanner;
import java.text.NumberFormat;

public class MortgageCalculator {
    public static void main(String[] args) {
        System.out.println("===  Bangladesh Mortgage Calculator (BDT) ===");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter loan amount:");
        double loanAmount = scanner.nextDouble();
        
        System.out.print("Enter annual interest rate:");
        Double annualrate = scanner.nextDouble();

        System.out.print("Enter loan period (in years):");
        int years = scanner.nextInt();

        double monthlyrate = ( annualrate /100 ) / 12;
        int months = years * 12;
        double monthlypayment = loanAmount * ( monthlyrate * Math.pow ( ( 1 + monthlyrate ), months ) ) / ((Math.pow( ( 1+ monthlyrate ), months) ) - 1 );
        double totalpayment = monthlypayment * months;
        double totalinterest = totalpayment - loanAmount;

        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();

        System.out.println("=== Mortgage Summary ===");
        System.out.println("Loan Amount: " + currencyFormatter.format(loanAmount));
        System.out.println("Monthly Payment: " + currencyFormatter.format(monthlypayment));
        System.out.println("Total Payment: " + currencyFormatter.format(totalpayment));
        System.out.println("Total Interest: " + currencyFormatter.format(totalinterest));

        scanner.close();
    }
    
}
