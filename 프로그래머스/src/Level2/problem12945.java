package Level2;
import java.util.*;

public class problem12945 {

    HashMap<Integer, Integer> store = new HashMap<>();

    public static void main(String[] args) {
        problem12945 problem12945 = new problem12945();
        problem12945.solution(5);
    }

    public int solution(int n) {
        int answer = 0;
        int fibNum = 0;
        store.put(0, 0);
        store.put(1, 1);
        for(int i=2;i<=n;i++) {
            fibNum = (store.get(i-1)  + store.get(i-2)) % 1234567;
            store.put(i, fibNum);
        }
        answer = store.get(n);
        return answer;
    }
}
