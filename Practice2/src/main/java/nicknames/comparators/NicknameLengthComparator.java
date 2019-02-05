package nicknames.comparators;

import nicknames.Nickname;

import java.util.Comparator;

public class NicknameLengthComparator implements Comparator<Nickname> {
    public int compare(Nickname firstNickname, Nickname secondNickname) {
        return firstNickname.getNicknameLength() - secondNickname.getNicknameLength();
    }
}
