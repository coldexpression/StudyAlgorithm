package Backjoon;

import java.util.*;

public class problem9251 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        char[] word1 = str1.toCharArray();
        char[] word2 = str2.toCharArray();

        int[][] lcs = new int[str2.length()+1][str1.length()+1];

        for (int i = 0; i < word1.length; i++) {
            for (int j = 0; j < word2.length; j++) {
                if (word2[j] == word1[i]) {
                    lcs[j+1][i+1] = lcs[j][i] + 1;
                } else {
                    lcs[j+1][i+1] = Math.max(lcs[j][i+1], lcs[j+1][i]);
                }
            }
        }
        System.out.println(lcs[word2.length][word1.length]);
    }
}
