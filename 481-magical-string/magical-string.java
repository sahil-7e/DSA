class Solution {
    public int magicalString(int n) {

        if (n <= 0) return 0;
        if (n <= 3) return 1;

        StringBuilder s = new StringBuilder("122");

        int i = 2;
        int num = 1;
        int count = 1;   // number of 1s

        while (s.length() < n) {

            int times = s.charAt(i) - '0';

            for (int j = 0; j < times; j++) {
                s.append(num);

                if (num == 1 && s.length() <= n) {
                    count++;
                }

                if (s.length() == n) {
                    break;
                }
            }

            num = 3 - num;  // 1 -> 2, 2 -> 1
            i++;
        }

        return count;
    }
}