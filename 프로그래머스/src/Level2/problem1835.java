package Level2;

import java.util.ArrayList;
import java.util.List;

public class problem1835 {

    static String[] photoZone = {"0","0","0","0","0","0","0","0"};
    static String[] people = {"A","C","F","J","M","N","R","T"};
    static int count = 0;
    static int answer = 0;

    public static void main(String[] args) {
        problem1835 problem1835 = new problem1835();
        problem1835.solution(2, new String[]{"N~F=0","R~T>2"});
    }

    public void solution(int n, String[] data) {
        count = 0;
        answer = 0;
        dfs(0,n,data);
        System.out.println(answer);
    }

    static void dfs(int index, int n, String[] data) {
        if (count == 8) {
            boolean[] check = new boolean[n];
            int checkNum = 0;
            for (int i=0;i<n;i++) {
                checkNum = 0;
                if(!validation(data[i])) break;
                checkNum = 1;
            }

            answer = checkNum == 1 ? answer + 1 : answer;
        } else {
            for(int i=0;i<8;i++) {
                if (findIndex(i) == -1) {
                    photoZone[index] =  people[i];
                    dfs(index + 1, n, data);
                    photoZone[index] = "0";
                    count--;
                }
            }
        }
    }

    static int findIndex(int index) {
        for(int i=0; i<people.length;i++) {
            if (photoZone[i] == people[index]) return index;
        }
        count++;
        return -1;
    }

    static boolean validation(String data) {
        String temp = "";
        for(String word: photoZone) temp += word;


        char s1 = data.charAt(0);
        char s2 = data.charAt(2);
        char exp = data.charAt(3);
        int num = Integer.parseInt(String.valueOf(data.charAt(4)));
        int distance = temp.indexOf(s1) - temp.indexOf(s2);

        distance = distance > 0 ? distance : distance * (-1);

        switch (exp) {
            case '=' : {
                if (distance == (num+1)) {
                    return true;
                }
                break;
            }
            case '>' : {
                if (distance > (num+1)) {
                    return true;
                }
                break;
            }
            case '<' : {
                if (distance < (num+1)) {
                    return true;
                }
                break;
            }
        }
        return false;

    }
}
