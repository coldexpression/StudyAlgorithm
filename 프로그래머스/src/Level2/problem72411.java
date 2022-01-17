package Level2;

import java.util.*;

public class problem72411 {

    static Map<Integer, String> tmpStore = new HashMap<>();
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
            dfs(0, sortedOrders, store, course[i]);
//            maxIndex = -1;
//            for (int key : tmpStore.keySet()) {
//                System.out.println(key);
//                maxIndex = Math.max(key, maxIndex);
//            }




            System.out.println("벨류");
            for (String value : tmpStore.values()) {
                System.out.println(value);
            }



            if (!tmpStore.isEmpty()) {
                String[] splits = tmpStore.get(max).split(" ");
                for (String split : splits) {
                    wordStore.add(split);
                }
                tmpStore.clear();
            }
        }

        System.out.println("정답");


        answer = new String[wordStore.size()];
        for(int i=0;i<answer.length;i++) answer[i] = wordStore.get(i);


        Arrays.sort(answer);

//        for (String s : answer) {
//            System.out.println(s);
//        }

        return answer;
    }

    // * 2022-01-15
    // 한턴이 도는 동안 courseNum을 만족하는 문자배열이 있다면 그것을 리스트에 넣어두고 다음턴부터 비교하여 중복되는것을 방지 [예) AC - CA 와 같은 것들]

    // * 2022-01-17
    // 두 번째 아이디어, orders 들을 Map<Integer, char[]> 형태로 해보기

    static void dfs(int n, String[] orders, char[] store, int courseNum) {
        if (courseNum == count) {
            int orderNum = validation(orders, courseNum);
            if (orderNum >= max) {
                PriorityQueue<Character> splitWordStore = new PriorityQueue<>();
                String mergeWord = "";
                max = orderNum;
//                char[] tmpTable = new char[table.length];
//                for(int i=0;i< tmpTable.length;i++) tmpTable[i] = table[i];
//
//                Arrays.sort(tmpTable);
                for(int i=0;i<table.length;i++) splitWordStore.add(table[i]);
                while(!splitWordStore.isEmpty()) mergeWord += splitWordStore.poll();

//                max = orderNum;
//                resultList.add(String.valueOf(table));
                if (tmpStore.get(orderNum) == null) {
                    tmpStore.put(orderNum, String.valueOf(mergeWord));
                } else {
                    if (!tmpStore.get(orderNum).contains(String.valueOf(mergeWord))) {
                        tmpStore.put(orderNum, tmpStore.get(orderNum).concat(" " + String.valueOf(mergeWord)));
                    }
                }

            }
        } else {
            for(int i=0;i<store.length;i++) {
                if (searchIndex(store[i]) == -1) {
                    table[n] = store[i];
                    count++;
                    dfs(n+1, orders, store, courseNum);
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
        int valiCount = 0;
        int checkNum = 0;
        int tmpCnt = 0;
//        System.out.println(table);
        for(String order: orders) {
            checkNum = 0;
            if (orders.length - tmpCnt == 1 && valiCount < 1) break;
            for (int i=0;i<courseNum;i++) {
                if (order.indexOf(table[i]) != -1) {
                    checkNum++;
                } else {
                    break;
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
