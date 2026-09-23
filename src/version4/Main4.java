package version4;

public class Main4 {
    public static void main(String[] args) {
        System.out.println("======================================================================");
        System.out.println("EMPLOYEE ROSTER INITIALIZATION & ENROLLMENT");
        System.out.println("======================================================================");

        EmployeeRoster roster = new EmployeeRoster(6);

        HourlyEmployee alice = new HourlyEmployee(
                101,
                new Name("Alice", "Marie", "Smith"),
                new MyDate(18, 9, 2000),
                new MyDate(1, 6, 2022),
                40.0f,
                237.50
        );

        PieceWorkerEmployee bob = new PieceWorkerEmployee(
                201,
                new Name("Bob", "Charles", "Jones", "Jr."),
                new MyDate(5, 4, 1998),
                new MyDate(15, 1, 2023),
                90,
                45.00
        );

        CommissionEmployee maria = new CommissionEmployee(
                301,
                new Name("Maria", "Luz", "Reyes"),
                new MyDate(10, 9, 1995),
                new MyDate(10, 3, 2020),
                120000.00
        );

        BasePlusCommissionEmployee kevin = new BasePlusCommissionEmployee(
                401,
                new Name("Kevin", "Santos", "Tan"),
                new MyDate(22, 7, 1990),
                new MyDate(5, 8, 2019),
                150000.00,
                30000.00
        );

        HourlyEmployee david = new HourlyEmployee(
                102,
                new Name("David", "Andrew", "White"),
                new MyDate(14, 11, 1987),
                new MyDate(1, 3, 2023),
                40.0f,
                200.00
        );

        Employee extra = new HourlyEmployee(
                500,
                new Name("Emma", "Grace", "Stone"),
                new MyDate(7, 2, 1991),
                new MyDate(2, 5, 2024),
                35.0f,
                180.00
        );

        roster.addEmployee(alice);
        roster.addEmployee(bob);
        roster.addEmployee(maria);
        roster.addEmployee(kevin);
        roster.addEmployee(david);
        roster.addEmployee(extra);

        for(int i = 0; i < 6; i++) {

            if (roster.getEmployee(i) != null) {
                System.out.println("Added: " + roster.getEmployee(i).getEmpName() +"("+ roster.getEmployeeCategory(roster.getEmployee(i))+ ") -> Success");
            } else {
                System.out.println("Added: " + roster.getEmployee(i).getEmpName() +"("+ roster.getEmployeeCategory(roster.getEmployee(i)) + ") -> Failed (Roster Full)");
            }
        }

        System.out.println("\n--- ROSTER COMPOSITION COUNTS ---");
        System.out.println("Total Employees: " + roster.getCount() + " / " + roster.getMax());
        System.out.println("Hourly Employees: " + roster.countHE());
        System.out.println("Piece Worker Employees: " + roster.countPWE());
        System.out.println("Commission Employees (Pure): " + roster.countCE());
        System.out.println("Base Plus Commission Employees: " + roster.countBPCE());

        roster.displayPayroll(9);

        System.out.println("\n======================================================================");
        System.out.println("TESTING EMPLOYEE REMOVAL & ARRAY COMPACTION");
        System.out.println("======================================================================");

        Employee removed = roster.removeEmployee(201);
        if (removed != null) {
            System.out.println("Removing Employee ID 201 (" + removed.getEmpName() + ")... Successfully removed.");
        }
        System.out.println("Current Employee Count: " + roster.getCount());
        roster.displayAllEmployees();
        System.out.println("======================================================================");

    }
}
