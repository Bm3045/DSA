import java.util.*;

public class SnakesAndLadders {
  
    static class Board {
        Map<Integer, Integer> snakes;
        Map<Integer, Integer> ladders;
        
        public Board() {
            snakes = new HashMap<>();
            ladders = new HashMap<>();
        }
        
        public boolean simulatePath(List<Integer> diceRolls, int target, Integer[] swap) {
            int position = 1;
            
            for (int roll : diceRolls) {
                position += roll;
                if (position > 100) {
                    position = 100;
                }
                if (swap != null && position == swap[0]) {
                    position = swap[1];
                } else if (snakes.containsKey(position)) {
                    position = snakes.get(position);
                } else if (ladders.containsKey(position)) {
                    position = ladders.get(position);
                }
            }
            return position == target;
        }
    }
  
    public static String findFaultySnakeOrLadder(int n, List<int[]> mappings, List<Integer> diceRolls, int target) {
        Board board = new Board();
        
        for (int[] map : mappings) {
            int start = map[0], end = map[1];
            if (start > end) {
                board.snakes.put(start, end);
            } else {
                board.ladders.put(start, end);
            }
        }
        
        if (board.simulatePath(diceRolls, target, null)) {
            return "Not affected";
        }
        
        for (int[] map : mappings) {
            int start = map[0], end = map[1];
            if (start > end) {
                Integer[] swap = new Integer[]{start, end};
                if (board.simulatePath(diceRolls, target, swap)) {
                    return "Ladder " + end + " " + start;
                }
            } else {
                Integer[] swap = new Integer[]{start, end};
                if (board.simulatePath(diceRolls, target, swap)) {
                    return "Snake " + start + " " + end;
                }
            }
        }
        return "Not reachable";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = Integer.parseInt(scanner.nextLine());
        List<int[]> mappings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            mappings.add(new int[]{start, end});
        }
        scanner.nextLine();
        String[] diceInput = scanner.nextLine().split(" ");
        List<Integer> diceRolls = new ArrayList<>();
        for (String roll : diceInput) {
            diceRolls.add(Integer.parseInt(roll));
        }
        int target = Integer.parseInt(scanner.nextLine());
        scanner.close();
        
        System.out.println(findFaultySnakeOrLadder(n, mappings, diceRolls, target));
    }
}
