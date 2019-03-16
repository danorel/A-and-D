package date;

import java.util.HashMap;

public class Month {
    private HashMap<String, Integer> month;

    public Month(){
        month = new HashMap<>();
        month.put("January", 0);
        month.put("February", 1);
        month.put("March", 2);
        month.put("April", 3);
        month.put("May", 4);
        month.put("June", 5);
        month.put("July", 6);
        month.put("August", 7);
        month.put("September", 8);
        month.put("October", 9);
        month.put("November", 10);
        month.put("December", 11);
    }

    public int getMonth(String month){
        return this.month.get(month.substring(0, 1).toUpperCase() + month.substring(1).toLowerCase());
    }
}
