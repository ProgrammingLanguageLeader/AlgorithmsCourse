package algorithms.binary_search;

import java.util.Scanner;

public class Main {
    private void run() {
        Scanner scanner = new Scanner(System.in);
        int elementsNumber = scanner.nextInt();
        int[] array = new int[elementsNumber];
        for (int i = 0; i < elementsNumber; i++) {
            array[i] = scanner.nextInt();
        }
        int searchElementsNumber = scanner.nextInt();
        int[] searchElements = new int[searchElementsNumber];
        for (int i = 0; i < searchElementsNumber; i++) {
            searchElements[i] = scanner.nextInt();
        }

        StringBuilder outputBuilder = new StringBuilder();
        for (int i = 0; i < searchElementsNumber; i++) {
            int searchElementIndex = binarySearch(array, searchElements[i]);
            outputBuilder.append(String.format("%d ", searchElementIndex + 1));
        }
        System.out.println(outputBuilder.toString());
    }

    private int binarySearch(int[] array, int searchElement) {
        int left = 0;
        int right = array.length - 1;
        int currentIndex = (left + right) / 2;
        while (left < right) {
            if (searchElement == array[currentIndex]) {
                break;
            }
            if (searchElement < array[currentIndex]) {
                right = currentIndex - 1;
            }
            else {
                left = currentIndex + 1;
            }
            currentIndex = (left + right) / 2;
        }
        if (array[currentIndex] == searchElement) {
            return currentIndex;
        }
        return -2;
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
