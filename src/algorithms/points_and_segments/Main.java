package algorithms.points_and_segments;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    private void run() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder outputBuilder = new StringBuilder();
        int segmentsNumber = scanner.nextInt();
        int pointsNumber = scanner.nextInt();
        Segment[] segmentsSortedByLeft = new Segment[segmentsNumber];
        for (int i = 0; i < segmentsNumber; i++) {
            int left = scanner.nextInt();
            int right = scanner.nextInt();
            segmentsSortedByLeft[i] = new Segment(left, right);
        }
        int[] points = new int[pointsNumber];
        for (int i = 0; i < pointsNumber; i++) {
            points[i] = scanner.nextInt();
        }

        Segment[] segmentsSortedByRight = segmentsSortedByLeft.clone();
        Arrays.sort(segmentsSortedByLeft, Comparator.comparing(Segment::getLeft));
        Arrays.sort(segmentsSortedByRight, Comparator.comparing(Segment::getRight));
        for (int i = 0; i < pointsNumber; i++) {
            int lastLeftSegmentIndex = searchLastLeft(segmentsSortedByLeft, points[i]);
            int lastRightSegmentIndex = searchLastRight(segmentsSortedByRight, points[i]);
            outputBuilder.append(String.format("%d ", lastLeftSegmentIndex - lastRightSegmentIndex));
        }
        System.out.println(outputBuilder.toString());
    }

    private int searchLastLeft(Segment[] segments, int point) {
        int left = -1;
        int right = segments.length;
        // segments[left].getLeft() <= point
        // segments[right].getLeft() > point
        while (left + 1 < right) {
            int current = (left + right) >> 1;
            if (segments[current].getLeft() <= point) {
                left = current;
            } else {
                right = current;
            }
        }
        if (left >= 0) {
            if (segments[left].getLeft() <= point) {
                return left;
            }
        }
        return -1;
    }

    private int searchLastRight(Segment[] segments, int point) {
        int left = -1;
        int right = segments.length;
        // segments[left].getRight() < point
        // segments[right].getRight() >= point
        while (left + 1 < right) {
            int current = (left + right) >> 1;
            if (segments[current].getRight() < point) {
                left = current;
            } else {
                right = current;
            }
        }
        if (left >= 0) {
            if (segments[left].getRight() < point) {
                return left;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
