package Day24;

public class Nurse extends Staff{
    Nurse(String name, int staffId, String department) {
        super(name, staffId, department);
    }
    @Override
    void workShift() {
        System.out.println("Nurse "+name+" works rotating shifts");
    }
    @Override
    void performDuty() {
        System.out.println("Assists in surgeries and patient care");
    }
    @Override
    void takeBreak() {
        System.out.println(department + " " + name + "'s is taking a break.");
    }
}
