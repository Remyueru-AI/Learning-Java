package Day24;

public class HospitalSystem {
    public static void main(String[] args) {
        Staff staff = new Staff("Paul",01,"Staff");
        Doctor doctor = new Doctor("Rudeus",02,"Doctor");
        Nurse nurse = new Nurse("Zenith", 03, "Nurse");
        Receptionist receptionist = new Receptionist("Lilia", 04,"Receptionist");
        Technician technician = new Technician("Roxy",05,"Technician");

        Staff[] staffs = {staff, doctor, nurse, receptionist, technician};
        for (Staff s : staffs) {
            s.displayInfo();
            s.workShift();
            s.performDuty();

            System.out.println();
        }
        for (Staff s : staffs) {
            if (s == doctor || s == nurse) {
                s.takeBreak();
                System.out.println();
            }
        }

    }
}

/*
Scenario:
You are creating a system for managing hospital staff. All staff share some
common properties (like name, ID, and department) and behaviors (like working shifts and attending meetings).
However, each role behaves differently when performing duties or working shifts.

Requirements:
1. Superclass: Staff
   * Fields: String name, int staffId, String department

   * Constructor to initialize all fields

   * Methods:

     * void workShift() – prints a generic shift message

     * void performDuty() – prints a generic duty message

     * void displayInfo() – displays staff info

2. Subclasses (Override workShift() and performDuty()):
   * Doctor

     * workShift(): "Doctor works a 12-hour shift"

     * performDuty(): "Diagnoses and treats patients"

   * Nurse

     * workShift(): "Nurse works rotating shifts"

     * performDuty(): "Assists in surgeries and patient care"

   * Receptionist

     * workShift(): "Receptionist works standard office hours"

     * performDuty(): "Handles patient records and appointments"

   * Technician

     * workShift(): "Technician is on-call for emergencies"

     * performDuty(): "Operates and maintains hospital equipment"

3. Class: HospitalSystem
   * Create an array or ArrayList<Staff>

   * Add at least one of each staff type

   * Use a loop to:

     * Call displayInfo()

     * Call workShift() and performDuty() (demonstrate polymorphism)


Extra Challenge:
   * Add a method takeBreak() in the Staff class. Override it only for Doctor and Nurse with custom messages.
*/