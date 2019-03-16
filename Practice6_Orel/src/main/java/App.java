import date.Date;

public class App {
    public static void main(String[] args) {
        Date date = new Date("04 december 2000");
        System.out.println(date);
        System.out.println(date.getDayOfWeek());
    }
}
