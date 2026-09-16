public class M5_EmployeeCompanyInfo {
    public static void main(String[] args) {
        new Employee("Rahul", 45000);
        new Employee("Sneha", 52000);
        new Employee("Vikram", 60000);

        Employee.printCompanyInfo();
    }
}

class Employee {
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    String empName;
    double salary;

    Employee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}
