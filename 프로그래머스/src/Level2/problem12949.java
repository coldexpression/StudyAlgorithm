package Level2;

public class problem12949 {

    public static void main(String[] args) {

    }

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        int middleSum = 0;
        for(int i=0;i<arr1.length;i++) {
            for(int j=0;j<arr2[0].length;j++) {
                middleSum = 0;
                for(int k=0;k<arr1[0].length;k++) {
                    middleSum += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = middleSum;
            }
        }
        return answer;
    }
}
