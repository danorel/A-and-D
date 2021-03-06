package nicknames.comparators;

import nicknames.Nickname;

import java.util.Comparator;

public class NicknameComparator implements Comparator<Nickname> {
    public int compare(Nickname firstNickname, Nickname secondNickname) {
        return firstNickname.getNickname().compareTo(secondNickname.getNickname());
    }
}
