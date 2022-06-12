package Backjoon;

import java.util.*;

public class problem1920 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] origin = new int[n];

        for(int i=0;i<n;i++) {
            int input = sc.nextInt();
            origin[i] = input;
        }
        Arrays.sort(origin);

        int m = sc.nextInt();
        int[] map = new int[m];
        for(int i=0;i<m;i++) {
            int input = sc.nextInt();
            map[i] = input;
        }

        for(int i=0;i<m;i++) {
            int pick = map[i];
            int start = 0;
            int end = n-1;
            int middle = (start+end) / 2;
            int check = 0;

            while(true) {
                if (start > end || pick > origin[end]) break;
                if (pick == origin[start] || pick == origin[end]) {
                    check = 1;
                    break;
                }

                if (pick > origin[middle]) {
                    start = middle + 1;
                } else if (pick < origin[middle]){
                    end = middle - 1;
                } else {
                    check = 1;
                    break;
                }
                middle = (start+end) / 2;
//                System.out.println(middle);
            }
            System.out.println(check);
        }
    }
}
