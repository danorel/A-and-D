package date;

import com.sun.javafx.binding.StringFormatter;

public class Date {
//    [1920; 2099]
//    get day of the week in this year by the date
//    1 jan 1920 - thursday

    /*
        Default values per undefined year/month variable in the constructor:
        - Year : 1920 (YEAR_LEFT_BORDER)
        - Month : 0 (January)
        - Day : 1 (first day of the month )
     */

    private final static int YEAR_LEFT_BORDER = 1920;
    private final static int YEAR_RIGHT_BORDER = 2099;
    private final static int[] DAY_AMOUNT_PER_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private int year;
    private int month;
    private int day;

    public Date(int day){
        this(day, 0);
    }

    public Date(int day, int month){
        this(day, month, YEAR_LEFT_BORDER);
    }

    public Date(int day, int month, int year){
        this.day = validateDay(day, month, year);
        this.month = month;
        this.year = year;
    }

    private int validateDay(int day, int month, int year){
        if(year % 4 != 0){
            if(day <= DAY_AMOUNT_PER_MONTH[month]){
                return day;
            } else {
                return 1;
            }
        } else {
            if(day <= DAY_AMOUNT_PER_MONTH[month])
        }
    }

    private int validateMonth(int month, int year){
        if(year ){
            return day;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return StringFormatter.format(
                "date.Date: %s:%s:%s", getDay() < 10 ? "0" + getDay() : getDay(), getMonth() < 10 ? "0" + getMonth() : getMonth(), getYear()
        ).toString();
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }
}
