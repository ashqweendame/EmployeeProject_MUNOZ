package version2;
public class Main2 {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("--- Hourly Employee Test ---");
        HourlyEmployee hourly1 = new HourlyEmployee();
        hourly1.setEmpID(101);
        Name name1 = new Name("Ashley", "Saniel", "Munoz");
        hourly1.setEmpName(name1);
        hourly1.setTotalHoursWorked(45.0F);
        hourly1.setRatePerHour(200.0);
        HourlyEmployee hourly2 = new HourlyEmployee(); //102, "Charlie Brown", 38.0F, 250.0
        System.out.println("[displayHourlyEmployee()]");
        hourly1.displayHourlyEmployee();
        hourly2.displayHourlyEmployee();
        System.out.println();
        System.out.println("[toString()]");
        System.out.println(hourly1);
        System.out.println(hourly2);
        System.out.println();
        System.out.println("--- Piece Worker Employee Test ---");
        PieceWorkerEmployee piece1 = new PieceWorkerEmployee();
        piece1.setEmpID(201);
        piece1.setEmpName("Miyuki Abe");
        piece1.setTotalPiecesFinished(250);
        piece1.setRatePerPiece(15.0);
        PieceWorkerEmployee piece2 = new PieceWorkerEmployee(202, "Keira Iway", 375, 20.0);
        System.out.println("[displayPieceWorkerEmployee()]");
        piece1.displayPieceWorkerEmployee();
        piece2.displayPieceWorkerEmployee();
        System.out.println();
        System.out.println("[toString()]");
        System.out.println(piece1);
        System.out.println(piece2);
        System.out.println();
        System.out.println("--- Commission Employee Test ---");
        CommissionEmployee commission1 = new CommissionEmployee();
        commission1.setEmpID(301);
        commission1.setEmpName("Kiril Camomot");
        commission1.setTotalSale(75000.0);
        CommissionEmployee commission2 = new CommissionEmployee(302, "Sean Arcay", 150000.0);
        System.out.println("[displayCommissionEmployee()]");
        commission1.displayCommissionEmployee();
        commission2.displayCommissionEmployee();
        System.out.println();
        System.out.println("[toString()]");
        System.out.println(commission1);
        System.out.println(commission2);
        System.out.println();
        System.out.println("--- Base Plus Commission Employee Test ---");
        BasePlusCommissionEmployee basePlus1 = new BasePlusCommissionEmployee();
        basePlus1.setEmpID(401);
        basePlus1.setEmpName("Lennox Thoma");
        basePlus1.setTotalSale(250000.0);
        basePlus1.setBaseSalary(15000.0);
        BasePlusCommissionEmployee basePlus2 = new BasePlusCommissionEmployee(402, "Henry Clark", 600000.0, 25000.0);
        System.out.println("[displayBasePlusCommissionEmployee()]");
        basePlus1.displayBasePlusCommissionEmployee();
        basePlus2.displayBasePlusCommissionEmployee();
        System.out.println();
        System.out.println("[toString()]");
        System.out.println(basePlus1);
        System.out.println(basePlus2);
    }
}