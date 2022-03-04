package Level2;

import java.util.*;

public class problem17686 {

    public static void main(String[] args) {
        problem17686 problem17686 = new problem17686();
//        problem17686.solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"});
        problem17686.solution(new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"});
    }

    public String[] solution(String[] files) {
        String[] answer = {};

        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int result = 0;

                String head1 = o1.split("[0-9]")[0];
                String head2 = o2.split("[0-9]")[0];

                result = head1.toLowerCase().compareTo(head2.toLowerCase());


                if(result == 0) {
                    result = pickNum(o1, head1) - pickNum(o2, head2);
                }
                return result;
            }

        });

        answer = files;

        return answer;
    }

    private int pickNum(String context, String head) {
        String num = "";
        String board = context.substring(head.length());
        for(char c: board.toCharArray()) {
            if (Character.isDigit(c) && num.length() < 5) num += c;
            else break;
        }

        return Integer.parseInt(num);
    }



}
