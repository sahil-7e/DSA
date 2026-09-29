class Solution {
    public int clumsy(int n) {
        int result = 0;
        int current = n;
        int op = 0;

        for (int i = n - 1; i >= 1; i--) {
            if (op == 0) {
                current *= i;
            } else if (op == 1) {
                current /= i;
            } else if (op == 2) {
                result += current;
                current = i;
            } else {
                result += current;
                current = -i;
            }

            op = (op + 1) % 4;
        }

        return result + current;
    }
}