package Level2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class problem72411 {

//    static Map<Integer, String> tmpStore = new HashMap<>();
    static Map<String, Integer> tmpStore = new HashMap<>();
    static char[] table;
    static int count = 0;
    static int max = 2;

    public static void main(String[] args) {
        problem72411 problem72411 = new problem72411();
        problem72411.solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4});
    }

    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        String[] sortedOrders = {};
        List<String> wordStore = new ArrayList<>();
        int index = 0;
        int maxValue = 0;
        count = 0;
        max = 2;

        PriorityQueue<Character> queue = new PriorityQueue<>();
        for(String order: orders) {
            char[] word = order.toCharArray();
            System.out.println(order);
            for(char w: word) {
                if(!queue.contains(w)) {
                    queue.add(w);
                }
            }
        }

        sortedOrders = sorting(orders);


        System.out.println(queue);

        int length = queue.size();
        char[] store = new char[length];

        while(!queue.isEmpty()) {
            store[index] = queue.poll();
            index++;
        }


        for(int i=0;i<course.length;i++) {
            table = new char[course[i]];
            for(int j=0;j<course[i];j++) table[j] = '0';
            max = 2;
            dfs(0, 0, sortedOrders, store, course[i]);
//            maxIndex = -1;
//            for (int key : tmpStore.keySet()) {
//                System.out.println(key);
//                maxIndex = Math.max(key, maxIndex);
//            }

            Map<String, Integer> tmpStore2 = new HashMap<>();

            tmpStore2 = tmpStore.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

//            List<Map.Entry<String, Integer>> storeValue = new LinkedList<>(tmpStore.entrySet());
//            storeValue.sort(Map.Entry.comparingByValue());

            maxValue = -1;

            System.out.println("정렬");
            for(String key : tmpStore2.keySet()) {
                System.out.println("key : " + key);
                System.out.println("value : " + tmpStore2.get(key));
            }
            System.out.println("종료");

//            System.out.println("정렬");
//            for(Map.Entry<String, Integer> sortedMap : storeValue) {
//                System.out.println("key : " + sortedMap.getKey());
//                System.out.println("value : " + sortedMap.getValue());
//            }
//            System.out.println("종료");

            for(String key: tmpStore2.keySet()) {
                if (tmpStore2.get(key) >= maxValue) {
                    maxValue = tmpStore2.get(key);
                    wordStore.add(key);
                }
            }

            tmpStore.clear();
            tmpStore2.clear();




//            System.out.println("벨류");
//            for (String value : tmpStore.values()) {
//                System.out.println(value);
//            }
//
//
//
//            if (!tmpStore.isEmpty()) {
//                String[] splits = tmpStore.get(max).split(" ");
//                for (String split : splits) {
//                    wordStore.add(split);
//                }
//                tmpStore.clear();
//            }
        }

        System.out.println("정답");


        answer = new String[wordStore.size()];
        for(int i=0;i<answer.length;i++) answer[i] = wordStore.get(i);


        Arrays.sort(answer);

        for (String s : answer) {
            System.out.println(s);
        }

        return answer;
    }

    // * 2022-01-15
    // 한턴이 도는 동안 courseNum을 만족하는 문자배열이 있다면 그것을 리스트에 넣어두고 다음턴부터 비교하여 중복되는것을 방지 [예) AC - CA 와 같은 것들]

    // * 2022-01-17
    // 두 번째 아이디어, orders 들을 Map<Integer, char[]> 형태로 해보기
    // 세 번째 아이디어, Map<String, Integer> 형태로 해보기
    // 즉, String 은 조합 Integer 는 orders 에 있는 조합의 수

    static void dfs(int n, int start, String[] orders, char[] store, int courseNum) {
        if (courseNum == count) {
            PriorityQueue<Character> splitWordStore = new PriorityQueue<>();
            String mergeWord = "";

            for(int i=0;i<table.length;i++) splitWordStore.add(table[i]);
//            mergeWord = new String(splitWordStore.toString());
            while(!splitWordStore.isEmpty()) mergeWord += splitWordStore.poll();
            System.out.println("mergeWord : " + mergeWord);
            if (!tmpStore.containsKey(mergeWord)) {
                int orderNum = validation(orders, courseNum);
                if (orderNum >= max) {
                    max = orderNum;
//                char[] tmpTable = new char[table.length];
//                for(int i=0;i< tmpTable.length;i++) tmpTable[i] = table[i];
//
//                Arrays.sort(tmpTable);


                    if (tmpStore.get(mergeWord) == null) {
                        tmpStore.put(mergeWord, orderNum);
                    }

//                max = orderNum;
//                resultList.add(String.valueOf(table));
//                // 2022-01-17 Map <Integer, char> => <String, Integer> 전환
//                if (tmpStore.get(orderNum) == null) {
//                    tmpStore.put(orderNum, String.valueOf(mergeWord));
//                } else {
//                    if (!tmpStore.get(orderNum).contains(String.valueOf(mergeWord))) {
//                        tmpStore.put(orderNum, tmpStore.get(orderNum).concat(" " + String.valueOf(mergeWord)));
//                    }
//                }


                }
            }
        } else {
            for(int i=start;i<store.length;i++) {
                if (searchIndex(store[i]) == -1) {
                    table[n] = store[i];
                    count++;
                    dfs(n+1, i+1, orders, store, courseNum);
                    table[n] = '0';
                    count--;
                }
            }
        }
    }

    static int searchIndex(char word) {
        for (int i=0;i<table.length;i++) {
            if (table[i] == word) return i;
        }
        return -1;
    }

    static int validation(String[] orders, int courseNum) {
        PriorityQueue<Character> store = new PriorityQueue<>();
        String mergeWord = "";
        int valiCount = 0;
        int checkNum = 0;
        int tmpCnt = 0;
//        for(char word: table) {
//            store.add(word);
//        }
//        while(!store.isEmpty()) mergeWord = mergeWord.concat(String.valueOf(store.poll()));
//
//        if (tmpStore.get(mergeWord) != null) return 0;

        for(String order: orders) {
            checkNum = 0;
            if (orders.length - tmpCnt == 1 && valiCount < 1) break;
            if (order.length() >= courseNum) {
                for (int i = 0; i < courseNum; i++) {
                    if (order.indexOf(table[i]) != -1) {
                        checkNum++;
                    } else {
                        break;
                    }
                }
            }
            valiCount = checkNum == courseNum ? valiCount+1 : valiCount;
            tmpCnt++;
        }

//        System.out.println(valiCount);
        return valiCount;
    }

    static String[] sorting(String[] orders) {
        PriorityQueue<Character> store = new PriorityQueue<>();
        String[] returnOrders = new String[orders.length];
        String tmpOrder = "";
        int count = 0;
        for(String order: orders) {
            tmpOrder = "";
            char[] words = order.toCharArray();
            for(char word: words) store.add(word);
            while(!store.isEmpty()) {
                tmpOrder += store.poll();
            }
            returnOrders[count] = tmpOrder;
            count++;
        }
        return returnOrders;
    }
}
