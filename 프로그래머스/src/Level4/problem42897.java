package Level4;

public class problem42897 {

    public static void main(String[] args) {
        problem42897 problem42897 = new problem42897();
        problem42897.solution(new int[]{0,0,2,1,0,0,1});
    }

    public int solution(int[] money) {
        int answer = 0;
        int[] dp1 = new int[money.length];
        int[] dp2 = new int[money.length];

        if (money.length == 3) {
            return Math.max(money[0], Math.max(money[1], money[2]));
        }

        dp1[0] = 0;
        dp2[0] = 0;
        System.out.print(dp1[0] + " ");
        for(int i=1;i<money.length;i++) {
            dp1[i] = money[i-1];
            System.out.print(dp1[i] + " ");
        }

        System.out.println("********************");

        System.out.print(dp2[0] + " ");
        for(int i=0;i<money.length-1;i++) {
            dp2[i+1] = money[i+1];
            System.out.print(dp2[i+1] + " ");
        }

        System.out.println("===============================");

        for(int i=2;i<money.length;i++) {
            dp1[i] = Math.max(dp1[i-2] + dp1[i], dp1[i-1]);
            dp2[i] = Math.max(dp2[i-2] + dp2[i], dp2[i-1]);
            System.out.println("dp1["+i+"] = "+dp1[i]);
            System.out.println("dp2["+i+"] = "+dp2[i]);
        }

        answer = Math.max(dp1[money.length-1], dp2[money.length-1]);

        return answer;
    }
}
