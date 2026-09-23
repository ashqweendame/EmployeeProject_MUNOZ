package version4;

import java.util.Objects;

public class HourlyEmployee extends Employee {
    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee() {
        super();
    }

    public HourlyEmployee(
            int empID,
            Name empName,
            MyDate birthDate,
            MyDate dateHired,
            float totalHoursWorked,
            double ratePerHour) {

        super(empID, empName, birthDate, dateHired);

        setTotalHoursWorked(totalHoursWorked);
        setRatePerHour(ratePerHour);
    }

    public float getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public void setTotalHoursWorked(float totalHoursWorked) {
        if (totalHoursWorked < 0) {
            throw new IllegalArgumentException("Total hours worked cannot be negative.");
        }

        this.totalHoursWorked = totalHoursWorked;
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(double ratePerHour) {
        if (ratePerHour < 0) {
            throw new IllegalArgumentException("Rate per hour cannot be negative.");
        }

        this.ratePerHour = ratePerHour;
    }

    private double calculateRegularAndOvertimePay() {
        if (totalHoursWorked <= 40) {
            return totalHoursWorked * ratePerHour;
        }

        double regularPay = 40 * ratePerHour;
        double overtimePay = (totalHoursWorked - 40) * ratePerHour * 1.5;

        return regularPay + overtimePay;
    }

    @Override
    public double computeSalary(int currentMonth) {
        return calculateRegularAndOvertimePay()
                + super.computeSalary(currentMonth);
    }

    public void displayHourlyEmployee() {
        displayEmployee();

        System.out.printf(
                "Hours Worked: %.2f | Rate/Hour: ₱%.2f%n",
                totalHoursWorked,
                ratePerHour);
    }

    @Override
    public String toString() {
        return String.format(
            "HourlyEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s, " +
            "Hours: %.2f, Rate: ₱%.2f, Salary: ₱%.2f]",
            getEmpID(),
            getEmpName(),
            getBirthDate(),
            getDateHired(),
            totalHoursWorked,
            ratePerHour,
            computeSalary(getBirthDate().getMonth())
        );
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof HourlyEmployee)) {
            return false;
        }

        HourlyEmployee other = (HourlyEmployee) obj;

        return super.equals(obj)
                && Float.compare(totalHoursWorked, other.totalHoursWorked) == 0
                && Double.compare(ratePerHour, other.ratePerHour) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            super.hashCode(),
            totalHoursWorked,
            ratePerHour
        );
    }

    @Override
    public HourlyEmployee clone() {
        return (HourlyEmployee) super.clone();
    }
}
