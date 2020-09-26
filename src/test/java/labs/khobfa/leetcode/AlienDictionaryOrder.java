package labs.khobfa.leetcode;

import java.util.*;

public class AlienDictionaryOrder {

    public String alienOrder(String[] words) {
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> counts = new HashMap<>();

        for(String word : words) {
            for(char c : word.toCharArray()) {
                counts.put(c, 0);
                graph.put(c, new ArrayList<>());
            }
        }

        // find all edges
        for (int i = 0; i < words.length-1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];

            // check that word2 is not a prefix of word1
            if(word1.length() > word2.length() && word1.startsWith(word2))
                return "";

            // find the first non match and insert the corresponding relation
            for(int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if(word1.charAt(j) != word2.charAt(j)) {
                    graph.get(word1.charAt(j)).add(word2.charAt(j));
                    counts.put(word2.charAt(j), counts.get(word2.charAt(j)) + 1);
                    break;
                }
            }
        }

        // step 2: Breadth first search
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        for (char c : counts.keySet()) {
            if(counts.get(c).equals(0)) {
                queue.add(c);
            }
        }

        while (!queue.isEmpty()) {
            char c = queue.remove();
            sb.append(c);
            for (char next : graph.get(c)) {
                counts.put(next, counts.get(next)-1);
                if(counts.get(next).equals(0))
                    queue.add(next);
            }
        }

        if (sb.length() < counts.size()) return "";

        return sb.toString();
    }

}
