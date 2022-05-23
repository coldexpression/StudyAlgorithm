package Level3;

import java.util.*;

public class problem60062 {

    static PriorityQueue<Integer> answerQueue;
    static int weakSize;

    public static void main(String[] args) {
        problem60062 problem60062 = new problem60062();
//        problem60062.solution(12, new int[]{1,5,6,10},new int[]{1,2,3,4});
//        problem60062.solution(200, new int[]{0,100},new int[]{1,1});
        problem60062.solution(200, new int[]{0,10,50,80,120,160},new int[]{1,10, 5, 40, 30});
//        problem60062.solution(12, new int[]{1,3,4,9,10},new int[]{3,5,7});
//        problem60062.solution(12, new int[]{10,0}, new int[]{1,2});
    }

    public int solution(int n, int[] weak, int[] dist) {
        HashSet<Integer> rightSet = new HashSet<>();
        HashSet<Integer> weakSet = new HashSet<>();
        int answer = 0;
        HashSet<Integer> passSet = new HashSet<>();
        PriorityQueue<Integer> useDist = new PriorityQueue<>(Collections.reverseOrder());
        answerQueue = new PriorityQueue<>();


        for (int index : weak) {
            weakSet.add(index);
        }

        for (int index : dist) {
            useDist.add(index);
        }

        weakSize = weakSet.size();

        find(passSet, rightSet, weakSet, dist, n, 0,useDist);

        System.out.println(answerQueue);
        System.out.println(answerQueue.peek());
        answer = answerQueue.isEmpty() ? -1 : answerQueue.poll();
        return answer;
    }

    public void find(HashSet<Integer> passSet, HashSet<Integer> rightSet, HashSet<Integer> weakSet, int[] dist, int n, int count, PriorityQueue<Integer> useDist) {
        int right = -1;
        int rightCheckCount = 0;
        boolean circle = false;
        HashSet<Integer> tempSet = new HashSet<>(passSet);
        HashSet<Integer> tempRightSet = new HashSet<>(rightSet);

        if (!answerQueue.isEmpty() && (answerQueue.peek() == 1 || answerQueue.peek() <= count)) return;
        if (weakSet.isEmpty()) {
            System.out.println("취약 지점 비어 있을 때, count >> " + count);
            answerQueue.add(count);
            return;
        }

        System.out.println("가지고 있는 취약지점 : " + weakSet);

        for (int ele : weakSet) {
            PriorityQueue<Integer> tempUseDist = new PriorityQueue<>(useDist);
            HashSet<Integer> tempWeakSet = new HashSet<>(weakSet);
            HashSet<Integer> tempRightWeakSet = new HashSet<>(weakSet);
            System.out.println("뽑은 취약지점 : " + ele);
            System.out.println("사용 가능한 거리 : " + tempUseDist);
            System.out.println("통과한 셋 : " + passSet);
            System.out.println("카운트 : " + count);

            if (passSet.size() == weakSize) {
                answerQueue.add(count);
                System.out.println("투입한 인원 : " + count);
                break;
            }
            if (tempUseDist.isEmpty()) return;

            int distance = tempUseDist.poll();

            if (!passSet.contains(ele)) {
                right = ele - distance;
                System.out.println("수리 가능한 거리 : " + distance);

                if (right < 0) {
                    right += n;
                    circle = right <= ele;
                }
                tempRightSet = checker(passSet, ele, right, n, tempWeakSet);
                for (int num : tempRightSet) {
                    tempRightWeakSet.remove(num);
                }
                rightCheckCount = circle ? weakSize : tempRightSet.size();

                System.out.println("오른쪽 값 : " + right);
                System.out.println("오른쪽 포함 개수 : " + rightCheckCount);
                System.out.println("오른쪽 수리 지점 : " + tempRightSet);
                System.out.println("오른쪽 잔여 취약 지점 : " + tempRightWeakSet);

                if (rightCheckCount == weakSize) {
                    System.out.println("한 친구가 다 휩씀");
                    answerQueue.add(1);
                    return;
                }
                passSet.addAll(tempRightSet);
                find(passSet, tempRightSet, tempRightWeakSet, dist, n, count + 1, tempUseDist);
                passSet = (HashSet<Integer>) tempSet.clone();
            }
        }
    }

    public HashSet<Integer> checker(HashSet<Integer> passSet, int start, int end, int size, HashSet<Integer> weakSet) {
        HashSet<Integer> set = new HashSet<>();

        for (int ele : weakSet) {
            if (!passSet.contains(ele)) {
                if (start > end && (start >= ele && ele >= end)) {
                    set.add(ele);
                } else if (start <= end && ((start >= ele && ele >= 0) || (end <= ele && ele < size))) {
                    set.add(ele);
                }
            }
        }
        return set;
    }
}
