package Level2;

import java.util.*;

public class problem92341 {

    public static void main(String[] args) {
        problem92341 problem92341 = new problem92341();
//        problem92341.solution(new int[]{180,5000,10,600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"});
        problem92341.solution(new int[]{1,10,1,11}, new String[]{"00:00 1234 IN", "00:02 1234 OUT"});
    }


    public int[] solution(int[] fees, String[] records) {
        HashMap<String, String> parkingCars = new HashMap<>();
        HashMap<String, Integer> parkingHour = new HashMap<>();
        List<Integer> prices = new ArrayList<>();
        int count = 0;

        for(String info: records) {
            String[] infos = info.split(" ");
            String time = infos[0];
            String carNumber = infos[1];
            String state = infos[2];

            if (!parkingCars.containsKey(carNumber) && state.equals("IN")) {
                parkingCars.put(carNumber, time);
            } else if (parkingCars.containsKey(carNumber) && state.equals("OUT")) {
                int totalHour = timeCalc(parkingCars.get(carNumber), time);
                parkingHour.put(carNumber, parkingHour.getOrDefault(carNumber, 0) + totalHour);
                parkingCars.remove(carNumber);
            }
        }

        for(String carNumber: parkingCars.keySet()) {
            int totalHour = timeCalc(parkingCars.get(carNumber), "23:59");
            parkingHour.put(carNumber, parkingHour.getOrDefault(carNumber, 0) + totalHour);
            parkingCars.remove(carNumber);
        }

        String[] carNumbers = new String[parkingHour.size()];

        for(String carNumber: parkingHour.keySet()) {
            System.out.println("["+carNumber+"] : " + parkingHour.get(carNumber));
            carNumbers[count] = carNumber;
            count++;
        }

        Arrays.sort(carNumbers);

        for (String carNumber : carNumbers) {
            prices.add(priceCalc(parkingHour.get(carNumber), fees));
        }

        int[] answer = new int[prices.size()];
        for(int i=0;i<answer.length;i++) {
            answer[i] = prices.get(i);
        }

        for (int i : answer) {
            System.out.println(i);
        }

        return answer;
    }

    static int timeCalc(String startTime, String endTime) {
        int startHour = Integer.parseInt(startTime.split(":")[0]);
        int startMinute = Integer.parseInt(startTime.split(":")[1]);
        int endHour = Integer.parseInt(endTime.split(":")[0]);
        int endMinute = Integer.parseInt(endTime.split(":")[1]);
        int hour = endHour - startHour;
        int minute = endMinute - startMinute;
        return minute + (60*hour);
    }

    static int priceCalc(int totalHour, int[] fees) {
        int defaultTime = fees[0];
        int defaultPrice = fees[1];
        int unitTime = fees[2];
        int unitPrice = fees[3];
        int totalPrice = 0;
        if (totalHour <= defaultTime) {
            totalPrice = defaultPrice;
        } else {
            int middlePrice = totalHour-defaultTime;
            int upperPrice = middlePrice % unitTime != 0 ? (middlePrice / unitTime) + 1 : middlePrice / unitTime;
            totalPrice = defaultPrice + upperPrice * unitPrice;
        }
        return totalPrice;
    }
}
