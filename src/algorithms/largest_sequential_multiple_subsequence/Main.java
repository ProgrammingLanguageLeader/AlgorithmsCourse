package algorithms.largest_sequential_multiple_subsequence;

import java.util.Scanner;

public class Main {
    private void run() {
        Scanner scanner = new Scanner(System.in);
        int arraySize = scanner.nextInt();
        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = scanner.nextInt();
        }
        int largestSubsequenceLength = calcLargestSequentialMultipleSubsequenceLength(array);
        System.out.println(largestSubsequenceLength);
    }

    private int calcLargestSequentialMultipleSubsequenceLength(int[] array) {
        int largestSubsequenceLength = 1;
        int[] sequencesLength = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            sequencesLength[i] = 1;
            for (int j = 0; j < i; j++) {
                if (sequencesLength[j] + 1 > sequencesLength[i] && array[i] % array[j] == 0) {
                    sequencesLength[i] = sequencesLength[j] + 1;
                }
            }
            largestSubsequenceLength = Integer.max(largestSubsequenceLength, sequencesLength[i]);
        }
        return largestSubsequenceLength;
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
