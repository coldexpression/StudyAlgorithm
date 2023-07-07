package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class problem16965 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int[] parents = new int[n];
        List<int[]> list = new ArrayList<>();

        for(int i=0;i<n;i++) parents[i] = i;

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(bf.readLine());
            int q = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if (q == 1) {
                s += 1;
                e -= 1;
                list.add(new int[]{s, e});
                if (i == 0) continue;

                for(int j=0;j<i;j++) {
                    if (j >= list.size()) break;
                    int[] info = list.get(j);
                    int ps = info[0]; int pe = info[1];

                    if ((ps < s && s < pe || (ps < e && e < pe)) || ((s < ps && ps < e) || (s < pe && pe < e))) {
                        union(parents, i, j);
                    }
//                    if ((s <= ps && pe <= e) || (s <= ps && ps <= e) || (ps <= s && pe > s && pe <= e) || (ps <= s && e <= pe)) {
//                        union(parents, i, j);
//                    }
                }
            } else {
                sb.append(findParent(parents, s-1) == findParent(parents, e-1) ? 1 : 0);
                sb.append("\n");
            }
        }
        if (n <= 2) {
            sb.setLength(0);
            sb.append(0);
        }
        System.out.println(sb);
    }

    public static void union(int[] parents, int a, int b) {
        int rootA = findParent(parents, a);
        int rootB = findParent(parents, b);

        if (rootA == rootB) return;

        parents[rootB] = rootA;
    }

    public static int findParent(int[] parents, int a) {
        if (parents[a] == a) return a;

        return parents[a] = findParent(parents, parents[a]);
    }

}
