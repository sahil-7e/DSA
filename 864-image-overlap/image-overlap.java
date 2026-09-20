import java.util.*;

class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;

        List<int[]> a = new ArrayList<>();
        List<int[]> b = new ArrayList<>();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (img1[r][c] == 1) {
                    a.add(new int[]{r, c});
                }

                if (img2[r][c] == 1) {
                    b.add(new int[]{r, c});
                }
            }
        }

        Map<String, Integer> count = new HashMap<>();
        int answer = 0;

        for (int[] p1 : a) {
            for (int[] p2 : b) {
                int dr = p2[0] - p1[0];
                int dc = p2[1] - p1[1];

                String key = dr + "," + dc;

                int current = count.getOrDefault(key, 0) + 1;
                count.put(key, current);

                answer = Math.max(answer, current);
            }
        }

        return answer;
    }
}