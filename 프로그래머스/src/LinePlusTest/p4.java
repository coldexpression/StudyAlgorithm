package LinePlusTest;

import java.util.*;

public class p4 {

    static boolean[] visited;
    static int answer;

    public static void main(String[] args) {
        p4 p4 = new p4();
        p4.solution(new int[]{3, 7, 2, 4}, new int[]{4, 5, 5, 2});
    }

    public int solution(int[] arr, int[] brr) {
        answer = Integer.MAX_VALUE;
        visited = new boolean[arr.length];
        dfs(arr, brr, 0, Arrays.stream(arr).sum());
        System.out.println("정답 : " + answer);
        return answer;
    }

    private void dfs(int[] startArr, int[] endArr, int count, int sum) {
        if (Arrays.stream(startArr).sum() == sum && compareArray(startArr, endArr)) {
            answer = Math.min(count, answer);
            return;
        }

        for(int i=0;i<startArr.length-1;i++) {
            int[] arr = copy(startArr);
            int[] brr = copy(endArr);
            if (Arrays.stream(arr).sum() != sum) return;
            if (!visited[i]) {
                visited[i] = true;
                if(arr[i] < brr[i])  {
                    for(int j=1;j<=250;j++) {
                        boolean check = true;
                        int[] temp = copy(arr);
                        if (arr[i] + 1 <= 250 && arr[i+1] - 1 > 0) {
                            arr[i] += 1;
                            arr[i+1] -= 1;
                            check = true;
                        } else check = false;
//                        for(int k=0;k<arr.length;k++) {
//                            if(i != k && arr[i] <= 250 && arr[k] - j > 0) {
//                                arr[k] -= j;
//                            } else if(i != k && arr[i] > 250 && arr[k] - j < 0) {
//                                check = false;
//                                break;
//                            }
//                        }
                        if (check) dfs(arr, endArr, count + 1, sum);
                        else {
                            arr = copy(temp);
                            break;
                        }
                    }
                } else if (arr[i] > brr[i]) {
                    System.out.println(arr[i]);
                    System.out.println(brr[i]);
                    for(int j=1;j<=250;j++) {
                        boolean check = true;
                        int[] temp = copy(arr);
                        if (arr[i] - 1 > 0 && arr[i+1] + 1 <= 250) {
                            arr[i] -= 1;
                            arr[i+1] += 1;
                            check = true;
                        } else check = false;
//                        for(int k=0;k<arr.length;k++) {
//                            if(i != k && arr[i] > 0 && arr[k] + j <= 250) {
//                                arr[k] += j;
//                            } else if(i != k && arr[i] <= 0 && arr[k] + j > 250) {
//                                check = false;
//                                break;
//                            }
//                        }
                        if (check) dfs(arr, endArr, count + 1, sum);
                        else {
                            arr = copy(temp);
                            break;
                        }
                    }
                }
                visited[i] = false;
            }
        }
    }

    private int[] copy(int[] arr) {
        int[] newArr = new int[arr.length];
        for(int i=0;i<arr.length;i++) newArr[i] = arr[i];
        return newArr;
    }

    private boolean compareArray(int[] arr, int[] brr) {
        boolean check = true;
        System.out.println();
        System.out.println("A");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("B");
        for (int i : brr) {
            System.out.print(i + " ");
        }
        for(int i=0;i<arr.length;i++) {
            if (arr[i] != brr[i]) {
                check = false;
                break;
            }
        }
        return check;
    }
}
