package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Chansik Seo
 */
public class problem14910 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        boolean check = false;
        int size = st.countTokens();
        int[] arr = new int[size];
        int[] brr = new int[size];
        for(int i=0;i<size;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            brr[i] = arr[i];
        }
        Arrays.sort(brr);
        for(int i=0;i<size;i++) {
            if (arr[i] != brr[i]) {
                check = true;
                break;
            }
        }
        System.out.println(check ? "Bad" : "Good");
    }
}
