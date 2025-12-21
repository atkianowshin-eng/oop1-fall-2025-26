abstract class Employee {
    String name;
    Employee(String name){
        this.name = name;
    }

    abstract double calculateSalary();
    void showDetails() {
        System.out.println(toString());
    }
}

class FullTimeEmployee extends Employee {
    double monthlySalary;

    FullTimeEmployee(String name, double monthlySalary) {
        super(name);
        this.monthlySalary = monthlySalary;
    }

    @Override 
    double calculateSalary() {
        return monthlySalary;
    }

    @Override 
    public String toString() {
        return "Employee Name: " + name + "\nMonthly Salary: " + calculateSalary();
    }
}


public class ProblemStatementQ2 {
    public static void main(String[] args) {
        Employee emp = new FullTimeEmployee("Nowshin",25000);

        emp.showDetails();
    }
}
