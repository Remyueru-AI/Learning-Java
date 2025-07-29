package Day23;

public class Developer extends Employee{
    Developer(String n, int i) {
        super(n, i);
    }
    String getRole() {
        return "Developer";
    }
    @Override
    public double getSalary() {
        return salary = 50000;
    }
    void writeCode() {
        System.out.println("\n" + getRole() + " " + name + " is writing code\n");
    }
}
