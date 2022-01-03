package Level1;

import java.util.regex.Pattern;

public class problem12918 {

    public static void main(String[] args) {

    }

    public boolean solution(String s) {
        boolean answer = Pattern.matches("^[0-9]*$", s) && !Pattern.matches("^[a-zA-Z]*$", s) && (s.length() == 4 || s.length() == 6);

        return answer;
    }
}
