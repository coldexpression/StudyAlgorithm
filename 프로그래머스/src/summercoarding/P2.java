package summercoarding;

import java.util.*;

public class P2 {
    public static void main(String[] args) {

    }

    public String[] solution(String[] rooms, int target) {
        String[] answer = {};
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> dstMap = new HashMap<>();
        HashSet<String> removeRoom = new HashSet<>();
        List<People> peopleList = new ArrayList<>();
        List<String> answerList = new ArrayList<>();
        for (String ele : rooms) {
            String names = ele.split("]")[1];
            int room = Integer.parseInt(ele.split("]")[0].replaceAll("\\[", ""));
            for (String name : names.split(",")) {
                if (target == room) removeRoom.add(name);
                int dst = Math.abs(target - room);
                int size = map.getOrDefault(name, 0);
                size++;
                map.put(name, size);
                dstMap.put(name, Math.min(dstMap.getOrDefault(name, 10000), dst));
            }
        }

        for (String key : removeRoom) {
            map.remove(key);
            dstMap.remove(key);
        }

        for (String key : map.keySet()) {
            People people = new People(dstMap.get(key), key, map.get(key));
            peopleList.add(people);
            System.out.println(people.getName());
            System.out.println(people.getDst());
            System.out.println(people.getRoomCount());
        }

        Collections.sort(peopleList, new PeopleComparator());

        for (People p: peopleList) {
            answerList.add(p.getName());
        }

        answer = (String[]) answerList.toArray();

        System.out.println(dstMap);
        System.out.println(map);
        return answer;
    }

    public class People {
        private int dst;
        private String name;
        private int roomCount;

        public People(int dst, String name, int roomCount) {
            this.dst = dst;
            this.name = name;
            this.roomCount = roomCount;
        }

        public int getDst() {
            return dst;
        }

        public int getRoomCount() {
            return roomCount;
        }

        public String getName() {
            return name;
        }
    }

    class PeopleComparator implements Comparator<People> {
        @Override
        public int compare(People o1, People o2) {
            if (o1.getRoomCount() == o2.getRoomCount()) {
                if (o1.getDst() == o2.getDst()) {
                    return o1.getName().charAt(0) - o2.getName().charAt(0);
                }
                return o1.getDst() - o2.getDst();
            }
            return o1.getRoomCount() - o2.getRoomCount();
        }
    }
}

