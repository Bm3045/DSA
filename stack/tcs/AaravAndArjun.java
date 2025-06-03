import java.util.*;

public class AaravAndArjun {

    static class LineSegment {
        int x1, y1, x2, y2;

        LineSegment(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        double length() {
            return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<LineSegment> segments = new ArrayList<>();
        Map<String, Integer> pointCount = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();

            segments.add(new LineSegment(x1, y1, x2, y2));
            pointCount.put(x1 + "," + y1, pointCount.getOrDefault(x1 + "," + y1, 0) + 1);
            pointCount.put(x2 + "," + y2, pointCount.getOrDefault(x2 + "," + y2, 0) + 1);
        }

        List<int[]> polygonPoints = findClosedFigure(pointCount);
        if (polygonPoints == null) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
            double area = calculateArea(polygonPoints);
            if (canFormSameFigure(segments, polygonPoints, area)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
            System.out.printf("%.2f%n", area);
        }

        scanner.close();
    }

    private static List<int[]> findClosedFigure(Map<String, Integer> pointCount) {
        List<int[]> polygonPoints = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : pointCount.entrySet()) {
            if (entry.getValue() == 2) {
                String[] point = entry.getKey().split(",");
                polygonPoints.add(new int[]{Integer.parseInt(point[0]), Integer.parseInt(point[1])});
            }
        }

        if (polygonPoints.size() >= 3) {
            return polygonPoints;
        } else {
            return null;
        }
    }

    private static double calculateArea(List<int[]> points) {
        int n = points.size();
        double area = 0.0;

        for (int i = 0; i < n; i++) {
            int[] p1 = points.get(i);
            int[] p2 = points.get((i + 1) % n);

            area += p1[0] * p2[1] - p2[0] * p1[1];
        }

        return Math.abs(area) / 2.0;
    }

    private static boolean canFormSameFigure(List<LineSegment> segments, List<int[]> polygonPoints, double polygonArea) {
        List<LineSegment> leftovers = new ArrayList<>();
        Set<String> polygonEdges = new HashSet<>();

        for (int i = 0; i < polygonPoints.size(); i++) {
            int[] p1 = polygonPoints.get(i);
            int[] p2 = polygonPoints.get((i + 1) % polygonPoints.size());
            polygonEdges.add(p1[0] + "," + p1[1] + "-" + p2[0] + "," + p2[1]);
            polygonEdges.add(p2[0] + "," + p2[1] + "-" + p1[0] + "," + p1[1]);
        }

        for (LineSegment segment : segments) {
            String edge = segment.x1 + "," + segment.y1 + "-" + segment.x2 + "," + segment.y2;
            String reverseEdge = segment.x2 + "," + segment.y2 + "-" + segment.x1 + "," + segment.y1;

            if (!polygonEdges.contains(edge) && !polygonEdges.contains(reverseEdge)) {
                leftovers.add(segment);
            }
        }

        // Try to form the same figure with leftover pieces
        // Note: This is a complex part, requiring combinatorial geometry techniques, which is simplified here.

        return false; // Placeholder for actual implementation
    }
}

