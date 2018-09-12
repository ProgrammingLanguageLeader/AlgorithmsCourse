package algorithms.greatest_common_divisor;

import java.util.Scanner;

public class Main {
    private void run() {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b =scanner.nextInt();
        int gcd = calcGreatestCommonDivisor(a, b);
        System.out.println(gcd);
    }

    private int calcGreatestCommonDivisor(int a, int b) {
        if (b > a) {
            int temp = a;
            a = b;
            b = temp;
        }
        while (b > 0) {
            int temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
