package Level1;

import java.util.HashMap;
import java.util.Map;

public class problem12977 {
    public static void main(String[] args) {
        problem12977 problem12977 = new problem12977();
        int result = problem12977.solution(new int[]{1, 2, 3,4});
    }

    public int solution(int[] nums) {
        int answer = 0;
        int pri_num = 0;
        boolean check = false;
        if (nums.length >= 3 && nums.length <=50) {
            for (int i = 0; i < nums.length - 2; i++) {
                for (int j = i + 1; j < nums.length - 1; j++) {
                    for (int k = j + 1; k < nums.length; k++) {
                        pri_num = nums[i] + nums[j] + nums[k];
//                        System.out.println(nums[i] + "+" + nums[j] + "+" + nums[k] + "= " + pri_num);
                        for (int h=2;h<=pri_num/2;h++) {
                            check = false;
                            System.out.println(pri_num + " % " + h + " = " + pri_num % h);
                            if (pri_num % h == 0) {
                                check = true;
                                break;
                            }
                        }
                        answer = check ? answer : answer +1;
                    }
                }
            }
        }
        System.out.println(answer);
        return answer;
    }
}
