package version1;

public class HourlyEmployee {
    private int empID;
    private String empName;
    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee() {
        this.empID = 0;
        this.empName = "N/A";
        this.totalHoursWorked = 0.0F;
        this.ratePerHour = 0.0;
    }

    public HourlyEmployee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
        this.totalHoursWorked = 0.0F;
        this.ratePerHour = 0.0;
    }

    public HourlyEmployee(int empID, String empName, float totalHoursWorked, double ratePerHour) {
        this.empID = empID;
        this.empName = empName;
        this.totalHoursWorked = totalHoursWorked;
        this.ratePerHour = ratePerHour;
    }

    public int getEmpID() {
        return this.empID;
    }

    public void setEmpID(int empID) {
        if (empID >= 0) {
            this.empID = empID;
        }

    }

    public String getEmpName() {
        return this.empName;
    }

    public void setEmpName(String empName) {
        if (empName != null && !empName.trim().isEmpty()) {
            this.empName = empName;
        }

    }

    public float getTotalHoursWorked() {
        return this.totalHoursWorked;
    }

    public void setTotalHoursWorked(float totalHoursWorked) {
        if (totalHoursWorked >= 0.0F) {
            this.totalHoursWorked = totalHoursWorked;
        }

    }

    public double getRatePerHour() {
        return this.ratePerHour;
    }

    public void setRatePerHour(double ratePerHour) {
        if (ratePerHour >= 0.0) {
            this.ratePerHour = ratePerHour;
        }

    }

    public double computeSalary() {
        if (this.totalHoursWorked <= 40.0F) {
            return (double)this.totalHoursWorked * this.ratePerHour;
        } else {
            double overtimeHours = (double)(this.totalHoursWorked - 40.0F);
            double overtimeRate = this.ratePerHour * 1.5;
            double standard = 40.0 * this.ratePerHour;
            return standard + overtimeHours * overtimeRate;
        }
    }

    public void displayHourlyEmployee() {
        System.out.printf("ID: %d | Name: %s | Hours: %.2f | Rate: ₱%.2f/hr%n", this.empID, this.empName, this.totalHoursWorked, this.ratePerHour);
    }

    public String toString() {
        return String.format("HourlyEmployee [ID: %d, Name: %s, Hours: %.2f, Rate: ₱%.2f, Total Salary: ₱%,.2f]", this.empID, this.empName, this.totalHoursWorked, this.ratePerHour, this.computeSalary());
    }
}
