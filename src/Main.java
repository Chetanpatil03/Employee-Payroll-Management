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
//        String s = "Employee{" + "name='" + name + '\'' + ", id=" + id + ",salary = \"calculateSalary()+\"}";
//        return s;
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
    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

