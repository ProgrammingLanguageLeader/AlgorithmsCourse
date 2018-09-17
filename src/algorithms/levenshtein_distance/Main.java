package algorithms.levenshtein_distance;

import java.util.Scanner;

public class Main {
    private void run() {
        Scanner scanner = new Scanner(System.in);
        String first = scanner.next();
        String second = scanner.next();
        int distance = calcLevenshteinDistance(first, second);
        System.out.println(distance);
    }

    private int calcLevenshteinDistance(String first, String second) {
        int firstLength = first.length();
        int secondLength = second.length();
        int[][] distance = new int[firstLength + 1][secondLength + 1];
        for (int i = 0; i <= firstLength; i++) {
            distance[i][0]= i;
        }
        for (int j = 0; j <= secondLength; j++) {
            distance[0][j] = j;
        }
        for (int i = 1; i <= firstLength; i++) {
            for (int j = 1; j <= secondLength; j++) {
                int insertDistance = distance[i][j - 1] + 1;
                int deleteDistance = distance[i - 1][j] + 1;
                int coincedenceDistance = distance[i - 1][j - 1];
                if (first.charAt(i - 1) != second.charAt(j - 1)) {
                    coincedenceDistance++;
                }
                int optimalDistance = Integer.min(insertDistance, deleteDistance);
                optimalDistance = Integer.min(optimalDistance, coincedenceDistance);
                distance[i][j] = optimalDistance;
            }
        }
        return distance[firstLength][secondLength];
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
