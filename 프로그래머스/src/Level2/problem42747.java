package Level2;

import java.util.*;

public class problem42747 {

    public static void main(String[] args) {

    }

    public int solution(int[] citations) {
        int answer = 0;

        Integer[] numtoInt = new Integer[citations.length];

        for(int i=0;i<citations.length;i++) numtoInt[i] = citations[i];
        Arrays.sort(numtoInt, Collections.reverseOrder());
        for(int i=0;i<citations.length;i++) citations[i] = numtoInt[i];

        for(int ele: citations) System.out.println(ele);

        for(int i=0;i<=citations[0];i++) {
            int upper = 0;
            int lower = 0;
            int h = 0;
            for(int j=citations.length-1;j>=0;j--) {
                h = i;
                if (citations[j] >= h) {
                    upper = j+1;
                    lower = citations.length-(j+1);
                    break;
                }
            }
            if (upper >= h && lower <= h) answer = h;
        }
        return answer;
    }
}
