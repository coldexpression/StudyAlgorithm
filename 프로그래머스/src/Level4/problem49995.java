package Level4;

public class problem49995 {

    public static void main(String[] args) {
        problem49995 problem49995 = new problem49995();
        problem49995.solution(new int[]{1,2,4,5});
    }

    public int solution(int[] cookie) {
        int answer = -1;
        int[] sum = new int[cookie.length];

        sum[0] = cookie[0];
        for(int i=1;i<sum.length;i++) sum[i] = sum[i-1] + cookie[i];

        int total = sum[sum.length-1];
        int ele = 0;
        int idx = -1;

        while(total - ele > 0) {
            int num = total - ele;
            int midIdx = idx;

            if (num % 2 == 0) {
                int ss = 0;
                boolean check = false;
                int tIdx = midIdx == -1 ? 0 : midIdx;
                int findIdx = 0;

                while(tIdx < sum.length) {
                    check = false;
                    ss = 0;
                    for (int i = tIdx; i < cookie.length; i++) {
                        ss += cookie[i];
                        if (ss == num / 2) {
                            check = true;
                            findIdx = i;
                            break;
                        } else if (ss > num / 2) {
                            break;
                        }
                    }
//                    System.out.println("tIdx >> " + tIdx);
                    if (check || tIdx == cookie.length-1) break;
                    tIdx++;
                }

                System.out.println("탈출?");

                if (check) {
                    int tSum = 0;
                    for(int i=findIdx + 1;i<cookie.length;i++) {
                        tSum += cookie[i];

                        if (tSum == num / 2) {
                            answer = num / 2;
                            System.out.println(answer);
                            return answer;
                        } else if (tSum > num / 2) {
                            break;
                        }
                    }
                }
                midIdx++;
                ele = sum[++idx];
            } else {
                ele = sum[++idx];
            }
        }
        return answer;
    }
}
