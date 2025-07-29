package Day24;

public class Technician extends Staff{
    Technician(String name, int staffId, String department) {
        super(name, staffId, department);
    }
    @Override
    void workShift() {
        System.out.println("Technician " + name + " is on-call for emergencies");
    }
    @Override
    void performDuty() {
        System.out.println("Operates and maintains hospital equipment");
    }
}
