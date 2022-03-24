package Level3;

import java.util.*;

public class problem77486 {

    public static void main(String[] args) {
        problem77486 problem77486 = new problem77486();
        problem77486.solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"}, new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                new String[]{"young", "john", "tod", "emily", "mary"}, new int[]{12, 4, 2, 5, 10});
    }

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        HashMap<Integer, String> nameStore = namePosition(enroll);
        HashMap<String, String> graph = loadGraph(nameStore, referral);
        HashMap<String, Integer> totalAmount = loadAmount(enroll);
        System.out.println(nameStore);
        System.out.println(graph);

        for(int i=0;i<seller.length;i++) {
            String sellerName = seller[i];
            int sellerAmount = amount[i] * 100;
            int restAmount = 0;
            String currentName = sellerName;

            while(!currentName.equals("minho")) {
                String nextName = graph.get(currentName);
                restAmount = sellerAmount/10;
                sellerAmount = sellerAmount - (sellerAmount/10);
                System.out.println("currentUser : " + currentName);
                System.out.println("sellerAmount : " + sellerAmount);
                if(restAmount < 1) {
                    sellerAmount += restAmount;
                    totalAmount.put(currentName, totalAmount.get(currentName) + sellerAmount);
                    break;
                }

                totalAmount.put(currentName, totalAmount.get(currentName) + sellerAmount);
                sellerAmount = restAmount;
                currentName = nextName;
            }
        }

        System.out.println(totalAmount);

        for(int i=0;i<enroll.length;i++)
            answer[i] = totalAmount.get(nameStore.get(i+1));

        return answer;
    }

    private HashMap<String, Integer> loadAmount(String[] enroll) {
        HashMap<String, Integer> totalAmount = new HashMap<>();
        for(String people: enroll) totalAmount.put(people, 0);
        totalAmount.put("minho", 0);
        return totalAmount;
    }

    private HashMap<String, String> loadGraph(HashMap<Integer, String> nameStore, String[] referral) {
        HashMap<String, String> graph = new HashMap<>();
        int pickIndex = 0;
        String pickName = "";
        for(int i=0;i<referral.length;i++) {
            pickIndex = i+1;
            pickName = nameStore.get(pickIndex);
            if(!referral[i].equals("-")) {
                graph.put(pickName, referral[i]);
            } else {
                graph.put(pickName, "minho");
            }
        }

        graph.put("minho", "none");
        return graph;
    }


    private HashMap<Integer, String> namePosition(String[] enroll) {
        HashMap<Integer, String> store = new HashMap<>();
        store.put(0, "minho");
        for(int i=0;i<enroll.length;i++)
            store.put(i+1, enroll[i]);

        return store;
    }
}
