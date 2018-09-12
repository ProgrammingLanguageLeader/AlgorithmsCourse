package algorithms.segments_covering_by_points;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    private void run() {
        Scanner scanner = new Scanner(System.in);
        int segmentsCount = scanner.nextInt();
        Segment[] segments = new Segment[segmentsCount];
        for (int i = 0; i < segmentsCount; i++) {
            int left = scanner.nextInt();
            int right = scanner.nextInt();
            segments[i] = new Segment(left, right);
        }

        Arrays.sort(segments);
        Vector<Integer> usedPoints = new Vector<>();
        for (int i = 0; i < segments.length; i++)  {
            if (segments[i].isMarked()) {
                continue;
            }
            usedPoints.add(segments[i].getRight());
            segments[i].setMarked(true);
            for (int j = i + 1; j < segments.length; j++) {
                if (segments[j].getLeft() <= usedPoints.lastElement()) {
                    segments[j].setMarked(true);
                } else {
                    break;
                }
            }
        }

        StringBuilder outputBuilder = new StringBuilder();
        outputBuilder.append(String.format("%d\n", usedPoints.size()));
        for (int point : usedPoints) {
            outputBuilder.append(String.format("%d ", point));
        }
        System.out.println(outputBuilder.toString());
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
