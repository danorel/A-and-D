package date;

import com.sun.javafx.binding.StringFormatter;

import java.util.Arrays;
import java.util.List;

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
        this.year = validateYear(year);
        this.month = validateMonth(month - 1);
        this.day = validateDay(day, this.month, this.year);
    }

    public Date(String date){
        List<String> parts = Arrays.asList(date.split(" "));
        if(parts.size() == 3){
            if(parts.get(2).matches("[0-9]+")){
                this.year = validateYear(Integer.valueOf(parts.get(parts.size() - 1)));
            } else {
                this.year = YEAR_LEFT_BORDER;
            }
            if(parts.get(1).matches("[0-9]+")){
                this.month = validateMonth(Integer.valueOf(parts.get(parts.size() - 2)) - 1);
            } else {
                this.month = 0;
            }
            if(parts.get(0).matches("[0-9]+")){
                this.day = validateDay(Integer.valueOf(parts.get(parts.size() - 3)), this.month, this.year);
            } else {
                this.day = 1;
            }
        } else {
            this.year = YEAR_LEFT_BORDER;
            this.month = 0;
            this.day = 1;
        }
    }

    private int validateYear(int year){
        return year >= YEAR_LEFT_BORDER && year <= YEAR_RIGHT_BORDER ? year : YEAR_LEFT_BORDER;
    }

    private int validateDay(int day, int month, int year){
        if(year % 4 == 0){
            if(month == 1){
                if(day <= DAY_AMOUNT_PER_MONTH[month] + 1 && day >= 1){
                    return day;
                } else {
                    return 1;
                }
            } else {
                if(day <= DAY_AMOUNT_PER_MONTH[month] && day >= 1){
                    return day;
                } else {
                    return 1;
                }
            }
        } else {
            if(day <= DAY_AMOUNT_PER_MONTH[month] && day >= 1){
                return day;
            } else {
                return 1;
            }
        }
    }

    private int validateMonth(int month){
        return month >= 0 && month <= 11 ? month : 0;
    }

    public String getDayOfWeek(){
        Week week = new Week();
        return week.getDay(getAmountOfDays(this.day, this.month, this.year));
    }

    private int getAmountOfDaysByYear(int year){
        int totalAmountOfDays = 0;
        for(int month = 0; month < DAY_AMOUNT_PER_MONTH.length; month++){
            totalAmountOfDays += DAY_AMOUNT_PER_MONTH[month];
        }
        if(year % 4 == 0){
            return totalAmountOfDays + 1;
        } else {
            return totalAmountOfDays;
        }
    }

    private int getAmountOfDays(int day, int month, int year){
        int totalAmountOfDays = 0;
        for(int currentYear = YEAR_LEFT_BORDER; currentYear < this.year; currentYear++){
            totalAmountOfDays += getAmountOfDaysByYear(currentYear);
        }
        if(this.year % 4 == 0){
            for(int currentMonth = 0; currentMonth < this.month; currentMonth++){
                if(currentMonth == 1){
                    totalAmountOfDays += DAY_AMOUNT_PER_MONTH[currentMonth] + 1;
                } else {
                    totalAmountOfDays += DAY_AMOUNT_PER_MONTH[currentMonth];
                }
            }
        } else {
            for(int currentMonth = 0; currentMonth < this.month; currentMonth++){
                totalAmountOfDays += DAY_AMOUNT_PER_MONTH[currentMonth];
            }
        }
        totalAmountOfDays += (this.day - 1);
        return totalAmountOfDays % 7;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month + 1;
    }

    public int getDay() {
        return day;
    }

    @Override
    public String toString() {
        return StringFormatter.format(
                "%s.%s.%s", getDay() < 10 ? "0" + getDay() : getDay(), getMonth() < 9 ? "0" + (getMonth()) : (getMonth()), getYear()
        ).getValue();
    }
}
