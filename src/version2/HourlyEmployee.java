package version2;

public class HourlyEmployee {
    private int empID;
    private Name empName;
    private float totalHoursWorked;
    private double ratePerHour;
    private MyDate empBirthDate;

    public HourlyEmployee() {
        this.empID = 0;
        this.empName = new Name();
        this.totalHoursWorked = 0.0F;
        this.ratePerHour = 0.0;
        this.empBirthDate = new MyDate();
    }

    public HourlyEmployee(int empID, Name empName, MyDate empBirthDate) {
        this.empID = empID;
        this.empName = empName;
        this.totalHoursWorked = 0.0F;
        this.ratePerHour = 0.0;
        this.empBirthDate = empBirthDate;
    }

    public HourlyEmployee(int empID, Name empName, float totalHoursWorked, double ratePerHour, MyDate empBirthDate) {
        this.empID = empID;
        this.empName = empName;
        this.totalHoursWorked = totalHoursWorked;
        this.ratePerHour = ratePerHour;
        this.empBirthDate = empBirthDate;
    }

    public int getEmpID() { return this.empID; }
    public void setEmpID(int empID) { if (empID >= 0) this.empID = empID; }

    public Name getEmpName() { return this.empName; }
    public void setEmpName(Name empName) { if (empName != null) this.empName = empName; }

    public float getTotalHoursWorked() { return this.totalHoursWorked; }
    public void setTotalHoursWorked(float totalHoursWorked) { if (totalHoursWorked >= 0.0F) this.totalHoursWorked = totalHoursWorked; }

    public double getRatePerHour() { return this.ratePerHour; }
    public void setRatePerHour(double ratePerHour) { if (ratePerHour >= 0.0) this.ratePerHour = ratePerHour; }

    public MyDate getEmpBirthDate() { return this.empBirthDate; }
    public void setEmpBirthDate(MyDate empBirthDate) { this.empBirthDate = empBirthDate; }

    public double computeSalary() {
        if (this.totalHoursWorked <= 40.0F) {
            return (double)this.totalHoursWorked * this.ratePerHour;
        } else {
            double overtimeHours = (double)(this.totalHoursWorked - 40.0F);
            double overtimeRate = this.ratePerHour * 1.5;
            double standard = 40.0 * this.ratePerHour;
            return standard + (overtimeHours * overtimeRate);
        }
    }

    public double salaryWithBirthdayBonus(MyDate currentDate) {
        double baseSalary = computeSalary();
        if (this.empBirthDate != null && currentDate != null && this.empBirthDate.getMonth() == currentDate.getMonth()) {
            double birthdayBonus = 5000.00;
            return baseSalary + birthdayBonus;
        }
        return baseSalary;
    }

    public void displayHourlyEmployee() {
        System.out.printf("ID: %d | Name: %s, %s %c. | Hours: %.2f | Rate: ₱%.2f/hr%n",
                this.empID, this.empName.getLastname(), this.empName.getFirstname(), this.empName.getMiddleIn(), this.totalHoursWorked, this.ratePerHour);
    }

    @Override
    public String toString() {
        return String.format("HourlyEmployee [ID: %d, Name: %s %s, Hours: %.2f, Rate: ₱%.2f, Total Salary: ₱%,.2f]",
                this.empID, this.empName.getFirstname(), this.empName.getLastname(), this.totalHoursWorked, this.ratePerHour, this.computeSalary());
    }
}
