package Day23;

public class TestEmployee {

    public static void main(String[] args) {
        Manager manager = new Manager("John",01);
        Developer developer = new Developer("Jane", 02);
        Intern intern = new Intern("Remy", 03);
        Employee employee = new Employee();


        System.out.print("Role: " + manager.getRole() + ", ");
        manager.displayDetails();
        manager.holdMeeting();
        System.out.print("Role: " + developer.getRole() + ", ");
        developer.displayDetails();
        developer.writeCode();
        System.out.print("Role: " + intern.getRole() + ", ");
        intern.displayDetails();
        intern.attendTraining();
    }
}
