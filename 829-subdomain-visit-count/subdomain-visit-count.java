import java.util.*;

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();

        for (String domain : cpdomains) {
            String[] parts = domain.split(" ");
            int count = Integer.parseInt(parts[0]);
            String d = parts[1];

            for (int i = 0; i < d.length(); i++) {
                if (d.charAt(i) == '.') {
                    String subdomain = d.substring(i + 1);
                    map.put(subdomain, map.getOrDefault(subdomain, 0) + count);
                }
            }

            map.put(d, map.getOrDefault(d, 0) + count);
        }

        List<String> result = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            result.add(entry.getValue() + " " + entry.getKey());
        }

        return result;
    }
}