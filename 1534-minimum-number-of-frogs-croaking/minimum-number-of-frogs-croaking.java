class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {

        int[] count = new int[5];

        int frogs = 0;
        int maxFrogs = 0;

        for (char c : croakOfFrogs.toCharArray()) {

            int index = "croak".indexOf(c);

            if (index == 0) {
                // New frog starts croaking
                count[0]++;
                frogs++;

                maxFrogs = Math.max(maxFrogs, frogs);
            } 
            else {
                // Previous character must exist
                if (count[index - 1] == 0) {
                    return -1;
                }

                count[index - 1]--;
                count[index]++;

                // Frog finished "croak"
                if (index == 4) {
                    count[4]--;
                    frogs--;
                }
            }
        }

        // All frogs must finish "croak"
        if (frogs != 0) {
            return -1;
        }

        return maxFrogs;
    }
}