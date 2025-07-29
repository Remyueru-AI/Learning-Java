package Day24;

public class Staff {
    String name, department;
    int staffId;

    Staff(String name, int staffId, String department) {
        this.name = name;
        this.staffId = staffId;
        this.department = department;
    }
    void workShift() {
        System.out.println("The staff " + name + " is on shift.");
    }
    void performDuty() {
        System.out.println("The staff is on duty.");
    }
    void displayInfo() {
        System.out.println("Name: " + name + " ID: " + staffId + " Department: " + department);
    }
    void takeBreak() {
        System.out.println(name + "'s is taking a break.");
    }
}
