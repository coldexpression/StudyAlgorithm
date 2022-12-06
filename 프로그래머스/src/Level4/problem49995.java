package Level4;

public class problem49995 {

    public static void main(String[] args) {
        problem49995 problem49995 = new problem49995();
        problem49995.solution(new int[]{1,250,1,250,500,500});
    }

    public int solution(int[] cookie) {
        int answer = -1;
        int[] sum = new int[cookie.length+1];

        sum[1] = cookie[0];
        for(int i=2;i<sum.length;i++) sum[i] = sum[i-1] + cookie[i-1];

        // [1,2,4,7]
        // [1, 3, 7, 12]

        int pivot = sum[cookie.length] / 2;
        System.out.println("pivot : " + pivot);

        int firstIdx = find(0,pivot, sum, sum.length-1);
        System.out.println("firstIdx : " + firstIdx);

        if (firstIdx == -1) return 0;

        int secondIdx = find(firstIdx, pivot, sum, sum.length-1);
        System.out.println("secondIdx : " + secondIdx);

        if (secondIdx == -1) return 0;

        System.out.println(pivot);

        return pivot;
    }

    public int find(int start, int pivot, int[] sum, int N) {
        int idx = start;
        for(int i=start+1;i<=N;i++) {
            System.out.println("현재 i : " + i);
            if (i == idx) {
                idx = 0;
                continue;
            }

            System.out.println("sum["+i+"] => " + sum[i]);
            System.out.println("[idx] => " + idx);
            System.out.println("minus => " + sum[idx]);

            int minus = sum[idx];
            if (sum[i] - minus > pivot) {
                System.out.println("idx >> " + idx);
                System.out.println("i >> " + i);
                idx++;
                i--;
            } else if (sum[i] - minus == pivot) {
                return i-1;
            } else {
                idx = 0;
            }
        }
        return -1;
    }
}
