package Level2;

import java.util.*;

public class problem17680 {

    public static void main(String[] args) {
        problem17680 problem17680 = new problem17680();
//        problem17680.solution(3, new String[]{"Jeju","Pangyo","NewYork","newyork"});
        problem17680.solution(5, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"});
    }

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        int nextPoint = 0;
        Queue<String> cache = new LinkedList<>();

        for(int i=0;i<cities.length;i++) {
            cities[i] = cities[i].toLowerCase();
        }

        if (cacheSize == 0) {
            answer = cities.length * 5;
        } else {
                cache.add(cities[0]);
                answer = answer + 5;

            System.out.println("첫 캐시: " + cache);

            for (int i = 1; i < cities.length; i++) {
                if (cache.contains(cities[i])) {
                    cache.remove(cities[i]);
                    cache.add(cities[i]);
                    answer = answer + 1;
                } else {
                    if (cacheSize == cache.size()) {
                        cache.poll();
                    }
                    cache.add(cities[i]);
                    answer = answer + 5;
                    nextPoint = cacheSize - 1 == nextPoint ? 0 : nextPoint + 1;
                }
                System.out.println(cache);
                System.out.println(answer);
            }
        }

        System.out.println(answer);
        return answer;
    }

}
