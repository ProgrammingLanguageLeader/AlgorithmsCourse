package algorithms.large_fibonacci_number_by_modulus;

import java.util.Scanner;
import java.util.Vector;

public class Main {
    private int calcFibonacciNumberByModulus(long number, int modulus) {
        if (number == 0) {
            return 0;
        }
        Vector<Integer> remainders = new Vector<>(modulus);
        remainders.add(0, 0);
        remainders.add(1, 1);
        long period = number + 1;
        for (int currentIndex = 2; currentIndex <= number; currentIndex++) {
            int currentRemainder = (remainders.get(currentIndex - 1) + remainders.get(currentIndex - 2)) % modulus;
            remainders.add(currentIndex, currentRemainder);
            if (currentRemainder == 1 && remainders.get(currentIndex - 1) == 0) {
                period = currentIndex - 1;
                break;
            }
        }
        return remainders.get((int)(number % period));
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        long number = scanner.nextLong();
        int modulus = scanner.nextInt();
        System.out.println(calcFibonacciNumberByModulus(number, modulus));
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
