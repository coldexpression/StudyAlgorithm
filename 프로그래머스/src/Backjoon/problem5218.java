package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem5218 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(st.nextToken());
        for(int i=0;i<t;i++) {
            sb.append("Distances: ");
            st = new StringTokenizer(bf.readLine());
            String input1 = st.nextToken();
            String input2 = st.nextToken();
            int[] arr = new int[input1.length()];
            int[] brr = new int[input1.length()];
            for(int j=0;j<arr.length;j++) {
                arr[j] = (int)(input1.charAt(j) - 64);
                brr[j] = (int)(input2.charAt(j) - 64);
                if (arr[j] <= brr[j]) sb.append(brr[j] - arr[j]).append(" ");
                else sb.append(brr[j]+26 - arr[j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
