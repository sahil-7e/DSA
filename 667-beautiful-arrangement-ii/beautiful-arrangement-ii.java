class Solution {
    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        int left = 1;
        int right = n;
        int i = 0;

        while (left <= right) {
            if (k > 1) {
                if (k % 2 == 1) {
                    ans[i++] = left++;
                } else {
                    ans[i++] = right--;
                }
                k--;
            } else {
                ans[i++] = left++;
            }
        }

        return ans;
    }
}