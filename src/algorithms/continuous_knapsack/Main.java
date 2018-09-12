package algorithms.continuous_knapsack;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int subjectsNumber = scanner.nextInt();
        int knapsackCapability = scanner.nextInt();
        double currentValue = 0;
        int currentWeight = 0;
        Subject[] subjects = new Subject[subjectsNumber];
        for (int i = 0; i < subjectsNumber; i++) {
            int cost = scanner.nextInt();
            int weight = scanner.nextInt();
            subjects[i] = new Subject(cost, weight);
        }
        Arrays.sort(subjects, (a, b) -> b.getUnitValue().compareTo(a.getUnitValue()));
        for (Subject subject: subjects) {
            if (currentWeight == knapsackCapability) {
                break;
            }
            int maxItemWeight = subject.getWeight();
            if (maxItemWeight > knapsackCapability - currentWeight) {
                maxItemWeight = knapsackCapability - currentWeight;
            }
            currentValue += maxItemWeight * subject.getUnitValue();
            currentWeight += maxItemWeight;
        }
        System.out.println(String.format("%.3f", currentValue));
    }
}
