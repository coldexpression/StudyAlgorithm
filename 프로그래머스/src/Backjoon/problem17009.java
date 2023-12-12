package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem17009 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int aSum = 0;
        int bSum = 0;
        int aMul = 3;
        int bMul = 3;
        for(int i=0;i<6;i++) {
            if (i < 3) aSum += Integer.parseInt(bf.readLine()) * aMul--;
            else bSum += Integer.parseInt(bf.readLine()) * bMul--;
        }
        System.out.println(aSum == bSum ? "T" : aSum > bSum ? "A" : "B");
    }
}
