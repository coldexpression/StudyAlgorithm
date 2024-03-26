package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * @author Chansik Seo
 */
public class problem10822 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int sum = 0;
        List<Integer> list = Arrays.stream(st.nextToken().split(","))
                                   .map(Integer::parseInt)
            .collect(Collectors.toList());
        for (Integer i : list)sum = sum + i;
        System.out.println(sum);
    }
}
