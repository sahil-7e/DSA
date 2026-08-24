class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {

        int i = arr1.length - 1;
        int j = arr2.length - 1;

        ArrayList<Integer> list = new ArrayList<>();

        int carry = 0;

        while (i >= 0 || j >= 0 || carry != 0) {

            int sum = carry;

            if (i >= 0) {
                sum += arr1[i--];
            }

            if (j >= 0) {
                sum += arr2[j--];
            }

            // Make remainder either 0 or 1
            int bit = sum & 1;

            list.add(bit);

            // Division by -2
            carry = (sum - bit) / -2;
        }

        // Remove leading zeros
        while (list.size() > 1 &&
               list.get(list.size() - 1) == 0) {
            list.remove(list.size() - 1);
        }

        // Reverse
        int[] ans = new int[list.size()];

        for (int k = 0; k < list.size(); k++) {
            ans[k] = list.get(list.size() - 1 - k);
        }

        return ans;
    }
}