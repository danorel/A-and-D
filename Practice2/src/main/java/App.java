import nicknames.Nickname;
import nicknames.comparators.*;
import persons.Person;
import persons.comparators.*;
import sorter.Sorter;

public class App {
    public static void main(String[] args) {
        // Sorting nicknames example
        Nickname[] nicknames = new Nickname[4];
        nicknames[0] = new Nickname();
        nicknames[0].setNickname("Orel");
        nicknames[1] = new Nickname();
        nicknames[1].setNickname("Daniel");
        nicknames[2] = new Nickname();
        nicknames[2].setNickname("Olia");
        nicknames[3] = new Nickname();
        nicknames[3].setNickname("Pencils");
        sorter.Sorter<nicknames.Nickname> sorter = new sorter.Sorter<Nickname>();
        sorter.setComparator(new NicknameComparator()).setArray(nicknames).selectionSort().showArray();
        System.out.println();

        // Person sorting example
        Person[] people = new Person[4];
        people[0] = new Person();
        people[0].setName("Daniel").setAge(18).setSurname("Orel");
        people[1] = new Person();
        people[1].setName("Inesa").setAge(50).setSurname("Orel");
        people[2] = new Person();
        people[2].setName("Mark").setAge(24).setSurname("Orel");
        people[3] = new Person();
        people[3].setName("Olia").setAge(18).setSurname("Perch");
        Sorter<Person> personSorter = new Sorter<Person>();
        personSorter.setComparator(new PersonNameComparator()).setArray(people).bubbleSort().showArray();

        // Integer sorting example
        System.out.println();
        Integer []integers = {51, 43, 0, Integer.MAX_VALUE, 9, -4, 104};
        Sorter<Integer> integerSorter = new Sorter<Integer>();
        integerSorter.setArray(integers).bubbleSort().showArray();
    }
}
