package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem4659 {
    public static int type(char c) {
        switch (c) {
            case'a': case'e': case'i': case'o': case'u' : return 1;
            default: return -1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;
        boolean check = false;

        while(true) {
            input = bf.readLine();
            check = false;

            if (input.equals("end")) break;
            sb.append("<").append(input).append(">").append(" is ");
            if (input.indexOf('a') == -1 && input.indexOf('e') == -1 && input.indexOf('i') == -1 && input.indexOf('o') == -1 && input.indexOf('u') == -1) {
                sb.append("not acceptable.").append("\n");
                continue;
            }

            int chk = 0;
            for (int i = 0; i < input.length(); i++) {
                int type = type(input.charAt(i));
                if (type > 0 && chk > 0) chk++;
                else if (type < 0 && chk < 0) chk--;
                else chk = type;
                if (Math.abs(chk) == 3) check = true;
            }

            if (check) {
                sb.append("not acceptable.").append("\n");
                continue;
            }


            for(char word='a';word<='z';word++) {
                if (word == 'e' || word == 'o') continue;
                String words = String.valueOf(word);
                words = words.concat(words);

                if (input.contains(words)) {
                    check = true;
                    break;
                }
            }

            if(check) {
                sb.append("not acceptable.").append("\n");
                continue;
            }

            sb.append("acceptable.").append("\n");
        }
        System.out.println(sb);
    }
}
