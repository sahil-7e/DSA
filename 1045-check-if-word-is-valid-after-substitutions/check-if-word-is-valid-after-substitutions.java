class Solution {
    public boolean isValid(String s) {

        StringBuilder stack = new StringBuilder();

        for (char c : s.toCharArray()) {

            stack.append(c);

            if (c == 'c') {

                int n = stack.length();

                if (n < 3 ||
                    stack.charAt(n - 3) != 'a' ||
                    stack.charAt(n - 2) != 'b') {

                    return false;
                }

    
                stack.delete(n - 3, n);
            }
        }

        return stack.length() == 0;
    }
}