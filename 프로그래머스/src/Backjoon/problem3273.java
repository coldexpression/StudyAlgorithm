package Backjoon;

import java.util.*;

public class problem3273 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        int front = 0;
        int rear = a.length-1;
        for(int i=0;i<n;i++) {
            a[i] = sc.nextInt();
        }

        int x = sc.nextInt();
        int count = 0;

        Arrays.sort(a);

        while(true) {
            if (front >= rear) break;
            if (a[front] + a[rear] > x) {
                rear--;
            } else if (a[front] + a[rear] < x) {
                front++;
            } else {
                rear--;
                front++;
                count++;
            }
        }

        System.out.println(count);
    }
}
