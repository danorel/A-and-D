package date;

import java.util.HashMap;

public class Week {
    private HashMap<Integer, String> week = new HashMap<>();

    public Week(){
        week.put(0, "Thursday");
        week.put(1, "Friday");
        week.put(2, "Saturday");
        week.put(3, "Sunday");
        week.put(4, "Monday");
        week.put(5, "Tuesday");
        week.put(6, "Wednesday");
    }

    public String getDay(int key){
        return week.get(key);
    }
}
