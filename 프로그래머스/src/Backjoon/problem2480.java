package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem2480 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String word = bf.readLine();
        int[] arr = new int[3];
        int idx = 0;
        for(String input: word.split(" ")) {
            arr[idx++] = Integer.parseInt(input);
        }

        if (arr[0] == arr[1] && arr[1] == arr[2]) {
            System.out.println(10000 + (arr[0])*1000);
        } else if (arr[0] != arr[1] && arr[1] != arr[2] && arr[0] != arr[2]) {
            System.out.println(Math.max(arr[0],Math.max(arr[1], arr[2])) * 100);
        } else {
            if (arr[0] == arr[1]) {
                System.out.println(1000+(arr[0]*100));
            } else if (arr[1] == arr[2]) {
                System.out.println(1000+(arr[1]*100));
            } else {
                System.out.println(1000+(arr[2]*100));
            }
        }
    }
}
