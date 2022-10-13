package Level2;

import java.util.HashMap;

public class problem131127 {

    public static void main(String[] args) {
        problem131127 problem131127 = new problem131127();
        problem131127.solution(new String[]{"banana","apple","rice","pork","pot"}, new int[]{3,2,2,2,1}, new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"});
    }

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int idx = 0;
        int max = 0;
        int cnt = 0;
        HashMap<String, Integer> wantMap = new HashMap<>();
        HashMap<String, Integer> map = new HashMap<>();

        for (String s : want) {
            wantMap.put(s, number[idx++]);
        }

        for (int i : number) {
            max += i;
        }

        for(int i=0;i<max;i++) {
            String product = discount[i];
            map.put(product, map.getOrDefault(product, 0) + 1);
        }

        for(int i=0;i<discount.length;i++) {
            String pick = discount[i];
            System.out.println(i + "일 째");
            System.out.println("선택한 제품 : " + pick);
            System.out.println("map : " + map);
            System.out.println("wantMap : " + wantMap);
            cnt = 0;
            for (String product : wantMap.keySet()) {
                if (map.getOrDefault(product, 0) - wantMap.get(product) > 0) {
                    cnt++;
                }
            }
            if (cnt == number.length || max + i == discount.length) {
                answer = i+1;
                break;
            }

            String next = discount[max + i];
            map.put(pick, map.get(pick) - 1);
            map.put(next, map.getOrDefault(next, 0) + 1);
        }
        return answer;
    }
}
