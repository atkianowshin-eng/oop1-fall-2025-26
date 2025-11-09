import java.util.Scanner;
import java.util.Locale;
import java.text.NumberFormat;

public class MortgageCalculator {
    public static void main(String[] args) {
        System.out.println("===  Bangladesh Mortgage Calculator (BDT) ===");
        Scanner scanner = new Scanner(System.in);

double monthlySalary = 0;
double creditScore = 0;
boolean criminalRecord = false;
        
    while(true){
        System.out.print("Enter your monthly salary (in BDT): ");
        if(scanner.hasNextDouble()){
            monthlySalary = scanner.nextDouble();
            break;
        }else{
            System.out.println("Invalid input! Please enter numbers only for salary.");
            scanner.next();
        }
}

    while(true){
        System.out.print("Enter your credit score (0-500): ");
        if (scanner.hasNextDouble()){
            creditScore = scanner.nextDouble();
            if( creditScore >= 0 && creditScore <= 500){
                break;
            }else{
         System.out.println("Credit Score must be between 0 and 500!");
        }
       }else{
            System.out.println("Invalid input! Please enter a number between 0 and 500.");
            scanner.next();
       }
}
    
      while(true){ 
         System.out.print("Do you have any criminal record (True/False)?: ");
         if(scanner.hasNextBoolean()){
            criminalRecord = scanner.nextBoolean();
            break;
        }else{
            System.out.println("Invalid input! Please enter 'True' or 'False'.");
            scanner.next();
        }
}

        double principal = 0;
        while(true){
        System.out.print("Enter loan amount (Principal in BDT): "); 
        if(scanner.hasNextDouble()){
            principal = scanner.nextDouble();
            if (principal <= monthlySalary * 2 ){
                break;
            } else {
                System.out.println("Loan amount denied. Loan amount must be under 2 times the salary!");
            }
        }else{
            System.out.println("Invalid input! Please enter numbers only for loan amount!");
            scanner.next();
        }
}

      boolean eligible = ((principal <= monthlySalary * 2) && (creditScore >= 300 )) && !criminalRecord;
      if(!eligible){
        System.out.println("Sorry, you are not eligible!");
        System.out.println("Reason: you must have a monthly salary that is at least twice your loan amount and good credit score (>=300) and no criminal record.");
        scanner.close();
        return;    
    }
        double annualInterestRate = 0;
        while(true){
        System.out.print("Enter annual interest rate (e.g., 8.5 for 8.5%): ");
        if(scanner.hasNextDouble()){
            annualInterestRate = scanner.nextDouble();
            break;
        }else{
            System.out.println("Invalid input! Please enter numbers only for annual interest!");
            scanner.next();
        }
}

        int years;
        while(true){
        System.out.print("Enter loan period (in years): ");
        if(scanner.hasNextDouble()){
            years = scanner.nextInt();
            break;
        }else{
            System.out.println("Invalid input! Please enter numbers only for years!");
            scanner.next();
        }

    }      
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
}