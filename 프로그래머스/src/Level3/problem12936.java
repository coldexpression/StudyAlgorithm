package Level3;

import java.util.*;

public class problem12936 {

    static boolean[] visited;
    static List<int[]> store;
    static long endIndex;
    static long startIndex;
    static long[] answer;
    public static void main(String[] args) {
        problem12936 problem12936 = new problem12936();
        problem12936.solution(3, 3);
    }

    public long[] solution(int n, long k) {
        List<Long> list = new ArrayList<>();
        List<Long> dp = new ArrayList<>();
        int totalNum = n;
        int middleNum = 0;
        long count = 0;
        answer = new long[n];
        visited = new boolean[n];
        store = new ArrayList<>();
        int start = 0;
        Arrays.fill(visited, false);

        dp.add(0L);
        dp.add(1L);
        dp.add(2L);

        for(int i=3;i<=n;i++) {
            dp.add(i*dp.get(i-1));
        }
        for(int i=totalNum-1;i>0;i--) totalNum *= i;
        middleNum = (totalNum / n);
        k = k - 1;
        endIndex = k;

        for(int i=middleNum;i<=totalNum;i=i+middleNum) {
            count++;
            if (i-middleNum <= k && i-1 >= k) {
                startIndex = i-middleNum;
                start = i - middleNum;
                break;
            }
        }

        list.add(count);



        dfs(1, n ,list);

        for (long l : answer) {
            System.out.print(l + " ");
        }
        return answer;
    }

    private void dfs(int start, long end, List<Long> tempList) {
        if (startIndex > endIndex) return;

        if (start == end) {
            answer = tempList.stream().mapToLong(i -> i).toArray();
            startIndex++;
            return;
        }

        if (!visited[start]) {
            List<Long> list = new ArrayList<>(tempList);
            visited[start]  = true;
            for (long i = 1; i <= end; i++) {
                if (!list.contains(i)) {
                    list.add(i);
                    System.out.println("전 list >> " + list);
                    dfs(start + 1, end,list);
                    list = new ArrayList<>(tempList);
                    System.out.println("후 list >> " + list);
                }
            }
            visited[start] = false;
        }
    }
}
