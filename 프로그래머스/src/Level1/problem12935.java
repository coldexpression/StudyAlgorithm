package Level1;

import java.util.Arrays;

public class problem12935 {

    public static void main(String[] args) {
        problem12935 problem12935 = new problem12935();
        problem12935.solution(new int[]{3, 3, 1, 1, 4, 2, 1});
    }

    public int[] solution(int[] arr) {
        int[] answer = {};
        int[] tempArr = arr.clone();
        int min = 0;
        int count = 0;
        boolean check = false;
        if (arr.length == 1) {
            answer = new int[1];
            answer[0] = -1;
        } else {
            answer = new int[arr.length - 1];
            Arrays.sort(tempArr);

            min = tempArr[0];
            while(count != arr.length) {
                if (arr[count] == min && !check) {
                    check = true;
                    count++;
                } else {
                    if (check) {
                        answer[count-1] = arr[count];
                    } else {
                        answer[count] = arr[count];
                    }
                    count++;
                }

            }
        }

        for (int i : answer) {
            System.out.println(i);
        }
        return answer;
    }
}
