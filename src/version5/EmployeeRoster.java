package version5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmployeeRoster {
    private final List<Employee> empList;
    private final int max;

    public EmployeeRoster() {
        this(10);
    }

    public EmployeeRoster(int max) {
        if (max <= 0) {
            throw new IllegalArgumentException("Roster capacity must be greater than zero.");
        }

        this.max = max;
        this.empList = new ArrayList<>(max);
    }

    public Employee getEmployee(int index) {
        if (index < 0 || index >= empList.size()) {
            return null;
        }
        return empList.get(index);
    }

    public boolean addEmployee(Employee emp) {
        if (emp == null) {
            return false;
        }

        empList.add(emp);
        return true;
    }

    public Employee removeEmployee(int empID) {
        Iterator<Employee> iterator = empList.iterator();

        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getEmpID() == empID) {
                iterator.remove();
                return employee;
            }
        }

        return null;
    }

    public Employee searchEmployee(int empID) {
        for (Employee employee : empList) {
            if (employee.getEmpID() == empID) {
                return employee;
            }
        }

        return null;
    }

    public int countHE() {
        int total = 0;
        for (Employee employee : empList) {
            if (employee instanceof HourlyEmployee) {
                total++;
            }
        }
        return total;
    }

    public int countPWE() {
        int total = 0;
        for (Employee employee : empList) {
            if (employee instanceof PieceWorkerEmployee) {
                total++;
            }
        }
        return total;
    }

    public int countCE() {
        int total = 0;
        for (Employee employee : empList) {
            if (employee instanceof CommissionEmployee
                    && !(employee instanceof BasePlusCommissionEmployee)) {
                total++;
            }
        }
        return total;
    }

    public int countBPCE() {
        int total = 0;
        for (Employee employee : empList) {
            if (employee instanceof BasePlusCommissionEmployee) {
                total++;
            }
        }
        return total;
    }

    public void displayHE() {
        System.out.println("\nHourly Employees:");

        int index = 1;
        for (Employee employee : empList) {
            if (employee instanceof HourlyEmployee) {
                System.out.println(index + ". " + employee);
                index++;
            }
        }
    }

    public void displayPWE() {
        System.out.println("\nPiece Worker Employees:");

        int index = 1;
        for (Employee employee : empList) {
            if (employee instanceof PieceWorkerEmployee) {
                System.out.println(index + ". " + employee);
                index++;
            }
        }
    }

    public void displayCE() {
        System.out.println("\nCommission Employees:");

        int index = 1;
        for (Employee employee : empList) {
            if (employee instanceof CommissionEmployee
                    && !(employee instanceof BasePlusCommissionEmployee)) {
                System.out.println(index + ". " + employee);
                index++;
            }
        }
    }

    public void displayBPCE() {
        System.out.println("\nBase Plus Commission Employees:");

        int index = 1;
        for (Employee employee : empList) {
            if (employee instanceof BasePlusCommissionEmployee) {
                System.out.println(index + ". " + employee);
                index++;
            }
        }
    }

    public void displayAllEmployees() {
        System.out.println();

        for (int i = 0; i < empList.size(); i++) {
            Employee current = empList.get(i);
            String type = current.getClass().getSimpleName();
            System.out.printf(
                    "%d. %s [ID: %d, Name: %s, Total Salary: ₱%.2f]%n",
                    i + 1,
                    type,
                    current.getEmpID(),
                    current.getEmpName(),
                    current.computeSalary()
            );
        }
    }

    public void displayPayroll(int currentMonth) {
        System.out.println();
        System.out.println("======================================================================");
        System.out.println("PURE POLYMORPHIC PAYROLL REPORT (Target Month: "
                + getMonthName(currentMonth) + ")");
        System.out.println("[No downcasting; dynamic dispatch via Employee.computeSalary()]");
        System.out.println("======================================================================");

        for (Employee employee : empList) {
            double totalPay = employee.computeSalary(currentMonth);
            double basePay = employee.computeSalary();
            double birthdayBonus = totalPay - basePay;
            String bonusText = birthdayBonus > 0 ? " (Birthday Bonus Applied)" : "";

            System.out.printf(
                    "ID: %d | Name: %s | Payout: ₱%,.2f%s%n",
                    employee.getEmpID(),
                    employee.getEmpName(),
                    totalPay,
                    bonusText
            );
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
        return empList.size();
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
        if (emp instanceof BasePlusCommissionEmployee) {
            return "Base Plus Commission";
        }
        if (emp instanceof CommissionEmployee) {
            return "Commission";
        }
        return "Unknown";
    }
}

