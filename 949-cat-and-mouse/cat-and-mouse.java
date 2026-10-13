class Solution {
    public int catMouseGame(int[][] graph) {
        int n = graph.length;
        int[][][] color = new int[n][n][2];
        int[][][] degree = new int[n][n][2];

        for (int m = 0; m < n; m++) {
            for (int c = 1; c < n; c++) {
                degree[m][c][0] = graph[m].length;
                degree[m][c][1] = graph[c].length;

                for (int next : graph[c]) {
                    if (next == 0) {
                        degree[m][c][1]--;
                    }
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 1; i < n; i++) {
            for (int turn = 0; turn < 2; turn++) {
                color[0][i][turn] = 1;
                queue.offer(new int[]{0, i, turn, 1});

                color[i][i][turn] = 2;
                queue.offer(new int[]{i, i, turn, 2});
            }
        }

        while (!queue.isEmpty()) {
            int[] state = queue.poll();
            int m = state[0];
            int c = state[1];
            int turn = state[2];
            int result = state[3];

            for (int[] prev : getPreviousStates(graph, m, c, turn)) {
                int pm = prev[0];
                int pc = prev[1];
                int pt = prev[2];

                if (color[pm][pc][pt] != 0) {
                    continue;
                }

                boolean mouseTurn = pt == 0;

                if ((mouseTurn && result == 1) ||
                    (!mouseTurn && result == 2)) {
                    color[pm][pc][pt] = result;
                    queue.offer(new int[]{pm, pc, pt, result});
                } else {
                    degree[pm][pc][pt]--;

                    if (degree[pm][pc][pt] == 0) {
                        int winner = mouseTurn ? 2 : 1;
                        color[pm][pc][pt] = winner;
                        queue.offer(new int[]{pm, pc, pt, winner});
                    }
                }
            }
        }

        return color[1][2][0];
    }

    private List<int[]> getPreviousStates(int[][] graph, int m, int c, int turn) {
        List<int[]> states = new ArrayList<>();

        if (turn == 1) {
            for (int prevMouse : graph[m]) {
                states.add(new int[]{prevMouse, c, 0});
            }
        } else {
            for (int prevCat : graph[c]) {
                if (prevCat != 0) {
                    states.add(new int[]{m, prevCat, 1});
                }
            }
        }

        return states;
    }
}