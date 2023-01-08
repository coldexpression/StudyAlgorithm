package Backjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class problem1644 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        if (N == 1) System.out.println(0);
        else {
            int[] prime = findPrime(N);

            int left = 0;
            int right = 0;

            int sum = prime[0];
            int ans = 0;

            if (N == sum) System.out.println("1");
            else {
                while (true) {
                    if (left == right && left == (prime.length - 1)) {
                        if (sum == N) ans++;
                        break;
                    }

                    if (sum <= N) {
                        ans = sum == N ? ans + 1 : ans;
                        sum += prime[++right];
                    } else {
                        sum -= prime[left++];
                    }
                }

                System.out.println(ans);
            }
        }
    }

    static int[] findPrime(int N) {
        boolean[] prime = new boolean[N+1];
        Arrays.fill(prime, true);

        List<Integer> list = new ArrayList<>();

        prime[0] = prime[1] = false;

        for(int i=2;i*i<=N;i++) {
            if (isPrime(i)) {
                for(int j=i+i;j<=N;j+=i) prime[j] = false;
            }
        }

        for(int i=2;i<=N;i++)
            if (prime[i]) list.add(i);

        int[] store = new int[list.size()];

        for(int i=0;i<store.length;i++) store[i] = list.get(i);

        return store;
    }

    static boolean isPrime(int n) {
        for(int i=2;i<=Math.sin(n);i++) {
            if (n % i == 0) return false;
        }

        return true;
    }
}
