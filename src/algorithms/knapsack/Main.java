package algorithms.knapsack;

import java.util.Scanner;

public class Main {
    private final int MAX_CAPABILITY = 10000;
    private final int MAX_SUBJECTS_NUMBER = 300;
    private int[] subjectWeights = new int[MAX_SUBJECTS_NUMBER];
    private int[][] knapsackMaxWeight = new int[MAX_CAPABILITY + 1][MAX_SUBJECTS_NUMBER + 1];

    private int calcKnapsackMaxWeight(int knapsackCapability, int subjectsNumber) {
        if (knapsackMaxWeight[knapsackCapability][subjectsNumber] != -1) {
            return knapsackMaxWeight[knapsackCapability][subjectsNumber];
        }

        int firstWeight = calcKnapsackMaxWeight(knapsackCapability, subjectsNumber - 1);
        knapsackMaxWeight[knapsackCapability][subjectsNumber - 1] = firstWeight;

        int remainingKnapsackCapability = knapsackCapability - subjectWeights[subjectsNumber - 1];
        if (remainingKnapsackCapability >= 0) {
            int secondWeight = calcKnapsackMaxWeight(
                    remainingKnapsackCapability,
                    subjectsNumber - 1
            ) + subjectWeights[subjectsNumber - 1];
            knapsackMaxWeight[knapsackCapability][subjectsNumber - 1] = secondWeight;
            return Integer.max(firstWeight, secondWeight);
        }
        return firstWeight;
    }

    private void init() {
        for (int i = 0; i <= MAX_CAPABILITY; i++) {
            for (int j = 0; j <= MAX_SUBJECTS_NUMBER; j++) {
                if (i == 0 || j == 0) {
                    knapsackMaxWeight[i][j] = 0;
                } else {
                    knapsackMaxWeight[i][j] = -1;
                }
            }
        }
    }

    public void run() {
        init();
        Scanner scanner = new Scanner(System.in);
        int knapsackCapability = scanner.nextInt();
        int subjectsNumber = scanner.nextInt();
        for (int i = 0; i < subjectsNumber; i++) {
             subjectWeights[i] = scanner.nextInt();
        }
        int maxWeight = calcKnapsackMaxWeight(knapsackCapability, subjectsNumber);
        System.out.println(maxWeight);
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
