package summercoarding;

import java.util.HashSet;

public class p12 {

    public static void main(String[] args) {
        p12 p12 = new p12();
//        p12.solution("His comments came after Pyongyang announced it had a plan to fire four missiles near the US territory of Guam");
//        p12.solution("Jackdaws love my big sphinx of quartz");
        p12.solution("");
    }


    public String solution(String input) {
        String answer = "";
        HashSet<Character> set = new HashSet<>();

        input = input.trim();

        input = input.toLowerCase();

        for(char i = 'a';i<='z';i++) {
            set.add(i);
        }

        for(int i=0;i<input.length();i++) {
            set.remove(input.charAt(i));
        }

        for (Character character : set) {
            answer += character;
        }


        answer = answer.length() == 0 ? "perfect" : answer;
        System.out.println(answer);

        return answer;
    }
}
