package Backjoon;

import java.io.BufferedReader;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author Chansik Seo
 */
public class problem21567 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger a = sc.nextBigInteger();
        BigInteger b = sc.nextBigInteger();
        BigInteger c = sc.nextBigInteger();
        int[] arr = new int[10];
        BigInteger sum = a.multiply(b.multiply(c));
        String input = sum.toString();
        for (char word : input.toCharArray()) {
            arr[Character.getNumericValue(word)]++;
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
