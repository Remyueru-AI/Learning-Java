package Day23;

public class Manager extends Employee{

    Manager(String n, int i) {
            super(n, i);
    }
    String getRole() {
        return "Manager";
    }
    @Override
    public double getSalary() {
        return salary = 15;
    }

    void holdMeeting() {
        System.out.println("\n" + getRole() + " " + name + " is holding meeting\n");
    }
}
