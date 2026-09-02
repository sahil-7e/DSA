class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        long[] sums = new long[n * (n + 1) / 2];
        int index = 0;

        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                sums[index++] = sum;
            }
        }

        Arrays.sort(sums);

        long ans = 0;
        int mod = 1_000_000_007;

        for (int i = left - 1; i < right; i++) {
            ans = (ans + sums[i]) % mod;
        }

        return (int) ans;
    }
}