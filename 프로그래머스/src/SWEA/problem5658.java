package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem5658 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        for(int t=1;t<=T;t++) {
            st = new StringTokenizer(bf.readLine());
            HashSet<String> set = new HashSet<>();

            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int line = n / 4;
            ArrayDeque<Character> outDeque = new ArrayDeque<>();
            List<String> list = new ArrayList<>();

            String input = bf.readLine();

            for(int i=0;i<input.length();i++) outDeque.add(input.charAt(i));

            for(int i=0;i<line;i++) {
                String word = "";
                for(int j=0;j<n;j++) {
                    char w = outDeque.pollFirst();
                    if (j != 0 && j % line == 0) {
                        set.add(word);
                        word = String.valueOf(w);
                    } else {
                        word += w;
                    }
                    outDeque.addLast(w);
                }
                set.add(word);
                outDeque.addLast(outDeque.pollFirst());
            }

            list.addAll(set);
            Collections.sort(list, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o2.compareTo(o1);
                }
            });

            sb.append("#").append(t).append(" ").append(Integer.parseInt(list.get(k-1), 16)).append("\n");
        }
        System.out.println(sb);
    }
}
