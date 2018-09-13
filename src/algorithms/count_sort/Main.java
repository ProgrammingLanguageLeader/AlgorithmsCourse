package algorithms.count_sort;

import java.util.Scanner;

public class Main {
    private static final int COUNTER_ELEMENTS = 11;

    private void run() {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] digits = new int[number];
        int[] counter = new int[COUNTER_ELEMENTS];
        for (int i = 0; i < number; i++) {
            int digit = scanner.nextInt();
            digits[i] = digit;
            counter[digit]++;
        }
        for (int i = 1; i < counter.length; i++) {
            counter[i] += counter[i - 1];
        }
        int[] sortedDigits = new int[number];
        for (int i = number - 1; i >= 0; i--) {
            sortedDigits[counter[digits[i]] - 1] = digits[i];
            counter[digits[i]]--;
        }
        StringBuilder outputBuilder = new StringBuilder();
        for (int digit: sortedDigits) {
            outputBuilder.append(String.format("%d ", digit));
        }
        System.out.println(outputBuilder.toString());
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
