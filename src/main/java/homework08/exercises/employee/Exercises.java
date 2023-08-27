package homework08.exercises.employee;

public class Exercises {
    public static void main(String[] args) {
        Employee employee = new Employee(1, "Vessi", "Petrova", 2000);
        String name = employee.getName();
        double annualSalary = employee.getAnnualSalary();
        System.out.println(employee);

        double raisedSalary = employee.raiseSalary(+10);
        annualSalary = employee.getAnnualSalary();
        System.out.println(employee);
    }
}
