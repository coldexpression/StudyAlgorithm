package Level3;

import java.util.*;

public class problem67258 {

    public static void main(String[] args) {
        problem67258 problem67258 = new problem67258();
        problem67258.solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"});
    }

    public int[] solution(String[] gems) {
        int[] answer = {};
        int gemSize = 0;
        int firstIndex = 0;
        int lastIndex = 0;
        int index = 0;
        String firstGem = "";
        HashSet<String> gem_clothes = new HashSet<>();
        HashSet<String> current_gems = new HashSet<>();
        HashMap<String, Integer> board = new HashMap<>();
        HashMap<Integer, int[]> lengthStore = new HashMap<>();
        for (int i = 0; i < gems.length; i++) gem_clothes.add(gems[i]);
        if (gem_clothes.size() == 1) return new int[]{1, 1};
        gemSize = gem_clothes.size();
        while (index != gems.length -1) {
            firstGem = gems[firstIndex];
            board.put(gems[firstIndex], firstIndex);
            current_gems.add(firstGem);
            lastIndex = 0;
            for (int i = firstIndex + 1; i < gems.length; i++) {
                index = i;
                if (current_gems.size() == gemSize) {
                    lastIndex = i - 1;
                    break;
                }
                if (firstGem.equals(gems[i])) {
                    if (current_gems.size() == 1) firstIndex = i;
                    else {
                        current_gems.remove(gems[i]);
                        firstIndex = board.get(gems[i]) + 1;
                        firstGem = gems[firstIndex];
                        i = firstIndex;
                    }
                } else {
                    board.put(gems[i], i);
                    current_gems.add(gems[i]);
                }
            }
            lastIndex = lastIndex == 0 ? gems.length - 1 : lastIndex;
            firstIndex++;
            lastIndex++;
            System.out.println("[" + firstIndex + "," + lastIndex + "]");
            if (!lengthStore.containsKey((lastIndex - firstIndex) + 1)) lengthStore.put((lastIndex - firstIndex) + 1, new int[]{firstIndex, lastIndex});
            board.clear();
            current_gems.clear();
        }
        for(int key: lengthStore.keySet()) return lengthStore.get(key);
        return answer;
    }
}
