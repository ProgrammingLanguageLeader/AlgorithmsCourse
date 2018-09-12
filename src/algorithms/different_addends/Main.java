package algorithms.different_addends;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int addendsNumber = 1;
        int sum = 1;
        int currentAddend = 1;
        if (number == 2) {
            sum = 2;
            currentAddend = 2;
        }
        LinkedList<Integer> addendsList = new LinkedList<>();
        addendsList.push(currentAddend);
        while (sum != number) {
            currentAddend++;
            int remainder = number - sum - currentAddend;
            if (remainder < currentAddend + 1 && remainder != 0) {
                continue;
            }
            sum += currentAddend;
            addendsList.push(currentAddend);
            addendsNumber++;
        }
        StringBuilder outputBuilder = new StringBuilder();
        outputBuilder.append(String.format("%d\n", addendsNumber));
        for (Integer addend : addendsList) {
            outputBuilder.append(String.format("%d ", addend));
        }
        System.out.println(outputBuilder.toString());
    }
}
