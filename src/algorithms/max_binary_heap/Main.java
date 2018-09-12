package algorithms.max_binary_heap;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MaxBinaryHeap<Integer> priorityQueue = new MaxBinaryHeap<>(Integer.class);
        Scanner scanner = new Scanner(System.in);
        int operationsNumber = scanner.nextInt();

        StringBuilder outputBuilder = new StringBuilder();
        for (int i = 0; i < operationsNumber; i++) {
            String operation = scanner.next();
            if (operation.equals("Insert")) {
                int operand = scanner.nextInt();
                priorityQueue.insert(operand);
            }
            else if (operation.equals("ExtractMax")) {
                int max = priorityQueue.extractMax();
                outputBuilder.append(String.format("%d\n", max));
            }
        }
        System.out.print(outputBuilder.toString());
    }
}
