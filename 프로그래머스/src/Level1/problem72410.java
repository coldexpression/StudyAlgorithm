package Level1;
import java.util.*;
import java.util.regex.Pattern;

public class problem72410 {

    public static void main(String[] args) {
        problem72410 problem72410 = new problem72410();
        String answer = problem72410.solution("=.=");
        System.out.println("정답 : " + answer);
    }

    public String solution(String new_id) {
        String answer = "";
        String[] split = new_id.split("");
        String str = "";
        String substring = "";
        int dot_count = 0;




        for (int i=0;i<split.length;i++) {


            if (Pattern.matches("^[A-Z]*$",split[i])) {
                split[i] = split[i].toLowerCase();
            }

            if (!Pattern.matches("^[a-z0-9-_.]*$", split[i])) {
                split[i] = "";
            }


        }

        for (int i=0;i<split.length;i++) {
            if (!split[i].equals("")) {
                str += split[i];
            }
        }


        String[] split2 = str.split("");
        str = "";

        for(int i=0;i<split2.length;i++) {
            if (dot_count > 0 && split2[i].equals(".") && split2[i-1].equals(".")) {
                split2[i-1] = "";
                dot_count = 0;
            }

            if (split2[i].equals(".")) {
                dot_count++;
            }
        }

        for (int i=0;i<split2.length;i++) {
            if (!split2[i].equals("")) {
                str += split2[i];
            }
        }

        System.out.println("str >> " + str);


        if (str.indexOf(".") == 0 && str.length() > 1) {
            str = str.substring(1, str.length());
        }

        if (str.lastIndexOf(".") == str.length()-1) {
            str = str.substring(0, str.length()-1);
        }

        if (str.indexOf(".") == 0 && str.length() == 1) {
            str = "";
        }

        System.out.println(str);



        if (str.length() == 0) {
            return "aaa";
        }

        if (str.length() >= 16) {
            str = str.substring(0, 15);
            if (str.lastIndexOf(".") == str.length() - 1) {
                str = str.substring(0,14);
            }
        }

        if(str.length() <= 2) {
            String last = str.substring(str.length()-1);
            while(str.length() < 3) {
                str = str.concat(last);
            }

            answer = str;
            return answer;
        }

        answer = str;

        return answer;
    }
}
