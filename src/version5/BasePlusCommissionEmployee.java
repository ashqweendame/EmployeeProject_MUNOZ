package version5;

import java.util.Objects;

public class BasePlusCommissionEmployee
        extends CommissionEmployee {

    private double baseSalary;

    public BasePlusCommissionEmployee() {
        super();
    }

    public BasePlusCommissionEmployee(
            int empID,
            Name empName,
            MyDate birthDate,
            MyDate dateHired,
            double totalSale,
            double baseSalary) {

        super(
                empID,
                empName,
                birthDate,
                dateHired,
                totalSale
        );

        setBaseSalary(baseSalary);
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary < 0) {
            throw new IllegalArgumentException("Base salary cannot be negative.");
        }

        this.baseSalary = baseSalary;
    }

    @Override
    public double computeSalary(int currentMonth) {
        double pay = baseSalary + getTotalSale() * getCommissionRate();

        if (hasBirthdayIn(currentMonth)) {
            pay += BIRTHDAY_BONUS;
        }

        return pay;
    }

    public void displayBasePlusCommissionEmployee() {
        displayEmployee();

        System.out.printf(
            "Base Salary: ₱%.2f | Total Sales: ₱%.2f | " +
            "Commission Rate: %.2f%%%n",
            baseSalary,
            getTotalSale(),
            getCommissionRate() * 100
        );
    }

    @Override
    public String toString() {
        return String.format(
            "BasePlusCommissionEmployee [ID: %d, Name: %s, " +
            "DOB: %s, Hired: %s, Base: ₱%.2f, Sales: ₱%.2f, " +
            "Total Compensation: ₱%.2f]",
            getEmpID(),
            getEmpName(),
            getBirthDate(),
            getDateHired(),
            baseSalary,
            getTotalSale(),
            computeSalary(getBirthDate().getMonth())
        );
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof BasePlusCommissionEmployee)) {
            return false;
        }

        BasePlusCommissionEmployee other =
                (BasePlusCommissionEmployee) obj;

        return super.equals(obj)
                && Double.compare(baseSalary, other.baseSalary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), baseSalary);
    }

    @Override
    public BasePlusCommissionEmployee clone() {
        return (BasePlusCommissionEmployee) super.clone();
    }
}
