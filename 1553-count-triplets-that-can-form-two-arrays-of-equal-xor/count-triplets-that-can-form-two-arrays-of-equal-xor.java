import java.util.*;

class Solution {
    public int countTriplets(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> sum = new HashMap<>();

        int prefixXor = 0;
        int ans = 0;

        // Prefix XOR = 0 at index 0
        count.put(0, 1);
        sum.put(0, 0);

        for (int k = 0; k < arr.length; k++) {
            prefixXor ^= arr[k];

            if (count.containsKey(prefixXor)) {
                ans += count.get(prefixXor) * k - sum.get(prefixXor);
            }

            count.put(prefixXor, count.getOrDefault(prefixXor, 0) + 1);
            sum.put(prefixXor, sum.getOrDefault(prefixXor, 0) + k + 1);
        }

        return ans;
    }
}