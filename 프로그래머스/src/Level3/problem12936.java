package Level3;

import java.util.*;

public class problem12936 {
    public static void main(String[] args) {
        problem12936 problem12936 = new problem12936();
        problem12936.solution(5, 10);
    }

    public long[] solution(int n, long k) {
        List<Integer> list = new ArrayList<>();
        List<Integer> dp = new ArrayList<>();
        int totalNum = n;
        int index = 0;
        long[] answer = new long[n];

        for (int i = 1; i <= n; i++) list.add(i);

        dp.add(0);
        dp.add(1);
        dp.add(2);

        for (int i = 3; i <= n; i++) dp.add(i * dp.get(i - 1));

        System.out.println(dp);
        System.out.println(list);


        while (index != totalNum) {
            int divNum = dp.get(n) / n;
            int mok = (int) (k / divNum);
            int rest = (int) (k % divNum);
            k = rest;

            System.out.println("divNum : " + divNum);
            System.out.println("mok : " + mok);
            System.out.println("rest : " + rest);

            if (rest == 0) {
                mok = mok - 1;
                answer[index++] = list.get(mok);
                list.remove(mok);
                while (list.size() != 0) {
                    answer[index++] = list.get(list.size() - 1);
                    list.remove(list.size() - 1);
                }
                break;
            } else if (rest == 1) {
                answer[index++] = list.get(mok);
                list.remove(mok);
                while (list.size() != 0) {
                    answer[index++] = list.get(0);
                    list.remove(0);
                }
                break;
            } else {
                answer[index++] = list.get(mok);
                list.remove(mok);
            }
            n--;
        }


        for (long l : answer) {
            System.out.print(l + " ");
        }
        return answer;
    }

}
