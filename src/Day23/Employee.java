package Day23;

public class Employee {
    String name;
    int id;
    double salary= 10;

    Employee(String name, int id) {
        this.name=name; this.id = id;
    }
    Employee() {
        System.out.println("Employees base Salary: " + getSalary() + "\n");
    }

    public double getSalary() {
        return salary;
    }

void displayDetails() {
    System.out.printf("Name: "+name+", ID: "+id+" Salary: " + getSalary());
}

}
