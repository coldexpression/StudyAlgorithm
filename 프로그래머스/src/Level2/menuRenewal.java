package Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class menuRenewal {
    public static void main(String[] args) {
        menuRenewal menuRenewal = new menuRenewal();
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2,3,4};
//        menuRenewal.solution(orders, course);
        char firstcut = menuRenewal.firstcut(orders);
        String s = String.valueOf(firstcut);
        char lastcut = menuRenewal.lastcut(orders);
        System.out.println(orders[0].contains("A"));
    }

    public String[] solution(String[] orders, int[] course) {
        int index=0;
        String[] answer = {};
        Map<Integer, String[]> orderList = new HashMap<>();
        for (String order : orders) {
            String[] singMenu = order.split("");
            orderList.put(index, singMenu);
            index++;
        }
        for (String[] value : orderList.values()) {
            System.out.println(Arrays.toString(value));
        }
        System.out.println((int)'A');
        return answer;
    }

    public char firstcut(String[] orders) {
        char init = 'Z';
        for (String order : orders) {
            char first = order.charAt(0);
            if (first < init) {
                init = first;
            }
        }
        System.out.println(init);
        return init;
    }

    public char lastcut(String[] orders) {
        char init = 'A';
        for (String order : orders) {
            String[] split1 = order.split("");
            char last = order.charAt(split1.length-1);
            if (last > init) {
                init = last;
            }
        }
        System.out.println(init);
        return init;
    }
}
