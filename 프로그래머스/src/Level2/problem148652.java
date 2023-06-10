package Level2;

public class problem148652 {
    public static void main(String[] args) {
        problem148652 problem148652 = new problem148652();
        int result = problem148652.solution(1, 1, 2);
        System.out.println(result);
    }

    public int solution(int n, long l, long r) {
        // 1,1,0,1,1 => [0,1,2,3,4]
        // 4,4,0,4,4 => [0~4 (2), 5~9, 10~14, 15~19, 20~24]
        // 16,16,0,16,16 => [0~24 (2,7,10,11,12,13,14, 17, 22), 25~49, 50~74, 75~99, 100~124]
        // 64,64,0,64,64 => [0~124]
        // [ 0 ~ r 까지의 1의 개수 - 0 ~ l-1 까지의 1의 개수] => 정답
        int answer = 0;
        long[][] nums = new long[n+1][5];
        long[][] sums = new long[n+1][5];
        for(int i=0;i<5;i++) nums[1][i] = i;
        for(int i=0;i<5;i++) sums[1][i] = i == 2 ? 0 : 1;
        for(int i=2;i<=n;i++) {
            for(int j=0;j<5;j++) {
                nums[i][j] = ((long)Math.pow(5, i-1) *(j+1)) - 1;
                sums[i][j] = j == 2 ? 0 : (long)Math.pow(4, i-1);
            }
        }
        l = l - 2;
        r = r - 1;
        // 0 ~ r 까지의 1의 개수 구하기
        int frontN = n;
        int rearN = n;
        long frontSum = 0;
        long rearSum = 0;
        boolean check = false;
        while(true) {
            if (frontN == 0) break;
            for(int i=0;i<5;i++) {
                if (nums[frontN][i] > r) {
                    if (i == 2) {
                        check = true;
                        break;
                    }
                    if (i != 0) r -= nums[frontN][i-1] + 1;
                    frontN--;
                    break;
                }

                frontSum += sums[frontN][i];
                if (i == 4) check = true;
            }
            if (check) break;
        }


        check = false;
        while(true) {
            if (rearN == 0 || l < 0) break;
            for(int i=0;i<5;i++) {
                if (nums[rearN][i] > l) {
                    if (i == 2) {
                        check = true;
                        break;
                    }
                    if (i != 0) l -= nums[rearN][i-1] + 1;
                    rearN--;
                    break;
                }

                rearSum += sums[rearN][i];
                if (i == 4) check = true;
            }
            if (check) break;
        }

        answer = (int)(frontSum - rearSum);
        return answer;
    }
}
