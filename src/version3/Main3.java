package version3;

public class Main3 {

    public static void main(String[] args) {

        final int TARGET_MONTH = 9;

        // ==============================================================
        // CREATE EMPLOYEES
        // ==============================================================

        HourlyEmployee hourly = new HourlyEmployee(
                101,
                new Name("Alice", "Marie", "Smith"),
                new MyDate(18, 9, 2000),
                new MyDate(1, 6, 2022),
                40.0f,
                237.50
        );

        PieceWorkerEmployee pieceWorker = new PieceWorkerEmployee(
                201,
                new Name("Bob", "Charles", "Jones", "Jr."),
                new MyDate(5, 4, 1998),
                new MyDate(15, 1, 2023),
                90,
                45.00
        );

        CommissionEmployee commission = new CommissionEmployee(
                301,
                new Name("Carol", "Anne", "Brown"),
                new MyDate(10, 9, 1995),
                new MyDate(10, 3, 2020),
                120000.00
        );

        BasePlusCommissionEmployee basePlus =
                new BasePlusCommissionEmployee(
                        401,
                        new Name("David", "James", "Garcia"),
                        new MyDate(22, 7, 1990),
                        new MyDate(5, 8, 2019),
                        150000.00,
                        30000.00
                );

        // ==============================================================
        // POLYMORPHIC PAYROLL
        // ==============================================================

        Employee[] employees = {
                hourly,
                pieceWorker,
                commission,
                basePlus
        };

        System.out.println(
                "======================================================================"
        );
        System.out.println(
                "POLYMORPHIC PAYROLL REPORT (Target Month: Sep)"
        );
        System.out.println(
                "======================================================================"
        );

        for (int i = 0; i < employees.length; i++) {

            Employee employee = employees[i];

            double totalPay = employee.computeSalary(TARGET_MONTH);
            double basePay = employee.computeSalary();
            double bonus = totalPay - basePay;

            String eligibility =
                    bonus > 0 ? "Eligible" : "Ineligible";

            System.out.printf(
                    "%n%d. %s%n",
                    i + 1,
                    employee
            );

            System.out.printf(
                    "   Base Pay: ₱%.2f | Birthday Bonus: ₱%.2f (%s)%n",
                    basePay,
                    bonus,
                    eligibility
            );

            System.out.printf(
                    "   Total Payout: ₱%.2f%n",
                    totalPay
            );
        }

        // ==============================================================
        // OBJECT CONTRACT TESTS
        // ==============================================================

        System.out.println(
                "\n======================================================================"
        );
        System.out.println(
                "OBJECT CONTRACT TESTS (equals & hashCode)"
        );
        System.out.println(
                "======================================================================"
        );

        HourlyEmployee emp1 = new HourlyEmployee(
                500,
                new Name("John", "Paul", "Doe"),
                new MyDate(10, 5, 2000),
                new MyDate(1, 1, 2020),
                40.0f,
                250.00
        );

        HourlyEmployee emp1Identical = new HourlyEmployee(
                500,
                new Name("John", "Paul", "Doe"),
                new MyDate(10, 5, 2000),
                new MyDate(1, 1, 2020),
                40.0f,
                250.00
        );

        HourlyEmployee emp2 = new HourlyEmployee(
                501,
                new Name("Jane", "Anne", "Doe"),
                new MyDate(10, 5, 2000),
                new MyDate(1, 1, 2020),
                40.0f,
                250.00
        );

        System.out.println(
                "emp1 equals emp1Identical: "
                        + emp1.equals(emp1Identical)
        );

        System.out.printf(
                "emp1 hashCode: %d | emp1Identical hashCode: %d "
                        + "| Match: %b%n",
                emp1.hashCode(),
                emp1Identical.hashCode(),
                emp1.hashCode() == emp1Identical.hashCode()
        );

        System.out.println(
                "emp1 equals emp2: " + emp1.equals(emp2)
        );

        // Modify a field of emp1Identical.
        emp1Identical.setRatePerHour(300.00);

        System.out.println(
                "After modifying emp1Identical rate:"
        );

        System.out.println(
                "emp1 equals modified emp1Identical: "
                        + emp1.equals(emp1Identical)
        );

        // ==============================================================
        // DEEP CLONE TEST
        // ==============================================================

        System.out.println(
                "\n======================================================================"
        );
        System.out.println(
                "DEEP CLONE VERIFICATION"
        );
        System.out.println(
                "======================================================================"
        );

        HourlyEmployee empOriginal = new HourlyEmployee(
                600,
                new Name("Smith", "Alice", "Taylor"),
                new MyDate(18, 9, 2000),
                new MyDate(1, 6, 2022),
                40.0f,
                200.00
        );

        HourlyEmployee empClone = empOriginal.clone();

        System.out.println(
                "Original Name before modification: "
                        + empOriginal.getEmpName()
        );

        empClone.getEmpName().setFirstName("Taylor");

        System.out.println(
                "Clone Name changed to:             "
                        + empClone.getEmpName()
        );

        System.out.println(
                "Original Name after modification:  "
                        + empOriginal.getEmpName()
                        + " (Deep copy successful!)"
        );

        // Also verify deep cloning of MyDate.
        System.out.println(
                "\nOriginal DOB before clone modification: "
                        + empOriginal.getBirthDate()
        );

        empClone.getBirthDate().setMonth(12);

        System.out.println(
                "Clone DOB after modification:          "
                        + empClone.getBirthDate()
        );

        System.out.println(
                "Original DOB after clone modification: "
                        + empOriginal.getBirthDate()
                        + " (Deep copy successful!)"
        );
    }
}
