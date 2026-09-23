package version5;

public class Main5 {
    public static void main(String[] args) {
        System.out.println("======================================================================");
        System.out.println("DYNAMIC ROSTER INITIALIZATION (ArrayList Backend)");
        System.out.println("======================================================================");

        EmployeeRoster roster = new EmployeeRoster(4);

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

        roster.addEmployee(alice);
        roster.addEmployee(bob);
        roster.addEmployee(maria);
        roster.addEmployee(kevin);

        System.out.println("Enrolled: " + alice.getEmpName() + " (" + roster.getEmployeeCategory(alice) + ")");
        System.out.println("Enrolled: " + bob.getEmpName() + " (" + roster.getEmployeeCategory(bob) + ")");
        System.out.println("Enrolled: " + maria.getEmpName() + " (" + roster.getEmployeeCategory(maria) + ")");
        System.out.println("Enrolled: " + kevin.getEmpName() + " (" + roster.getEmployeeCategory(kevin) + ")");
        System.out.println("Total Roster Size: " + roster.getCount() + " employees");
        System.out.println("======================================================================");

        roster.displayPayroll(9);

        System.out.println("======================================================================");
        System.out.println("COLLECTION REMOVAL TEST");
        System.out.println("======================================================================");

        Employee removed = roster.removeEmployee(201);
        if (removed != null) {
            System.out.println("Removing Employee ID 201... Successfully removed.");
        }

        System.out.println("Updated Roster Size: " + roster.getCount());
        System.out.println();
        System.out.println("Current Active Employees:");
        roster.displayAllEmployees();
        System.out.println("======================================================================");
    }
}
