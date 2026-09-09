import java.util.*;

class Solution {
    public String entityParser(String text) {
        Map<String, String> map = new HashMap<>();

        map.put("&quot;", "\"");
        map.put("&apos;", "'");
        map.put("&amp;", "&");
        map.put("&gt;", ">");
        map.put("&lt;", "<");
        map.put("&frasl;", "/");

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != '&') {
                result.append(text.charAt(i));
                continue;
            }

            int j = i;

            while (j < text.length() && text.charAt(j) != ';' && j - i <= 6) {
                j++;
            }

            if (j < text.length() && text.charAt(j) == ';') {
                String entity = text.substring(i, j + 1);

                if (map.containsKey(entity)) {
                    result.append(map.get(entity));
                    i = j;
                    continue;
                }
            }

            result.append('&');
        }

        return result.toString();
    }
}