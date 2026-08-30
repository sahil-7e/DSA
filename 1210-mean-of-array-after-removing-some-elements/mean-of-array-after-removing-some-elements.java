class Solution {
    public double trimMean(int[] arr) {

        Arrays.sort(arr);

        int remove = arr.length / 20; // 5%

        int sum = 0;

        for (int i = remove; i < arr.length - remove; i++) {
            sum += arr[i];
        }

        int count = arr.length - 2 * remove;

        return (double) sum / count;
    }
}