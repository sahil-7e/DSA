
import java.util.*;

class Solution {

    public List<String> braceExpansionII(String expression) {
        Set<String> result = dfs(expression);

        List<String> list = new ArrayList<>(result);
        Collections.sort(list);

        return list;
    }

    private Set<String> dfs(String s) {

        Set<String> result = new HashSet<>();
        result.add("");

        int i = 0;

        while (i < s.length()) {

            Set<String> current = new HashSet<>();

            if (s.charAt(i) == '{') {

                int start = i + 1;
                int count = 1;
                i++;

                while (count > 0) {
                    if (s.charAt(i) == '{') count++;
                    if (s.charAt(i) == '}') count--;
                    i++;
                }

                String inside = s.substring(start, i - 1);

                current = new HashSet<>();

                for (String part : split(inside)) {
                    current.addAll(dfs(part));
                }

            } else {

                current.add(String.valueOf(s.charAt(i)));
                i++;
            }

            // Cartesian product (concatenation)
            Set<String> temp = new HashSet<>();

            for (String a : result) {
                for (String b : current) {
                    temp.add(a + b);
                }
            }

            result = temp;
        }

        return result;
    }

    private List<String> split(String s) {

        List<String> parts = new ArrayList<>();

        int start = 0;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '{') count++;
            else if (s.charAt(i) == '}') count--;

            else if (s.charAt(i) == ',' && count == 0) {
                parts.add(s.substring(start, i));
                start = i + 1;
            }
        }

        parts.add(s.substring(start));

        return parts;
    }
}
