package Backjoon;

import java.util.*;

public class problem12015 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int bLength = 0;

        for(int i=0;i<n;i++) a[i] = sc.nextInt();

        b[0] = a[0];
        bLength++;

        for(int i=1;i<n;i++) {

            int pickNum = a[i];

            if(b[bLength-1] < pickNum) {
                bLength++;
                b[bLength-1] = pickNum;
            } else {
                int start = 0;
                int end = bLength;
                int middle = 0;

                while(start < end) {
                    middle = (start+end) / 2;

                    if (b[middle] < pickNum) {
                        start = middle + 1;
                    } else {
                        end = middle;
                    }
                }
                b[start] = pickNum;
            }
        }

        System.out.println(bLength);

    }
}
