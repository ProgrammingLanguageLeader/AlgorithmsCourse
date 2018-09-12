package algorithms.inverse_number;

import java.util.Scanner;

public class Main {
    private long inverseNumber;

    public Main() {
        inverseNumber = 0;
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        int arraySize = scanner.nextInt();
        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = scanner.nextInt();
        }
        int[] sortedArray = mergeSort(array, 0, array.length);
        System.out.println(inverseNumber);
    }

    private int[] mergeSort(int[] array, int from, int to) {
        if (to - from == 1) {
            int[] oneElementArray = new int[1];
            oneElementArray[0] = array[from];
            return oneElementArray;
        }
        int midPoint = (from + to) / 2;
        return merge(
                mergeSort(array, from, midPoint),
                mergeSort(array, midPoint, to)
        );
    }

    private int[] merge(int[] leftArray, int[] rightArray) {
        int leftIndex = 0, rightIndex = 0;
        int[] merged = new int[leftArray.length + rightArray.length];
        for (int i = 0; i < leftArray.length + rightArray.length; i++) {
            if (leftIndex < leftArray.length && rightIndex < rightArray.length) {
                if (leftArray[leftIndex] > rightArray[rightIndex]) {
                    merged[i] = rightArray[rightIndex++];
                    inverseNumber += leftArray.length - leftIndex;
                }
                else {
                    merged[i] = leftArray[leftIndex++];
                }
            }
            else {
                if (rightIndex < rightArray.length) {
                    merged[i] = rightArray[rightIndex++];
                }
                else {
                    merged[i] = leftArray[leftIndex++];
                }
            }
        }
        return merged;
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
