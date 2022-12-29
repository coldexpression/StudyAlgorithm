package Backjoon;

import java.util.*;

public class problem10815 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<Integer> hasNum = new HashSet<>();

        int N = sc.nextInt();

        for(int i=0;i<N;i++) hasNum.add(sc.nextInt());

        int M = sc.nextInt();

        int[] check = new int[M];

        for(int i=0;i<M;i++) {
            int ele = sc.nextInt();

            if (hasNum.contains(ele)) check[i] = 1;
        }

        Arrays.stream(check).forEach(ele -> System.out.print(ele + " "));
    }
}
