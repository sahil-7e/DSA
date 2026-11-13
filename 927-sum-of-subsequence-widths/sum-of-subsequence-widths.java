
import java.util.*;

class Solution {
    public int sumSubseqWidths(int[] nums) {

        Arrays.sort(nums);

        int n = nums.length;
        long mod = 1_000_000_007;

        long power = 1;
        long result = 0;

        for (int i = 0; i < n; i++) {

            long maxContribution = nums[i] * power;
            long minContribution = nums[n - 1 - i] * power;

            result = (result + maxContribution - minContribution) % mod;

            power = (power * 2) % mod;
        }

        return (int) ((result + mod) % mod);
    }
}
