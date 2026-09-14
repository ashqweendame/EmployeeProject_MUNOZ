package version2;

public class MyDate {
    private int date;
    private int month;
    private int year;

    public MyDate(){
        this.date = 1;
        this.month = 1;
        this.year = 1;
    }

    public MyDate(int date, int month, int year){
        this.date = date;
        this.month = month;
        this.year = year;
    }

    public int getDate() { return date; }
    public void setDate(int date) { this.date = date; }
    public int getMonth() { return month; }
    public void setMonth(int month) { this.month = month; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
}
