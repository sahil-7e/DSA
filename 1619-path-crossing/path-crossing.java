import java.util.*;

class Solution {
    public boolean isPathCrossing(String path) {
        Set<String> visited = new HashSet<>();

        int x = 0;
        int y = 0;

        visited.add("0,0");

        for (char c : path.toCharArray()) {
            if (c == 'N') {
                y++;
            } else if (c == 'S') {
                y--;
            } else if (c == 'E') {
                x++;
            } else {
                x--;
            }

            String position = x + "," + y;

            if (!visited.add(position)) {
                return true;
            }
        }

        return false;
    }
}