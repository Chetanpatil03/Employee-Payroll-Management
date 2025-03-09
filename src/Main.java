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

    abstract
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

