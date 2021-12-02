package Level1;

public class problem67256 {
    public static void main(String[] args) {
        problem67256 problem67256 = new problem67256();
        String a = problem67256.solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right");
        System.out.println(a);
    }

    public String solution(int[] numbers, String hand) {
        String answer = "";
        int left_x = 3;
        int left_y = 0;
        int right_x = 3;
        int right_y = 2;
        int right_distance = 0;
        int left_distance = 0;
        int x =0;
        int y =0;
        for(int n: numbers) {
            if (n>= 7) {
                x = 2;
                y = n - 7;
            } else if (n >= 4) {
                x = 1;
                y = n - 4;
            } else if (n >= 1) {
                x = 0;
                y = n - 1;
            } else if (n == 0) {
                x = 3;
                y = 1;
            }
            // [1,0] [2,1]
            // 1-1 // 4-3 // 7-5
            if (n == 1 || n == 4 || n == 7) {
                answer = answer.concat("L");
                if (n == 1) {
                    left_x = 0;
                } else if (n== 4) {
                    left_x = 1;
                } else{
                    left_x = 2;
                }
                left_y = 0;
            } else if (n == 3 || n == 6 || n == 9) {
                answer = answer.concat("R");
                if (n == 3) {
                    right_x = 0;
                } else if (n == 6) {
                    right_x = 1;
                } else {
                    right_x = 2;
                }
                right_y = 2;
            } else {
                left_distance = Math.abs((left_x - x)) + Math.abs((left_y - y));
                right_distance = Math.abs((right_x - x)) + Math.abs((right_y - y));

                if (left_distance - right_distance > 0) {
                    answer = answer.concat("R");
                    right_x = x;
                    right_y = y;
                } else if (left_distance - right_distance < 0) {
                    answer = answer.concat("L");
                    left_x = x;
                    left_y = y;
                } else {
                    if (hand.equals("left")) {
                        answer = answer.concat("L");
                        left_x = x;
                        left_y = y;
                    } else if (hand.equals("right")){
                        answer = answer.concat("R");
                        right_x = x;
                        right_y = y;
                    }
                }
            }

        }
        return answer;
    }
}
