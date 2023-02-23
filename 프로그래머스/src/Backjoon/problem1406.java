package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem1406 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        List<Character> list = new LinkedList<>();


        String word = st.nextToken();
        for (int i = 0; i < word.length(); i++) list.add(word.charAt(i));

        st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());

        ListIterator<Character> iter = list.listIterator();

        while (iter.hasNext()) iter.next();


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            char command = st.nextToken().charAt(0);
            char input = 0;
            if (command == 'P') input = st.nextToken().charAt(0);

            if (command == 'P') {
                iter.add(input);
            } else if (command == 'L') {
                if (iter.hasPrevious()) iter.previous();
            } else if (command == 'D') {
                if (iter.hasNext()) iter.next();
            } else {
                if (iter.hasPrevious()) {
                    iter.previous();
                    if (iter.previousIndex() >= -1) iter.remove();
                }
            }
            System.out.println(list);
        }

        for (Character character : list) {
            sb.append(character);
        }

        System.out.println(sb);
    }
}
