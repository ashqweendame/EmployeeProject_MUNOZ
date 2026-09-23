package version4;

public class EmployeeRoster {
    private Employee[] empList;
    private int max;
    private int count;

    public EmployeeRoster() {
        this.max = 10;
        this.count = 0;
    }

    public EmployeeRoster(int max) {
        if (max <= 0) {
            throw new IllegalArgumentException("Roster capacity must be greater than zero.");
        }

        this.max = max;
        this.empList = new Employee[max];
        this.count = 0;
    }

    public Employee getEmployee(int index) {
        if (index < 0 || index >= count) {
            return null;
        }
        return empList[index];
    }

    public boolean addEmployee(Employee emp) {
        if (emp != null && count < max) {
            empList[count] = emp;
            count++;
            return true;
        }else return false;       
    }

    public Employee removeEmployee(int empID){
        Employee removed = null;
        int i;
        for ( i = 0; i < count && empList[i].getEmpID() != empID; i++) {}
        if(i < count){
            removed = empList[i];
            count--;
            for (; i < count; i++) {
                empList[i] = empList[i + 1];
            }
        }
        return removed;
    }

    public Employee searchEmployee(int empID) {
        for (int i = 0; i < count; i++) {
            if (empList[i].getEmpID() == empID) {
                return empList[i];
            }
        }

        return null;
    }

    public int countHE() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof HourlyEmployee) {
                total++;
            }
        }
        return total;
    }

    public int countPWE() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof PieceWorkerEmployee) {
                total++;
            }
        }
        return total;
    }

    public int countCE() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof CommissionEmployee
                    && !(empList[i] instanceof BasePlusCommissionEmployee)) {
                total++;
            }
        }
        return total;
    }

    public int countBPCE() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof BasePlusCommissionEmployee) {
                total++;
            }
        }
        return total;
    }

    public void displayHE() {
        System.out.println("\nHourly Employees:");

        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof HourlyEmployee) {
                System.out.println((i + 1) + ". " + empList[i]);
            }
        }
    }

    public void displayPWE() {
        System.out.println("\nPiece Worker Employees:");

        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof PieceWorkerEmployee) {
                System.out.println((i + 1) + ". " + empList[i]);
            }
        }
    }

    public void displayCE() {
        System.out.println("\nCommission Employees:");

        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof CommissionEmployee
                    && !(empList[i] instanceof BasePlusCommissionEmployee)) {
                System.out.println((i + 1) + ". " + empList[i]);
            }
        }
    }

    public void displayBPCE() {
        System.out.println("\nBase Plus Commission Employees:");

        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof BasePlusCommissionEmployee) {
                System.out.println((i + 1) + ". " + empList[i]);
            }
        }
    }

    public void displayAllEmployees() {
        System.out.println("\nRemaining Employees in Roster:");

        for (int i = 0; i < count; i++) {
            Employee current = empList[i];
            String type = current.getClass().getSimpleName();
            System.out.printf(
                    "%d. ID: %d | Name: %s | Type: %s%n",
                    i + 1,
                    current.getEmpID(),
                    current.getEmpName(),
                    type
            );
        }
    }

    public void displayPayroll(int currentMonth) {
        System.out.println("\n======================================================================");
        System.out.println("ROSTER PAYROLL REPORT (Target Month: "
                + getMonthName(currentMonth) + ")");
        System.out.println("======================================================================");

        for (int i = 0; i < count; i++) {
            Employee employee = empList[i];
            double regularPay = employee.computeSalary();
            double totalPay = employee.computeSalary(currentMonth);
            double birthdayBonus = totalPay - regularPay;
            String bonusText = birthdayBonus > 0 ? " (Birthday Bonus Applied)" : "";

            if (employee instanceof BasePlusCommissionEmployee) {
                BasePlusCommissionEmployee current =
                        (BasePlusCommissionEmployee) employee;
                System.out.printf(
                        "[%s] ID: %d | Name: %s | Salary: ₱%.2f%s%n",
                        "Base Plus Commission",
                        current.getEmpID(),
                        current.getEmpName(),
                        totalPay,
                        bonusText
                );
            } else if (employee instanceof CommissionEmployee) {
                CommissionEmployee current = (CommissionEmployee) employee;
                System.out.printf(
                        "[%s] ID: %d | Name: %s | Salary: ₱%.2f%s%n",
                        "Commission",
                        current.getEmpID(),
                        current.getEmpName(),
                        totalPay,
                        bonusText
                );
            } else if (employee instanceof PieceWorkerEmployee) {
                PieceWorkerEmployee current = (PieceWorkerEmployee) employee;
                System.out.printf(
                        "[%s] ID: %d | Name: %s | Salary: ₱%.2f%s%n",
                        "Piece Worker",
                        current.getEmpID(),
                        current.getEmpName(),
                        totalPay,
                        bonusText
                );
            } else if (employee instanceof HourlyEmployee) {
                HourlyEmployee current = (HourlyEmployee) employee;
                System.out.printf(
                        "[%s] ID: %d | Name: %s | Salary: ₱%.2f%s%n",
                        "Hourly",
                        current.getEmpID(),
                        current.getEmpName(),
                        totalPay,
                        bonusText
                );
            }
        }
    }

    private String getMonthName(int month) {
        String[] months = {
            "Jan", "Feb", "Mar", "Apr",
            "May", "Jun", "Jul", "Aug",
            "Sep", "Oct", "Nov", "Dec"
        };

        if (month < 1 || month > 12) {
            return "N/A";
        }

        return months[month - 1];
    }

    public int getCount() {
        return count;
    }

    public int getMax() {
        return max;
    }

    public String getEmployeeCategory(Employee emp) {
        if (emp instanceof HourlyEmployee) {
            return "Hourly";
        }
        if (emp instanceof PieceWorkerEmployee) {
            return "Piece Worker";
        }
        // Specific subclass must come BEFORE the more general parent class
        if (emp instanceof BasePlusCommissionEmployee) {
            return "Base Plus Commission";
        }
        if (emp instanceof CommissionEmployee) {
            return "Commission";
        }
        return "Unknown"; // Safe fallback if emp matches none of the types
    }


}
