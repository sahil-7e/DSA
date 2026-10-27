class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] freq = new int[k];

        for (int num : arr) {
            int rem = ((num % k) + k) % k;
            freq[rem]++;
        }

        if (freq[0] % 2 != 0) {
            return false;
        }

        for (int r = 1; r <= k / 2; r++) {
            if (r == k - r) {
                if (freq[r] % 2 != 0) {
                    return false;
                }
            } else if (freq[r] != freq[k - r]) {
                return false;
            }
        }

        return true;
    }
}