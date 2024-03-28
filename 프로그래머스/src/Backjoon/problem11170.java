package Backjoon;

import java.io.*;
import java.util.*;
class problem11170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            int cnt = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            for(int j=start; j<=end; j++){
                for(int k=0; k<String.valueOf(j).length(); k++){
                    if(String.valueOf(j).charAt(k) == '0') cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}
