import java.util.Scanner;
import java.util.Locale;
import java.text.NumberFormat;

public class MortgageCalculator {
    public static void main(String[] args) {
        System.out.println("===  Bangladesh Mortgage Calculator (BDT) ===");
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your monthly salary (in BDT): ");
        double monthlySalary;
        if(scanner.hasNextDouble()){
            monthlySalary = scanner.nextDouble();
        }
        else{
            System.out.println("Invalid input! Please enter numbers only for salary.");
            scanner.next();
            System.out.print("Enter your monthly salary again (in BDT): ");
            monthlySalary = scanner.nextDouble();
        }

        System.out.print("Enter your credit score (0-500): ");
        int creditScore;
        if (scanner.hasNextInt()){
            creditScore = scanner.nextInt();
        }
        else{
            System.out.println("Invalid input! Please enter a number between 0 and 500.");
            scanner.next();
            System.out.print("Enter your credit score again (0-500): ");
            creditScore = scanner.nextInt();
        }
        if(creditScore < 0 || creditScore > 500){
            System.out.println("Credit Score must be between 0 and 500!");
            scanner.next();
            System.out.print("Enter your credit score again (0-500): ");
            creditScore = scanner.nextInt();
        }
    
        System.out.print("Do you have any criminal record (True/False)?: ");
        boolean criminalRecord;
        if(scanner.hasNextBoolean()){
            criminalRecord = scanner.nextBoolean();
        }
        else{
            System.out.println("Invalid input! Please enter True or False.");
            scanner.next();
            System.out.print("Enter again (True/False): ");
            criminalRecord = scanner.nextBoolean();
        }

        System.out.print("Enter loan amount (Principal in BDT): ");
        double principal;
        if(scanner.hasNextDouble()){
            principal = scanner.nextDouble();
        }
        else{
            System.out.println("Invalid input! Please enter numbers only for loan amount!");
            scanner.next();
            System.out.print("Enter loan amount again (Principal in BDT): ");
            principal = scanner.nextDouble();
        }
        
        System.out.print("Enter annual interest rate (e.g., 8.5 for 8.5%): ");
        double annualInterestRate;
        if(scanner.hasNextDouble()){
            annualInterestRate = scanner.nextDouble();
        }
        else{
            System.out.println("Invalid input! Please enter numbers only for annual interest!");
            scanner.next();
            System.out.println("Enter annual interest again (e.g., 8.5 for 8.5%): ");
            annualInterestRate = scanner.nextDouble();
        }

        System.out.print("Enter loan period (in years): ");
        int years;
        if(scanner.hasNextDouble()){
            years = scanner.nextInt();
        }
        else{
            System.out.println("Invalid input! Please enter numbers only for years!");
            scanner.next();
            System.out.println("Enter loan period (in years): ");
            years = scanner.nextInt();
        }

        if(creditScore < 300){
            System.out.println("Sorry, your credit is too low for a mortgage calculator!");
        }
        else if(criminalRecord){
            System.out.println("Sorry, applicants with a criminal credit are not eligible for a mortgage calculator.");
        }
        else if(principal > (monthlySalary * 2)){
            System.out.println("Loan amount exceeds 2 times your salary. Not eligible.");
        }
        else{
            double monthlyRate = ( annualInterestRate /100 ) / 12;
        int months = years * 12;
        double monthlyPayment = principal * 
                                ( monthlyRate * Math.pow ( ( 1 + monthlyRate ), months ) )
                                 / ((Math.pow( ( 1+ monthlyRate ), months) ) - 1 );
        double totalPayment = monthlyPayment * months;
        double totalInterest = totalPayment - principal;

        Locale bdlocale = Locale.of("en","BD");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(bdlocale);

        System.out.println("\n=== Mortgage Summary ===");
        System.out.println("Loan Amount: " + currencyFormatter.format(principal));
        System.out.println("Monthly Payment: " + currencyFormatter.format(monthlyPayment));
        System.out.println("Total Payment: " + currencyFormatter.format(totalPayment));
        System.out.println("Total Interest: " + currencyFormatter.format(totalInterest));

        }

        scanner.close();
    }
    
}
