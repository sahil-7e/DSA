class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        return Math.max(
            maxSum(nums, firstLen, secondLen),
            maxSum(nums, secondLen, firstLen)
        );
    }

    private int maxSum(int[] nums, int L, int M) {
        int sumL = 0;
        int sumM = 0;
        int maxL = 0;
        int result = 0;

        for (int i = 0; i < L + M; i++) {
            if (i < L) {
                sumL += nums[i];
            } else {
                sumM += nums[i];
            }
        }

        maxL = sumL;
        result = sumL + sumM;

        for (int i = L + M; i < nums.length; i++) {
            sumL += nums[i - M] - nums[i - M - L];
            sumM += nums[i] - nums[i - M];

            maxL = Math.max(maxL, sumL);
            result = Math.max(result, maxL + sumM);
        }

        return result;
    }
}