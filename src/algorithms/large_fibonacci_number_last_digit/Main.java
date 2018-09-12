package algorithms.large_fibonacci_number_last_digit;

import java.util.Scanner;

public class Main {
    private int calcFibonacciNumberLastDigit(int number) {
        if (number == 0) {
            return 0;
        }
        int previousDigit = 1;
        int currentDigit = 1;
        for (int currentIndex = 2; currentIndex < number; currentIndex++) {
            int temp = currentDigit;
            currentDigit = (previousDigit + currentDigit) % 10;
            previousDigit = temp;
        }
        return currentDigit;
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int lastDigit = calcFibonacciNumberLastDigit(number);
        System.out.println(lastDigit);
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
