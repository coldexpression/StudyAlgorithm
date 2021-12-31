package Level1;

import java.util.regex.Pattern;

public class problem17682 {

    public static void main(String[] args) {
        problem17682 problem17682 = new problem17682();
        String str = "1D2S3T*";
        problem17682.solution(str);

    }

    public int solution(String dartResult) {
        int answer = 0;
        int num = 0;
        int count = 0;
        int expCount = 0;
        int[] scoreStore = new int[3];
        String[] splitDart = dartResult.split("");
        for(String word : splitDart) {

            if (Pattern.matches("^[0-9]*$", word)) {
                if (num == 1 && Integer.parseInt(word) == 0) {
                    num = 10;
                } else {
                    num = Integer.parseInt(word);
                }
            }

            if (Pattern.matches("^[A-Z]*$", word)) {
                System.out.println("제곱 전 num : " + num);
                switch (word) {
                    case "S" :  num = (int)Math.pow(num, 1); break;
                    case "D" :  num = (int)Math.pow(num, 2); break;
                    case "T" :  num = (int)Math.pow(num, 3); break;
                    default: num = num;
                }
                System.out.println("제곱 후 num : " + num);
                scoreStore[count] = num;
                count++;
            }

            expCount = count - 1;
            if (expCount == 0) {
                if (word.equals("*")) {
                    scoreStore[expCount] = scoreStore[expCount] * 2;
                } else if (word.equals("#")) {
                    scoreStore[expCount] = scoreStore[expCount] * (-1);
                }
            } else if (expCount > 0) {
                if (word.equals("*")) {
                    scoreStore[expCount] = scoreStore[expCount] * 2;
                    scoreStore[expCount - 1] = scoreStore[expCount - 1] * 2;
                } else if (word.equals("#") ) {
                    scoreStore[expCount] = scoreStore[expCount] * (-1);
                }
            }


            System.out.println("word : " + word);

        }

        answer = scoreStore[0] + scoreStore[1] + scoreStore[2];
        System.out.println(answer);

        return answer;
    }
}
