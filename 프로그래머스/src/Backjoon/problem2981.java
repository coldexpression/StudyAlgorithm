package Backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class problem2981 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();

        int[] store = new int[N];

        for(int i=0;i<N;i++) store[i] = sc.nextInt();

        Arrays.sort(store);

        int min = Arrays.stream(store).min().getAsInt();

        min = min == 1 ? 2 : min;

        for(int i=2;i<min;i++) {
            int rest = store[0] % i;
            boolean check = true;
            for(int j=1;j<store.length;j++) {
                if (store[j] % i != rest) {
                    check = false;
                    break;
                }
            }

            if (check) {
                sb.append(i).append(" ");
                i = (i * 2) -1;
            }
        }

        System.out.println(sb.toString());
    }
}
