package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class problem2613 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());

        int[] arr = new int[n];

        for(int i=0;i<n;i++) arr[i] = Integer.parseInt(st.nextToken());

        int right = Arrays.stream(arr).sum();
        int left = 1;
        int middle = 0;
        int count = m;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        int index = 0;
        List<int[]> list = new  ArrayList<int[]>();
        List<Integer> ansList = new ArrayList<Integer>();

        while(left <= right) {
            count = m;
            sum = 0;
            middle = (right + left) / 2;
            list = new ArrayList<int[]>();
            index = 0;

            for(int i=0;i<n;i++) {
                if (arr[i] > middle) {
                    count = -1;
                    break;
                }
                if (sum + arr[i] <= middle) {
                    sum += arr[i];
                    index++;
                } else {
                    list.add(new int[] {sum, index});
                    count--;
                    index = 1;
                    sum = arr[i];
                }
            }

            list.add(new int[] {sum ,index});

            if (sum <= middle) count--;

            if (count >= 0) {
                ans = Math.min(ans, middle);
                ansList.clear();
                if (count == 0) {
                    list.forEach(x -> ansList.add(x[1]));
                } else {
                    for(int i=0;i<list.size();i++) {
                        int[] info = list.get(i);
                        int comp = info[1];
                        if (info[0] <= middle && count > 0) {
                            List<Integer> indexList = new ArrayList<Integer>();
                            while(comp > 1) {
                                comp--;
                                count--;
                                indexList.add(1);
                                if (count <= 0) break;
                            }
                            indexList.add(0, comp);
                            ansList.addAll(indexList);
                        } else {
                            ansList.add(info[1]);
                        }
                    }
                }
                right = middle - 1;
            } else {
                left = middle + 1;
            }

        }
        sb.append(ans).append("\n");
        for(int ele: ansList) sb.append(ele).append(" ");

        System.out.println(sb);
    }
}