package Level2;

import java.util.*;

public class problem72411 {

    static List<String> resultList = new ArrayList<>();
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
        int maxIndex = 0;
        List<String> wordStore = new ArrayList<>();
        List<Integer> wordNumData = new ArrayList<>();
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

        System.out.println(queue);

        int length = queue.size();
        char[] store = new char[length];
        for(int i=0;i<length;i++) {
            store[i] = queue.peek();
            queue.remove();
        }

        for(int i=0;i<course.length;i++) {
            table = new char[course[i]];
            for(int j=0;j<course[i];j++) table[j] = '0';
            bfs(0, orders, store, course[i]);
            maxIndex = -1;
            for (int key : tmpStore.keySet()) {
                System.out.println(key);
                maxIndex = Math.max(key, maxIndex);
            }




            System.out.println("벨류");
            for (String value : tmpStore.values()) {
                System.out.println(value);
            }



            if (!tmpStore.isEmpty()) {
                String[] splits = tmpStore.get(maxIndex).split(" ");
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

    static void bfs(int n, String[] orders, char[] store, int courseNum) {
        if (courseNum == count) {
            int orderNum = validation(orders, courseNum);
            if (orderNum >= max) {
                char[] tmpTable = new char[table.length];
                for(int i=0;i< tmpTable.length;i++) tmpTable[i] = table[i];

                Arrays.sort(tmpTable);
//                max = orderNum;
//                resultList.add(String.valueOf(table));
                if (tmpStore.get(orderNum) == null) {
                    tmpStore.put(orderNum, String.valueOf(tmpTable));
                } else {
                    if (!tmpStore.get(orderNum).contains(String.valueOf(tmpTable))) {
                        tmpStore.put(orderNum, tmpStore.get(orderNum).concat(" " + String.valueOf(tmpTable)));
                    }
                }

            }
        } else {
            for(int i=0;i<store.length;i++) {
                if (searchIndex(store[i]) == -1) {
                    table[n] = store[i];
                    count++;
                    bfs(n+1, orders, store, courseNum);
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
        int checkCount = 0;
//        System.out.println(table);
        for(String order: orders) {
            checkCount = 0;
            boolean[] check = new boolean[courseNum];
            for (int i=0;i<courseNum;i++) {
                if (order.indexOf(table[i]) != -1) {
//                    System.out.println("order : " + order);
//                    System.out.println(table);
//                    System.out.println(table[i]);
                    check[i] = true;
                } else {
                    check[i] = false;
                    break;
                }
            }
            for(boolean checking : check) {
                if (!checking) {
                    checkCount = 0;
                    break;
                } else {
                    checkCount++;
                }
            }
            valiCount = checkCount == courseNum ? valiCount+1 : valiCount;
        }

//        System.out.println(valiCount);
        return valiCount;
    }
}
