package Backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class problem1541 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String exp = sc.nextLine();

        String[] exps = exp.split("-");
        int answer = 0;

        for(int i=0;i<exps.length;i++) {

            if (i==0) {
                if (exps[i].indexOf('+') == -1) {
                    answer = Integer.parseInt(exps[i]);
                } else {
                    int sum = 0;
                    String[] split = exps[i].split("\\+");
                    for(String sp:split) sum += Integer.parseInt(sp);

                    answer += sum;
                }
            } else {
                if (exps[i].indexOf('+') == -1) {
                    answer -= Integer.parseInt(exps[i]);
                } else {
                    int sum = 0;
                    String[] split = exps[i].split("\\+");
                    for(String sp:split) sum += Integer.parseInt(sp);

                    answer -= sum;
                }
            }
        }

        System.out.println(answer);

    }
}
