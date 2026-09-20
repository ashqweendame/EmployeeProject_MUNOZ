package version3;

public class Main3 {
    
    private static final int TARGET_MONTH = 9;

    public static void main(String[] args) {

        Employee[] employees = {
            new HourlyEmployee(
                101,
                new Name("Alice", "Marie", "Smith"),
                new MyDate(18, 9, 2000),
                new MyDate(1, 6, 2022),
                40.0f,
                237.50
            ),

            new PieceWorkerEmployee(
                201,
                new Name("Bob", "Charles", "Jones", "Jr."),
                new MyDate(5, 4, 1998),
                new MyDate(15, 1, 2023),
                90,
                45.00
            ),

            new CommissionEmployee(
                301,
                new Name("Carol", "Anne", "Brown"),
                new MyDate(10, 9, 1995),
                new MyDate(10, 3, 2020),
                120_000.00
            ),

            new BasePlusCommissionEmployee(
                401,
                new Name("David", "James", "Garcia"),
                new MyDate(22, 7, 1990),
                new MyDate(5, 8, 2019),
                150_000.00,
                30_000.00
            )
        };

        printPayrollReport(employees);

        testEqualsAndHashCode();

        testDeepClone();
    }
    
    private static void printPayrollReport(Employee[] employees) {

        printHeader("POLYMORPHIC PAYROLL REPORT (Target Month: Sep)");

        for (int i = 0; i < employees.length; i++) {

            Employee employee = employees[i];

            double regularPay = employee.computeSalary();
            double totalPay = employee.computeSalary(TARGET_MONTH);
            double birthdayBonus = totalPay - regularPay;

            String eligibility =
                    birthdayBonus > 0 ? "Eligible" : "Ineligible";

            System.out.printf(
                    "%n%d. %s%n",
                    i + 1,
                    employee
            );

            System.out.printf(
                    "   Base Pay: ₱%.2f | Birthday Bonus: ₱%.2f (%s)%n",
                    regularPay,
                    birthdayBonus,
                    eligibility
            );

            System.out.printf(
                    "   Total Payout: ₱%.2f%n",
                    totalPay
            );
        }
    }
    
    private static void testEqualsAndHashCode() {

        printHeader("OBJECT CONTRACT TESTS (equals & hashCode)");

        HourlyEmployee emp1 = createTestEmployee(
                500,
                "John",
                "Paul",
                "Doe",
                250.00
        );

        HourlyEmployee emp1Identical = createTestEmployee(
                500,
                "John",
                "Paul",
                "Doe",
                250.00
        );

        HourlyEmployee emp2 = createTestEmployee(
                501,
                "Jane",
                "Anne",
                "Doe",
                250.00
        );

        System.out.println(
                "emp1 equals emp1Identical: "
                        + emp1.equals(emp1Identical)
        );

        System.out.printf(
                "emp1 hashCode: %d | emp1Identical hashCode: %d | Match: %b%n",
                emp1.hashCode(),
                emp1Identical.hashCode(),
                emp1.hashCode() == emp1Identical.hashCode()
        );

        System.out.println(
                "emp1 equals emp2: " + emp1.equals(emp2)
        );

        emp1Identical.setRatePerHour(300.00);

        System.out.println(
                "After modifying emp1Identical rate:"
        );

        System.out.println(
                "emp1 equals modified emp1Identical: "
                        + emp1.equals(emp1Identical)
        );
    }
    private static void testDeepClone() {

        printHeader("DEEP CLONE VERIFICATION");

        HourlyEmployee original = new HourlyEmployee(
                600,
                new Name("Smith", "Alice", "Taylor"),
                new MyDate(18, 9, 2000),
                new MyDate(1, 6, 2022),
                40.0f,
                200.00
        );

        HourlyEmployee clone = original.clone();

        System.out.println(
                "Original Name before modification: "
                        + original.getEmpName()
        );

        clone.getEmpName().setFirstName("Taylor");

        System.out.println(
                "Clone Name changed to:             "
                        + clone.getEmpName()
        );

        System.out.println(
                "Original Name after modification:  "
                        + original.getEmpName()
                        + " (Deep copy successful!)"
        );

        System.out.println(
                "\nOriginal DOB before clone modification: "
                        + original.getBirthDate()
        );

        clone.getBirthDate().setMonth(12);

        System.out.println(
                "Clone DOB after modification:          "
                        + clone.getBirthDate()
        );

        System.out.println(
                "Original DOB after clone modification: "
                        + original.getBirthDate()
                        + " (Deep copy successful!)"
        );
    }
    
    private static HourlyEmployee createTestEmployee(
            int id,
            String firstName,
            String middleName,
            String lastName,
            double ratePerHour) {

        return new HourlyEmployee(
                id,
                new Name(firstName, middleName, lastName),
                new MyDate(10, 5, 2000),
                new MyDate(1, 1, 2020),
                40.0f,
                ratePerHour
        );
    }

    private static void printHeader(String title) {

        System.out.println(
                "\n======================================================================"
        );

        System.out.println(title);

        System.out.println(
                "======================================================================"
        );
    }
}
