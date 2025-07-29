package Day24;

public class Doctor extends Staff{
    Doctor(String name, int staffId, String department) {
        super(name, staffId, department);
    }
    @Override
    void workShift() {
        System.out.println("Doctor " + name + " works a 12-hour shift");
    }
    @Override
    void performDuty() {
        System.out.println("Diagnoses and treats patients");
    }
    @Override
    void takeBreak() {

        System.out.println(department + " " + name + "'s is taking a break.");
    }
}
