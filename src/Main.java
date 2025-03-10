import java.util.ArrayList;
import java.util.List;

abstract class Employee{
    private String name;
    private int id;

    public Employee(String name,int id ){
        this.name = name;
        this.id = id;
    }

    public String getName(){
//        Encapsulation using getter method
        return name;
    }

    public int getId(){
        return id;
    }

    abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employee{" + "name='" + name + '\'' + ", id=" + id + ", salary = "+calculateSalary()+"}";

    }
}
class FullTimeEmployee extends Employee  {
    private double MonthlySalary;

    public FullTimeEmployee(String name, int id, double MonthlySalary){
        super(name,id);
        this.MonthlySalary = MonthlySalary;
    }

    @Override
    public double calculateSalary(){
        return  MonthlySalary;
    }

}

class  PartTimeEmployee extends Employee{
    private int hoursWork;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, double hourlyRate,int hoursWork){
        super(name,id);
        this.hourlyRate = hourlyRate;
        this.hoursWork = hoursWork;
    }

    @Override
    public double calculateSalary(){
        return  hoursWork * hourlyRate;
    }
}

class PayrollSystem{
    private ArrayList<Employee> employeeList ;

    public PayrollSystem(){
        employeeList = new ArrayList<>();
    }

    //add employee
    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    //remove employee
    public  void removeEmployee(int id){
        Employee employeeToRemove = null;

        for(Employee employee : employeeList){
            if (employee.getId() == id){
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null) {
            employeeList.remove(employeeToRemove);
        }
    }

    //get employee
    public void displayEmployee(){
        for (Employee employee : employeeList){
            System.out.println(employee);
        }
    }

}

public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee("vikas",1,25000.0);
        PartTimeEmployee emp2 = new PartTimeEmployee("Raman",2,100,40);

        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);

        System.out.println("Initial employee details : ");
        payrollSystem.displayEmployee();
        System.out.println("Removing Employees :");
        payrollSystem.removeEmployee(2);
        System.out.println("Remaining Employee Display");
        payrollSystem.displayEmployee();
    }
}

