package Level2;

public class problem12951 {

    public static void main(String[] args) {

    }

    public String solution(String s) {
        String answer = "";
        boolean check = true;
        for(int i=0;i<s.length();i++) {
            char word = s.charAt(i);
            if (word == ' ') check = true;


            if (check && word != ' ') {

                if (word >= 'a' && word <= 'z') {

                    word = Character.toUpperCase(word);

                }
                check = false;
            } else {
                word = Character.toLowerCase(word);
            }
            answer += word;
        }

        return answer;
    }

}
