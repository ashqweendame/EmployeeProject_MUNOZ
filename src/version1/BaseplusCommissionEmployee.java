package version1;

public class BasePlusCommissionEmployee {
    private int empID;
    private String empName;
    private double totalSale;
    private double baseSalary;

    public BasePlusCommissionEmployee() {
        this.empID = 0;
        this.empName = "N/A";
        this.totalSale = 0.0;
        this.baseSalary = 0.0;
    }

    public BasePlusCommissionEmployee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
        this.totalSale = 0.0;
        this.baseSalary = 0.0;
    }

    public BasePlusCommissionEmployee(int empID, String empName, double totalSale, double baseSalary) {
        this.empID = empID;
        this.empName = empName;
        this.setTotalSale(totalSale);
        this.setBaseSalary(baseSalary);
    }

    public int getEmpID() {
        return this.empID;
    }

    public String getEmpName() {
        return this.empName;
    }

    public double getTotalSale() {
        return this.totalSale;
    }

    public double getBaseSalary() {
        return this.baseSalary;
    }

    public void setEmpID(int empID) {
        if (empID >= 0) {
            this.empID = empID;
        }

    }

    public void setEmpName(String empName) {
        if (empName != null && !empName.trim().isEmpty()) {
            this.empName = empName;
        }

    }

    public void setTotalSale(double totalSale) {
        if (totalSale >= 0.0) {
            this.totalSale = totalSale;
        }

    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary >= 0.0) {
            this.baseSalary = baseSalary;
        }

    }

    private double getCommissionRate() {
        if (this.totalSale < 50000.0) {
            return 0.05;
        } else if (this.totalSale < 100000.0) {
            return 0.1;
        } else {
            return this.totalSale < 500000.0 ? 0.15 : 0.2;
        }
    }

    public double computeSalary() {
        double commission = this.totalSale * this.getCommissionRate();
        return this.baseSalary + commission;
    }

    public void displayBasePlusCommissionEmployee() {
        System.out.printf("ID: %d | Name: %s | Total Sale: ₱%,.2f | Base Salary: ₱%,.2f%n", this.empID, this.empName, this.totalSale, this.baseSalary);
    }

    public String toString() {
        return String.format("BasePlusCommissionEmployee [ID: %d, Name: %s, Sales: ₱%,.2f, Base Salary: ₱%,.2f, Commission Rate: %.0f%%, Total Salary: ₱%,.2f]", this.empID, this.empName, this.totalSale, this.baseSalary, this.getCommissionRate() * 100.0, this.computeSalary());
    }
}
