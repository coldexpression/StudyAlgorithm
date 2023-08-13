package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class problem10431 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int p = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<p;i++) {
            st = new StringTokenizer(bf.readLine());
            int testCase = Integer.parseInt(st.nextToken());
            int count = 0;
            sb.append(testCase).append(" ");
            List<Integer> list = new ArrayList<>();
            for(int j=0;j<20;j++) {
                int num = Integer.parseInt(st.nextToken());
                boolean check = false;
                for(int k=0;k<list.size();k++) {
                    if (list.get(k) > num) {
                        list.add(k, num);
                        check = true;
                        count += list.size() - k - 1;
                        break;
                    }
                }
                if (!check) list.add(num);
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }
}
