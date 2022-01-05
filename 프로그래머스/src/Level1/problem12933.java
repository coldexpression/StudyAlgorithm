package Level1;

import java.util.Arrays;

public class problem12933 {

    public static void main(String[] args) {

    }

    public long solution(long n) {
        long answer = 0;
        int count = 0;
        int num = 0;
        int powNum = String.valueOf(n).length() -1;
        int[] store = new int[String.valueOf(n).length()];
        while(powNum != -1) {
            num = (int)(n / Math.pow(10, powNum));
            store[count] = num;
            n = (int)(n % Math.pow(10, powNum));
            powNum--;
            count++;
        }
        Arrays.sort(store);

        for(int i=0;i<store.length;i++) {
            answer += store[i]*Math.pow(10, i);
        }
        return answer;
    }
}
