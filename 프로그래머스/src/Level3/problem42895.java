package Level3;

import java.util.*;

public class problem42895 {

    static HashSet<Integer> scoreBox;

    public static void main(String[] args) {
        problem42895 problem42895 = new problem42895();
        problem42895.solution(1, 11);
    }

    public int solution(int N, int number) {
        int answer = 10;
        int count = 0;
        char[] ops = new char[]{'+','-','*','/'};
        HashMap<Integer, HashSet<Integer>> dp = new HashMap<>();
        List<Integer> nums = new ArrayList<>();
        HashSet<Integer> hashNums = new HashSet<>();


        // N 을 한번만 썼을 때,
        hashNums.add(N);
        dp.put(1, hashNums);

        if (N == number) return 1;

        for(int i=2;i<=8;i++) {
            int firstNum = firstCalc(i, N);
            hashNums = new HashSet<>();
            count = 0;
            System.out.println(" i>> " + i);
            hashNums.add(firstNum);
            count = firstNum == number ? count + 1 : count;
            for(int j=1;j<=i-1;j++) {
                HashSet<Integer> dp1 = dp.get(j);
                HashSet<Integer> dp2 = dp.get(i - j);
                int[] int_dp1 = dp1.stream().mapToInt(ele -> ele).toArray();
                int[] int_dp2 = dp2.stream().mapToInt(ele -> ele).toArray();
                for(int k=0;k<dp1.size();k++) {
                    int sum = 0;
                    for(int l=0;l<dp2.size();l++) {
                        for(int m=0;m<ops.length;m++) {
                            if (!(int_dp2[l] == 0 && ops[m] == '/')) {
                                sum = operation(int_dp1[k], int_dp2[l], ops[m]);
                                hashNums.add(sum);
                                count = sum == number ? count + 1 : count;
                            }
                        }
                    }
                }
            }
            dp.put(i, hashNums);
            if (count >= 1) answer = Math.min(i,answer);
        }
        answer = answer > 8 ? -1 : answer;
        System.out.println(answer);
//        System.out.println(dp);
        return answer;
    }

    private int firstCalc(int count, int N) {
        int sum = 0;
        for(int i=count;i>0;i--) {
            sum += Math.pow(10, (i-1))*N;
        }
        return sum;
    }

    private int operation(int n1, int n2, char op) {
        System.out.println("["+n1+"]"+op+"["+n2+"]");
        switch (op) {
            case '+' : return n1 + n2;
            case '-' : return n1 - n2;
            case '*' : return n1 * n2;
            case '/' : return n1 / n2;
        }
        return 0;
    }
}
