import java.util.*;

class Solution {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        int n = favoriteCompanies.size();

        List<Set<String>> sets = new ArrayList<>();

        for (List<String> companies : favoriteCompanies) {
            sets.add(new HashSet<>(companies));
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            boolean isSubset = false;

            for (int j = 0; j < n; j++) {
                if (i == j || sets.get(j).size() < sets.get(i).size()) {
                    continue;
                }

                if (sets.get(j).containsAll(sets.get(i))) {
                    isSubset = true;
                    break;
                }
            }

            if (!isSubset) {
                ans.add(i);
            }
        }

        return ans;
    }
}