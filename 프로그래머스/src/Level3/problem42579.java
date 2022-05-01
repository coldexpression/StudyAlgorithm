package Level3;
import java.util.*;

public class problem42579 {

    public static void main(String[] args) {
        problem42579 problem42579 = new problem42579();
        problem42579.solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500});
    }

    public int[] solution(String[] geners, int[] plays) {
        int[] answer = {};
        HashMap<String,Integer> generData = new HashMap<>();
        HashMap<String, List<GenerData>> generIndex = new HashMap<>();
        HashMap<String, List<GenerData>> indexStore = new HashMap<>();
        List<GenerData> outerList = new ArrayList<>();
        List<Integer> resultList = new ArrayList<>();

        for(int i=0;i<plays.length;i++) {
            List<GenerData> indexList = new ArrayList<>();
            generIndex.put(geners[i], indexList);
        }

        for(int i=0;i<plays.length;i++) {
            GenerData data = new GenerData(geners[i], plays[i], i);
            List<GenerData> list = generIndex.get(geners[i]);
            generData.put(geners[i], generData.getOrDefault(geners[i], 0)+plays[i]);
            list.add(data);
            generIndex.put(geners[i], list);

        }
        for(String gener: generData.keySet()) outerList.add(new GenerData(gener, generData.get(gener), 0));

        System.out.println(generData);

        Collections.sort(outerList, new Comparator<GenerData>() {
            @Override
            public int compare(GenerData o1, GenerData o2) {
                return o2.play - o1.play;
            }
        });
        for (GenerData data : outerList) {
            String name = data.getName();
            System.out.println("이름 : " + name);
            List<GenerData> list = generIndex.get(name);
            Collections.sort(list, new Comparator<GenerData>() {
                @Override
                public int compare(GenerData o1, GenerData o2) {
                    int play1 = o1.getPlay();
                    int play2 = o2.getPlay();
                    int index1 = o1.getIndex();
                    int index2 = o2.getIndex();

                    if (play1 == play2) return index1 - index2;
                    return play2 - play1;
                }
            });

            for (GenerData generData1 : list) {
                System.out.print(generData1.getIndex() + " ");
            }
            System.out.println();

            for(int i=0;i<list.size();i++) {
                if (i==2) break;
                GenerData gData = list.get(i);
                resultList.add(gData.getIndex());
            }
        }
        System.out.println();
        for (Integer integer : resultList) {
            System.out.print(integer+" ");
        }

        answer = resultList.stream().mapToInt(i -> i).toArray();
        return answer;
    }

    public class GenerData {
        private String name;
        private int play;
        private int index;

        public GenerData(String name, int play, int index) {
            this.name = name;
            this.play = play;
            this.index = index;
        }


        public String getName() {
            return name;
        }

        public int getIndex() {
            return index;
        }

        public int getPlay() { return play; }
    }
}


