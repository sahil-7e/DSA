import java.util.*;

class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] wordFreq = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            wordFreq[i] = smallestFreq(words[i]);
        }

        Arrays.sort(wordFreq);

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int freq = smallestFreq(queries[i]);

            // Find first word frequency strictly greater than freq
            int index = upperBound(wordFreq, freq);

            ans[i] = wordFreq.length - index;
        }

        return ans;
    }

    private int smallestFreq(String s) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int count : freq) {
            if (count > 0) {
                return count;
            }
        }

        return 0;
    }

    private int upperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}