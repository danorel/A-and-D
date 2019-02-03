import com.sun.javafx.binding.StringFormatter;
import javafx.beans.binding.StringExpression;

public class App {
    public static void main(String[] args) {
        Nickname[] nicknames = new Nickname[4];
        nicknames[0] = new Nickname();
        nicknames[0].setNickname("Orel");
        nicknames[1] = new Nickname();
        nicknames[1].setNickname("Daniel");
        nicknames[2] = new Nickname();
        nicknames[2].setNickname("Olia");
        nicknames[3] = new Nickname();
        nicknames[3].setNickname("Pencil");

//        Sorter<Nickname> sorter = new Sorter<Nickname>();
//        sorter.setArray(nicknames).selectionSort().showArray();
//        System.out.println();

        Person[] people = new Person[4];
        people[0] = new Person();
        people[0].setName("Masya").setAge(170);
        people[1] = new Person();
        people[1].setName("Kitsya").setAge(23);
        people[2] = new Person();
        people[2].setName("Pisun").setAge(54);
        people[3] = new Person();
        people[3].setName("Tu").setAge(1);
        Sorter<Person> personSorter = new Sorter<>();
        personSorter.setArray(people).bubbleSort().showArray();



    }


}
