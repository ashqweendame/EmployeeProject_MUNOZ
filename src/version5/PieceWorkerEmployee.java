package version5;

import java.util.Objects;

public class PieceWorkerEmployee extends Employee {
    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() {
        super();
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0.0;
    }

    public PieceWorkerEmployee(
            int empID,
            Name empName,
            MyDate birthDate,
            MyDate dateHired,
            int totalPiecesFinished,
            double ratePerPiece) {

        super(empID, empName, birthDate, dateHired);

        setTotalPiecesFinished(totalPiecesFinished);
        setRatePerPiece(ratePerPiece);
    }

    public int getTotalPiecesFinished() {
        return totalPiecesFinished;
    }

    public void setTotalPiecesFinished(int totalPiecesFinished) {
        if (totalPiecesFinished < 0) {
            throw new IllegalArgumentException(
                    "Total pieces finished cannot be negative."
            );
        }

        this.totalPiecesFinished = totalPiecesFinished;
    }

    public double getRatePerPiece() {
        return ratePerPiece;
    }

    public void setRatePerPiece(double ratePerPiece) {
        if (ratePerPiece < 0) {
            throw new IllegalArgumentException(
                    "Rate per piece cannot be negative."
            );
        }

        this.ratePerPiece = ratePerPiece;
    }

    private double calculatePiecePay() {
        int bonusBlocks = totalPiecesFinished / 100;

        return (totalPiecesFinished + bonusBlocks * 10) * ratePerPiece;
    }

    @Override
    public double computeSalary(int currentMonth) {
        double pay = calculatePiecePay();

        if (hasBirthdayIn(currentMonth)) {
            pay += BIRTHDAY_BONUS;
        }

        return pay;
    }

    public void displayPieceWorkerEmployee() {
        displayEmployee();

        System.out.printf(
                "Pieces Finished: %d | Rate/Piece: ₱%.2f%n",
                totalPiecesFinished,
                ratePerPiece);
    }

    @Override
    public String toString() {
        return String.format(
                "PieceWorkerEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s, "
                        + "Pieces: %d, Rate: ₱%.2f, Salary: ₱%.2f]",
                getEmpID(),
                getEmpName(),
                getBirthDate(),
                getDateHired(),
                totalPiecesFinished,
                ratePerPiece,
                computeSalary(getBirthDate().getMonth())
        );
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof PieceWorkerEmployee)) {
            return false;
        }

        PieceWorkerEmployee other = (PieceWorkerEmployee) obj;

        return super.equals(obj)
                && totalPiecesFinished == other.totalPiecesFinished
                && Double.compare(ratePerPiece, other.ratePerPiece) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            super.hashCode(),
            totalPiecesFinished,
            ratePerPiece
        );
    }

    @Override
    public PieceWorkerEmployee clone() {
        return (PieceWorkerEmployee) super.clone();
    }
}
