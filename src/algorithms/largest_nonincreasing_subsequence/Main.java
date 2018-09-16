package algorithms.largest_nonincreasing_subsequence;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private void run() {
        Scanner scanner = new Scanner(System.in);
        int arraySize = scanner.nextInt();
        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = scanner.nextInt();
        }
        int[] subsequence = calcLargestNonincreasingSubsequence(array);
        StringBuilder outputBuilder = new StringBuilder();
        outputBuilder.append(String.format("%d\n", subsequence.length));
        for (int index : subsequence) {
            outputBuilder.append(String.format("%d ", index + 1));
        }
        System.out.println(outputBuilder.toString());
    }

    private int lowerBound(int[] array, int length, int searchElement) {
        int left = -1;
        int right = length;
        while (left + 1 < right) {
            int current = (left + right) >> 1;
            if (array[current] >= searchElement) {
                left = current;
            } else {
                right = current;
            }
        }
        return right;
    }

    private int[] calcLargestNonincreasingSubsequence(int[] array) {
        int[] sequencesEndsIndices = new int[array.length];
        int[] sequencesEnds = new int[array.length];
        Arrays.setAll(sequencesEnds, index -> Integer.MIN_VALUE);
        sequencesEnds[0] = array[0];
        int[] prevPositions = new int[array.length];
        Arrays.setAll(prevPositions, index -> -1);
        int length = 1;

        for (int i = 1; i < array.length; i++) {
            int pos = lowerBound(sequencesEnds, length, array[i]);
            if (pos == length) {
                length++;
                sequencesEnds[pos] = array[i];
                sequencesEndsIndices[pos] = i;
                prevPositions[i] = sequencesEndsIndices[pos - 1]; // pos - 1;
            }
            else if (pos == 0) {
                if (sequencesEnds[pos] <= array[i]) {
                    sequencesEnds[pos] = array[i];
                    sequencesEndsIndices[pos] = i;
                    prevPositions[i] = -1;
                }
            }
            else if (sequencesEnds[pos] <= array[i] && array[i] <= sequencesEnds[pos - 1]) {
                sequencesEnds[pos] = array[i];
                sequencesEndsIndices[pos] = i;
                prevPositions[i] = sequencesEndsIndices[pos - 1]; // pos - 1;
            }
        }

        int[] sequenceIndices = new int[length];
        int pos = sequencesEndsIndices[length - 1];
        int index = length - 1;
        while (pos != -1) {
            sequenceIndices[index--] = pos;
            pos = prevPositions[pos];
        }
        return sequenceIndices;
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
