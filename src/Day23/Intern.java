package Day23;

public class Intern extends Employee{
    Intern(String n, int i) {
        super(n, i);
    }
    String getRole() {
        return "Intern";
    }
    @Override
    public double getSalary() {
        return salary = 11;
    }
    void attendTraining() {
        System.out.println("\n" + getRole() + " " + name + " is attending training\n");
    }
}
