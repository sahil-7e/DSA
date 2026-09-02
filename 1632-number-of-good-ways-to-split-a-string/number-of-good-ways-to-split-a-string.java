class Solution {
    public int numSplits(String s) {
        int[] left = new int[26];
        int[] right = new int[26];

        int rightDistinct = 0;
        for (char c : s.toCharArray()) {
            if (right[c - 'a']++ == 0) {
                rightDistinct++;
            }
        }

        int leftDistinct = 0;
        int ans = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            int index = s.charAt(i) - 'a';

            if (left[index]++ == 0) {
                leftDistinct++;
            }

            if (--right[index] == 0) {
                rightDistinct--;
            }

            if (leftDistinct == rightDistinct) {
                ans++;
            }
        }

        return ans;
    }
}