public class Nickname implements Comparable<Nickname>{
    private String nickname;
    private int nicknameLength;

    public String getNickname() {
        return nickname;
    }

    public Nickname setNickname(String nickname) {
        this.nickname = nickname;
        nicknameLength = this.nickname.length();
        return this;
    }

    public int compareTo(Nickname object) {
        return nickname.compareTo(object.nickname);
    }

    @Override
    public String toString() {
        return nickname;
    }

    public int getNicknameLength() {
        return nicknameLength;
    }
}
