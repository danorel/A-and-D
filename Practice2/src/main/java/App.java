public class App {
    public static void main(String[] args) {
        Nickname []nicknames = new Nickname[3];
        nicknames[0].setNickname("Daniel");
        nicknames[1].setNickname("Olchik");
        nicknames[2].setNickname("Tvaruna");

        Sorter<Double> sorter = new Sorter<Double>();
        sorter.setArray(nicknames);
        sorter.selectionSort();
        sorter.showArray();
    }
}
