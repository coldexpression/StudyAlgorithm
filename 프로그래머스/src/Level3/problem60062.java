package Level3;

import java.util.*;

public class problem60062 {

    static PriorityQueue<Integer> answerQueue;
    static int weakSize;

    public static void main(String[] args) {
        problem60062 problem60062 = new problem60062();
        problem60062.solution(12, new int[]{1,5,6,10},new int[]{1,2,3,4});
//        problem60062.solution(12, new int[]{1,3,4,9,10},new int[]{3,5,7});
    }

    public int solution(int n, int[] weak, int[] dist) {
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> leftSet = new HashSet<>();
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

        Arrays.sort(dist);
        weakSize = weakSet.size();

        find(passSet,leftSet, rightSet, weakSet, dist, n, 0, new PriorityQueue<>(useDist));

        System.out.println(answerQueue);
        answer = answerQueue.isEmpty() ? -1 : answerQueue.poll();
        return answer;
    }

    public void find(HashSet<Integer> passSet, HashSet<Integer> leftSet, HashSet<Integer> rightSet, HashSet<Integer> weakSet, int[] dist, int n, int count, PriorityQueue<Integer> useDist) {
        int distIndex = dist.length - 1;
        int left = -1;
        int right = -1;
        int leftCheckCount = 0;
        int rightCheckCount = 0;
        boolean circle = false;
        HashSet<Integer> tempSet = new HashSet<>(passSet);
        HashSet<Integer> tempLeftSet = new HashSet<>(leftSet);
        HashSet<Integer> tempRightSet = new HashSet<>(rightSet);

        if (!answerQueue.isEmpty() && answerQueue.peek() == 1) return ;
        if (weakSet.isEmpty()) {
            System.out.println("취약 지점 비어 있을 때, count >> " + count);
            answerQueue.add(count);
            return;
        }

        System.out.println("가지고 있는 취약지점 : " + weakSet);

        for (int ele : weakSet) {
            HashSet<Integer> tempWeakSet = new HashSet<>(weakSet);
            HashSet<Integer> tempLeftWeakSet = new HashSet<>(weakSet);
            HashSet<Integer> tempRightWeakSet = new HashSet<>(weakSet);
            PriorityQueue<Integer> tempUseDist = new PriorityQueue<>(useDist);
            System.out.println("뽑은 취약지점 : " + ele);
            System.out.println("사용 가능한 거리 : " + tempUseDist);
            System.out.println("통과한 셋 : " + passSet);
            System.out.println("카운트 : " + count);

            if (passSet.size() == weakSize) {
                answerQueue.add(count);
                System.out.println("투입한 인원 : " + count);
                break;
            }

            while (!tempUseDist.isEmpty()) {
                int distance = tempUseDist.poll();
                if (!passSet.contains(ele)) {
                    left = ele + distance;
                    right = ele - distance;
                    System.out.println("수리 가능한 거리 : " + distance);
                    if (left >= n) {
                        left -= n;
                        circle = left >= ele;
                    }

                    tempLeftSet = checker("LEFT", passSet, ele, left, n, tempWeakSet);
                    for (int num : tempLeftSet) {
                        tempLeftWeakSet.remove(num);
                    }
                    leftCheckCount = circle ? weakSize : tempLeftSet.size();

                    if (right < 0) {
                        right += n;
                        circle = right <= ele;
                    }
                    tempRightSet = checker("RIGHT", passSet, ele, right, n, tempWeakSet);
                    for (int num : tempRightSet) {
                        tempRightWeakSet.remove(num);
                    }
                    rightCheckCount = circle ? weakSize : tempRightSet.size();

                    System.out.println("왼쪽 값 : " + left);
                    System.out.println("오른쪽 값 : " + right);
                    System.out.println("왼쪽 포함 갯수 : " + leftCheckCount);
                    System.out.println("오른쪽 포함 개수 : " + rightCheckCount);
                    System.out.println("오른쪽 수리 지점 : " + tempRightSet);
                    System.out.println("왼쪽 수리 지점 : " + tempLeftSet);
                    System.out.println("왼쪽 잔여 취약 지점 : " + tempLeftWeakSet);
                    System.out.println("오른쪽 잔여 취약 지점 : " + tempRightWeakSet);

                    if (leftCheckCount == weakSize || rightCheckCount == weakSize) {
                        System.out.println("한 친구가 다 휩씀");
                        answerQueue.add(1);
                        return;
                    } else if (leftCheckCount == rightCheckCount) {
                        passSet.addAll(tempRightSet);
                        find(passSet, tempLeftSet, tempRightSet, tempRightWeakSet, dist, n, count + 1, new PriorityQueue<>(tempUseDist));
                        passSet = new HashSet<>(tempSet);
                        passSet.addAll(tempLeftSet);
                        find(passSet, tempLeftSet, tempRightSet, tempLeftWeakSet, dist, n, count + 1, new PriorityQueue<>(tempUseDist));
                        passSet = new HashSet<>(tempSet);
                    } else if (rightCheckCount > leftCheckCount) {
                        System.out.println("오른쪽으로 이동!");
                        passSet.addAll(tempRightSet);
                        find(passSet, tempLeftSet, tempRightSet, tempRightWeakSet, dist, n, count + 1, new PriorityQueue<>(tempUseDist));
                        passSet = new HashSet<>(tempSet);
                    } else if (leftCheckCount > rightCheckCount) {
                        System.out.println("왼쪽으로 이동!");
                        passSet.addAll(tempLeftSet);
                        find(passSet, tempLeftSet, tempRightSet, tempLeftWeakSet, dist, n, count + 1, new PriorityQueue<>(tempUseDist));
                        passSet = new HashSet<>(tempSet);
                    }
                }
            }
        }
    }

    public HashSet<Integer> checker(String type, HashSet<Integer> passSet, int start, int end, int size, HashSet<Integer> weakSet) {
        HashSet<Integer> set = new HashSet<>();

        for (int ele : weakSet) {
            if (!passSet.contains(ele)) {
                if (type.equals("LEFT")) {
                    if (start > end) {
                        if ((start <= ele && ele < size) || (ele >= 0 && ele <= end)) {
                            set.add(ele);
                        }
                    } else {
                        if (start <= ele && ele <= end) {
                            set.add(ele);
                        }
                    }
                } else if (type.equals("RIGHT")) {
                    if (start > end) {
                        if (start >= ele && ele >= end) {
                            set.add(ele);
                        }
                    } else {
                        if ((start >= ele && ele >= 0) || (end <= ele && ele < size)) {
                            set.add(ele);
                        }
                    }
                }
            }
        }
        return set;
    }
}
