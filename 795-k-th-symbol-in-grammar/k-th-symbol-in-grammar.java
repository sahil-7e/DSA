class Solution {
    public int kthGrammar(int n, int k) {
        int result = 0;

        while (k > 1) {
            int parent = (k + 1) / 2;

            if (k % 2 == 0) {
                result ^= 1;
            }

            k = parent;
        }

        return result;
    }
}