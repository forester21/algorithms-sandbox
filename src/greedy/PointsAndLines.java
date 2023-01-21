package greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class PointsAndLines {

    public static void main(String[] args) {
        Line[] linesArray = scanInput();
        List<Integer> points = calculatePoints(linesArray);
        System.out.println(points.size());
        points.forEach(it -> System.out.print(it + " "));
    }

    private static Line[] scanInput() {
        Scanner scanner = new Scanner(System.in);
        int linesNumber = scanner.nextInt();
        Line[] linesArray = new Line[linesNumber];
        for (int i = 0; i < linesNumber; i++) {
            Line line = new Line();
            line.start = scanner.nextInt();
            line.end = scanner.nextInt();
            linesArray[i] = line;
        }
        return linesArray;
    }

    private static List<Integer> calculatePoints(Line[] linesArray) {
        List<Line> sortedLines = stream(linesArray).sorted(Line.endComparator).collect(toList());
        List<Integer> points = new ArrayList<>(linesArray.length);
        Integer lastPoint = null;
        for (Line it : sortedLines) {
            if (lastPoint != null && it.start <= lastPoint) {
                continue;
            }
            lastPoint = it.end;
            points.add(lastPoint);
        }
        return points;
    }

    private static class Line {
        public Integer start;
        public Integer end;

        public static Comparator<Line> endComparator = Comparator.comparingInt(o -> o.end);
    }
}
