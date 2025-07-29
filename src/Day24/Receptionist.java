package Day24;

public class Receptionist extends Staff{
    Receptionist(String name, int staffId, String department) {
        super(name, staffId, department);
    }
    @Override
    void workShift() {
        System.out.println("Receptionist " + name + " works standard office hours");
    }
    @Override
    void performDuty() {
        System.out.println("Handles patient records and appointments");
    }
}
