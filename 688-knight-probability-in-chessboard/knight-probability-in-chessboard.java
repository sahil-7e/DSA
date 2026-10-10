class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        int[][] moves = {
            {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
            {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
        };

        double[][] dp = new double[n][n];
        dp[row][column] = 1.0;

        for (int step = 0; step < k; step++) {
            double[][] next = new double[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dp[i][j] == 0.0) {
                        continue;
                    }

                    for (int[] move : moves) {
                        int x = i + move[0];
                        int y = j + move[1];

                        if (x >= 0 && x < n && y >= 0 && y < n) {
                            next[x][y] += dp[i][j] / 8.0;
                        }
                    }
                }
            }

            dp = next;
        }

        double probability = 0.0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                probability += dp[i][j];
            }
        }

        return probability;
    }
}