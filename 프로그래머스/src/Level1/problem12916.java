package Level1;

public class problem12916 {

    public static void main(String[] args) {

    }

    public boolean solution(String s) {
        String string = s.toLowerCase();
        String[] split = string.split("");
        int p_count = 0;
        int y_count = 0;
        for (String word : split) {
            p_count = word.equals("p") ? p_count+1 : p_count;
            y_count = word.equals("y") ? y_count+1 : y_count;
        }


        if (p_count == 0 && y_count == 0) return true;
        return p_count == y_count;
    }
}
