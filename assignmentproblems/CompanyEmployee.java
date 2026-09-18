package assignmentproblems;

public class CompanyEmployee {

    // Instance fields
    String empName;
    double salary;

    // Static fields
    static String companyName =
        "Bright Horizon Technologies";

    static int employeeCount = 0;

    // Constructor
    public CompanyEmployee(String empName, double salary) {

        this.empName = empName;
        this.salary = salary;

        employeeCount++;
    }

    // Static method
    public static void printCompanyInfo() {

        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {

        CompanyEmployee e1 =
            new CompanyEmployee("Ravi", 40000);

        CompanyEmployee e2 =
            new CompanyEmployee("Anitha", 50000);

        CompanyEmployee e3 =
            new CompanyEmployee("Karthik", 45000);

        CompanyEmployee.printCompanyInfo();
    }
}