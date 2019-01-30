public class App {
    public static void main(String[] args) {
        Nickname []nicknames = new Nickname[4];
        nicknames[0] = new Nickname();
        nicknames[0].setNickname("Orel Dan");
        nicknames[1] = new Nickname();
        nicknames[1].setNickname("Dan");
        nicknames[2] = new Nickname();
        nicknames[2].setNickname("O");
        nicknames[3] = new Nickname();
        nicknames[3].setNickname("Ohhhs");

        Sorter<Nickname> sorter = new Sorter<Nickname>();
        sorter.setArray(nicknames).selectionSort().showArray();
    }
}
