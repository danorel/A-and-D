public class Nickname implements Comparable<Nickname>{
    private String nickname;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int compareTo(Nickname nickname) {
        return this.nickname.compareTo(String.valueOf(nickname));
    }
}
