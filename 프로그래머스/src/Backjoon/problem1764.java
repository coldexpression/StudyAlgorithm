package Backjoon;

import java.util.*;

public class problem1764 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        HashSet<String> set = new HashSet<>();

        List<String> list = new ArrayList<>();

        for(int i=0;i<N;i++) set.add(sc.next());

        for(int i=0;i<M;i++) {
            String name = sc.next();
            if (set.contains(name)) list.add(name);
        }

        System.out.println(list.size());

        Collections.sort(list);

        list.forEach(ele -> System.out.println(ele));
    }
}
