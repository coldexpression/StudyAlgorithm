package Level1;

import java.util.regex.Pattern;

public class problem12925 {

    public static void main(String[] args) {

    }

    public int solution(String s) {
        int answer = 0;

        if (s.contains("+")) {
            answer = Integer.parseInt(s.substring(1));
        } else if (s.contains("-")) {
            answer = -(Integer.parseInt(s.substring(1)));
        } else {
            answer = Integer.parseInt(s);
        }

        return answer;
    }
}
