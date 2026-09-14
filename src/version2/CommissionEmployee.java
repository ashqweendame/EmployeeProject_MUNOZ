package version2;

public class CommissionEmployee {
    private int empID;
    private String empName;
    private double totalSale;

    public CommissionEmployee() {
        this.empID = 0;
        this.empName = "N/A";
        this.totalSale = 0.0;
    }

    public CommissionEmployee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
        this.totalSale = 0.0;
    }

    public CommissionEmployee(int empID, String empName, double totalSale) {
        this.empID = empID;
        this.empName = empName;
        this.setTotalSale(totalSale);
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
        return this.totalSale * this.getCommissionRate();
    }

    public void displayCommissionEmployee() {
        System.out.printf("ID: %d | Name: %s | Total Sale: ₱%,.2f%n", this.empID, this.empName, this.totalSale);
    }

    public String toString() {
        return String.format("CommissionEmployee [ID: %d, Name: %s, Total Sale: ₱%,.2f, Commission Rate: %.0f%%, Total Salary: ₱%,.2f]", this.empID, this.empName, this.totalSale, this.getCommissionRate() * 100.0, this.computeSalary());
    }
}
