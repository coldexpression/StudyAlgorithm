package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem2920 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] arr = new int[8];

        for(int i=0;i<8;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int first = arr[0];
        boolean check = true;

        if (first == 1) {
            for(int i=1;i<8;i++) {
                if (first + 1 != arr[i]) {
                    check = false;
                    break;
                }
                first = arr[i];
            }
            System.out.println(check ? "ascending" : "mixed");
        } else if (first == 8) {
            for(int i=1;i<8;i++) {
                if (first - 1 != arr[i]) {
                    check = false;
                    break;
                }
                first = arr[i];
            }
            System.out.println(check ? "descending" : "mixed");
        } else {
            System.out.println("mixed");
        }

    }
}
