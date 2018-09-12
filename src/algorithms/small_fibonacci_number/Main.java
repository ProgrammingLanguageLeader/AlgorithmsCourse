package algorithms.small_fibonacci_number;

import java.util.Scanner;

public class Main {
    private int recurrentFibonacciNumber(int number) {
        if (number <= 0) {
            return 0;
        } else if (number == 1) {
            return 1;
        }
        return recurrentFibonacciNumber(number - 1) + recurrentFibonacciNumber(number - 2);
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int fibonacciNumber = recurrentFibonacciNumber(number);
        System.out.println(fibonacciNumber);
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
