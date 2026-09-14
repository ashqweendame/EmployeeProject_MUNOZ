package version1;

public class PieceWorkerEmployee {
    private int empID;
    private String empName;
    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() {
        this.empID = 0;
        this.empName = "N/A";
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0.0;
    }

    public PieceWorkerEmployee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0.0;
    }

    public PieceWorkerEmployee(int empID, String empName, int totalPiecesFinished, double ratePerPiece) {
        this.empID = empID;
        this.empName = empName;
        this.totalPiecesFinished = totalPiecesFinished;
        this.ratePerPiece = ratePerPiece;
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

    public int getTotalPiecesFinished() {
        return this.totalPiecesFinished;
    }

    public void setTotalPiecesFinished(int totalPiecesFinished) {
        if (totalPiecesFinished >= 0) {
            this.totalPiecesFinished = totalPiecesFinished;
        }

    }

    public double getRatePerPiece() {
        return this.ratePerPiece;
    }

    public void setRatePerPiece(double ratePerPiece) {
        if (ratePerPiece >= 0.0) {
            this.ratePerPiece = ratePerPiece;
        }

    }

    public double computeSalary() {
        double basePay = (double)this.totalPiecesFinished * this.ratePerPiece;
        int completeHundreds = this.totalPiecesFinished / 100;
        double bonusPay = (double)completeHundreds * 10.0 * this.ratePerPiece;
        return basePay + bonusPay;
    }

    public void displayPieceWorkerEmployee() {
        System.out.printf("ID: %d | Name: %s | Pieces Finished: %d | Rate/Piece: ₱%.2f%n", this.empID, this.empName, this.totalPiecesFinished, this.ratePerPiece);
    }

    public String toString() {
        return String.format("PieceWorkerEmployee [ID: %d, Name: %s, Pieces: %d, Rate: ₱%.2f, Total Salary: ₱%,.2f]", this.empID, this.empName, this.totalPiecesFinished, this.ratePerPiece, this.computeSalary());
    }
}
