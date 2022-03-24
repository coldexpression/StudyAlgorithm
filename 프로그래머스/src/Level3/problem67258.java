package Level3;

import java.util.*;

public class problem67258 {

    public static void main(String[] args) {
        problem67258 problem67258 = new problem67258();
//        problem67258.solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"});
//        problem67258.solution(new String[]{"XYZ", "XYZ", "XYZ"});
//        problem67258.solution(new String[]{"AA", "AB", "AC", "AA", "AC"});
        problem67258.solution(new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"});
    }

    public int[] solution(String[] gems) {
        HashMap<String, Integer> gemsAccount = new HashMap<>();
        List<int[]> log = new ArrayList<>();
        int[] answer = {};
        int start = 0;
        int end = 0;
        int range = 100001;
        int startingPoint = 100001;
        int endPoint = 100001;
        int gemSize = getGemSize(gems);
        if (gemSize == 1) return new int[]{1,1};
        while(true) {
            System.out.println("보석 수량 : " + gemsAccount);
            String headGem = gems[start];

            if(gemsAccount.size() == gemSize) {
                gemsAccount.put(headGem, gemsAccount.get(headGem) - 1);
                if(gemsAccount.get(headGem) == 0) gemsAccount.remove(headGem);
                start++;
            } else if(end == gems.length) {
                break;
            }
            else {
                gemsAccount.put(gems[end], gemsAccount.getOrDefault(gems[end], 0) + 1);
                end++;
            }

            if(gemsAccount.size() == gemSize) {
                if (range > end - start) {
                    range = end - start;
                    startingPoint = start + 1;
                    endPoint = end;
                }
            }

//            if (gemsAccount.size() == gemSize && range >= (end-start) && startingPoint >= (start+1)) {
//                log.add(new int[]{start+1, end+1});
//                startingPoint = start + 1;
//                range = end - start;
//            }
//
//            if(gemsAccount.get(headGem) > 1) {
//                start++;
//                gemsAccount.put(headGem, gemsAccount.get(headGem)-1);
//            } else if (gemsAccount.get(headGem) <= 1) {
//                if (end+1 >= gems.length) break;
//                gemsAccount.put(gems[end+1], gemsAccount.getOrDefault(gems[end+1], 0)+1);
//                end++;
//            }


        }
        System.out.println("start : " + startingPoint);
        System.out.println("end : " + endPoint);
        answer = new int[]{startingPoint, endPoint};

        return answer;
    }

    private HashMap<String, Integer> init(String[] gems) {
        HashMap<String, Integer> gemStore = new HashMap<>();
        for(String gem: gems) gemStore.put(gem, 0);
        return gemStore;
    }

    private boolean gemsCheck(HashMap<String, Integer> gemsAccount, int size) {
        int count = 0;
        System.out.println("들어온 보석 들 >> " + gemsAccount);
        for(int value: gemsAccount.values()) count = value != 0 ? count + 1 : count;
        System.out.println(count);
        return size == count;
    }

    private int getGemSize(String[] gems) {
        HashSet<String> gemBox = new HashSet<>(Arrays.asList(gems));
        return gemBox.size();
    }

//    public int[] solution(String[] gems) {
//        int[] answer = {};
//        int gemSize = 0;
//        int firstIndex = 0;
//        int lastIndex = 0;
//        int index = 0;
//        String firstGem = "";
//        HashSet<String> gem_clothes = new HashSet<>();
//        HashSet<String> current_gems = new HashSet<>();
//        HashMap<String, Integer> board = new HashMap<>();
//        HashMap<Integer, int[]> lengthStore = new HashMap<>();
//        for (int i = 0; i < gems.length; i++) gem_clothes.add(gems[i]);
//        if (gem_clothes.size() == 1) return new int[]{1, 1};
//        gemSize = gem_clothes.size();
//        while (index != gems.length -1) {
//            firstGem = gems[firstIndex];
//            board.put(gems[firstIndex], firstIndex);
//            current_gems.add(firstGem);
//            lastIndex = 0;
//            for (int i = firstIndex + 1; i < gems.length; i++) {
//                index = i;
//                if (current_gems.size() == gemSize) {
//                    lastIndex = i - 1;
//                    break;
//                }
//                if (firstGem.equals(gems[i])) {
//                    if (current_gems.size() == 1) firstIndex = i;
//                    else {
//                        current_gems.remove(gems[i]);
//                        firstIndex = board.get(gems[i]) + 1;
//                        firstGem = gems[firstIndex];
//                        i = firstIndex;
//                    }
//                } else {
//                    board.put(gems[i], i);
//                    current_gems.add(gems[i]);
//                }
//            }
//            lastIndex = lastIndex == 0 ? gems.length - 1 : lastIndex;
//            firstIndex++;
//            lastIndex++;
//            System.out.println("[" + firstIndex + "," + lastIndex + "]");
//            if (!lengthStore.containsKey((lastIndex - firstIndex) + 1)) lengthStore.put((lastIndex - firstIndex) + 1, new int[]{firstIndex, lastIndex});
//            board.clear();
//            current_gems.clear();
//        }
//        for(int key: lengthStore.keySet()) return lengthStore.get(key);
//        return answer;
//    }
}
