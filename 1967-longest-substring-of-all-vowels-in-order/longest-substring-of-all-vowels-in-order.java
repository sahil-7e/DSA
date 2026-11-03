class Solution {
    public int longestBeautifulSubstring(String word) {
        int max = 0;
        int count = 1;
        int unique = 1;

        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) >= word.charAt(i - 1)) {
                if (word.charAt(i) > word.charAt(i - 1)) {
                    unique++;
                }

                count++;
            } else {
                count = 1;
                unique = 1;
            }

            if (unique == 5) {
                max = Math.max(max, count);
            }
        }

        return max;
    }
}