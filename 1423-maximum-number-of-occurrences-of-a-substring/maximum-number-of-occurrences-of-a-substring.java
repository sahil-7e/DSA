
import java.util.*;

class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {

        Map<String, Integer> map = new HashMap<>();

        int n = s.length();
        int result = 0;

        for (int i = 0; i <= n - minSize; i++) {

            String sub = s.substring(i, i + minSize);

            // Count distinct characters
            Set<Character> set = new HashSet<>();

            for (char c : sub.toCharArray()) {
                set.add(c);
            }

            if (set.size() <= maxLetters) {

                int count = map.getOrDefault(sub, 0) + 1;

                map.put(sub, count);

                result = Math.max(result, count);
            }
        }

        return result;
    }
}
