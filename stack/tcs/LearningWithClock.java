import java.util.*;

public class LearningWithClock {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Initial time parsing
        String time = scanner.nextLine();
        String[] timeParts = time.split(":");
        int initialHour = Integer.parseInt(timeParts[0]) % 12;
        int initialMinute = Integer.parseInt(timeParts[1]);
        
        // Number of queries
        int Q = scanner.nextInt();
        
        // Costs
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int X = scanner.nextInt();
        int Y = scanner.nextInt();
        
        // Angles for queries
        int[] angles = new int[Q];
        for (int i = 0; i < Q; i++) {
            angles[i] = scanner.nextInt();
        }
        
        scanner.close();
        
        // Compute initial angles of hour and minute hands
        int initialMinuteAngle = initialMinute * 6; // 360 degrees / 60 minutes
        double initialHourAngle = initialHour * 30 + initialMinute * 0.5; // 360 degrees / 12 hours + minute offset
        
        int totalMinCost = 0;
        
        for (int angle : angles) {
            totalMinCost += calculateMinCost(angle, initialHourAngle, initialMinuteAngle, A, B, X, Y);
        }
        
        System.out.println(totalMinCost);
    }
    
    private static int calculateMinCost(int targetAngle, double initialHourAngle, int initialMinuteAngle, int A, int B, int X, int Y) {
        int minCost = Integer.MAX_VALUE;
        
        // Possible movements
        for (int hourMove = -12; hourMove <= 12; hourMove++) {
            double newHourAngle = (initialHourAngle + hourMove * 30) % 360;
            if (newHourAngle < 0) newHourAngle += 360;
            
            for (int minuteMove = -60; minuteMove <= 60; minuteMove++) {
                int newMinuteAngle = (initialMinuteAngle + minuteMove * 6) % 360;
                if (newMinuteAngle < 0) newMinuteAngle += 360;
                
                double angleBetween = Math.abs(newHourAngle - newMinuteAngle);
                angleBetween = Math.min(angleBetween, 360 - angleBetween);
                
                if ((int)angleBetween == targetAngle) {
                    int hourCost = Math.abs(hourMove) * 30 * (hourMove > 0 ? A : B) * X;
                    int minuteCost = Math.abs(minuteMove) * 6 * (minuteMove > 0 ? A : B) * Y;
                    int totalCost = hourCost + minuteCost;
                    minCost = Math.min(minCost, totalCost);
                }
            }
        }
        
        return minCost;
    }
}
