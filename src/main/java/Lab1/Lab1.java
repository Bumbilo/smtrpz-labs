package Lab1;

import java.util.*;

public class Lab1 {

    public String minString(String words) {
        if (words == null || words.isEmpty()) {
            throw new IllegalArgumentException("No words");
        }
        String[] arrayOfStrings = words.split(" ");
        HashMap<Integer, List<String>> countStringMap = new HashMap<>();

        for (String word : arrayOfStrings) {
            HashSet<Character> uniqueChars = new HashSet<>();

            for (char ch : word.toCharArray()) {
                uniqueChars.add(ch);
            }

            Integer size = uniqueChars.size();
            List<String> list = countStringMap.getOrDefault(size, new ArrayList<>());
            list.add(word);
            countStringMap.put(size, list);
        }

        Optional<Integer> minValue = countStringMap.keySet().stream().min(Integer::compare);

        return countStringMap.get(minValue.get()).get(0);
    }
}
