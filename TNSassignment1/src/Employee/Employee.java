package Employee;

class Employee {
    private String name;
    private int employeeId;
    private double salary;

    public Employee(String name, int employeeId, double salary) {
        this.name = name;
        this.employeeId = employeeId;
        this.salary = salary;
    }

    public double calculateBonus() {
        // Base bonus calculation logic (can be overridden by subclasses)
        return salary * 0.05; // 5% of the salary as a bonus
    }

    public void displayInfo() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Salary: $" + salary);
    }
}

class Salesperson extends Employee {
    private double commission;

    public Salesperson(String name, int employeeId, double salary, double commission) {
        super(name, employeeId, salary);
        this.commission = commission;
    }

    @Override
    public double calculateBonus() {
        // Salesperson-specific bonus calculation logic
        return super.calculateBonus() + commission;
    }

    public void makeSale() {
        System.out.println("Salesperson made a sale with a commission of $" + commission);
    }
}

class Engineer extends Employee {
    private String specialization;

    public Engineer(String name, int employeeId, double salary, String specialization) {
        super(name, employeeId, salary);
        this.specialization = specialization;
    }

    @Override
    public double calculateBonus() {
        // Engineer-specific bonus calculation logic
        return super.calculateBonus() + 1000; // Additional fixed bonus for engineers
    }

    public void work() {
        System.out.println("Engineer is working on " + specialization + " projects.");
    }
}

public class Company {
    public static void main(String[] args) {
        // Example usage
        Salesperson salesperson = new Salesperson("Alice Johnson", 301, 50000, 2000);
        Engineer engineer = new Engineer("Bob Smith", 401, 60000, "Software Development");

        salesperson.displayInfo();
        System.out.println("Salesperson Bonus: $" + salesperson.calculateBonus());
        salesperson.makeSale();
        System.out.println();

        engineer.displayInfo();
        System.out.println("Engineer Bonus: $" + engineer.calculateBonus());
        engineer.work();
    }
}
