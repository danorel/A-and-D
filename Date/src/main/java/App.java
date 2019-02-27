import date.Date;

public class App {
    public static void main(String[] args) {
        Date date = new Date("04 12 2043");
        System.out.println(date);
        System.out.println(date.getDayOfWeek());
    }
}
