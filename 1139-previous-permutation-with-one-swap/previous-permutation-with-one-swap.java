class Solution {
    public int[] prevPermOpt1(int[] arr) {
        int i = arr.length - 2;

        while (i >= 0 && arr[i] <= arr[i + 1]) {
            i--;
        }

        if (i < 0) {
            return arr;
        }

        int j = arr.length - 1;

        while (arr[j] >= arr[i] || (j > i + 1 && arr[j] == arr[j - 1])) {
            j--;
        }

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        return arr;
    }
}