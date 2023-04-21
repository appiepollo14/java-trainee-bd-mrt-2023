package nl.avasten.H14;

import java.util.*;

public class Concordance {

  public void createConcordance(String inputString) {

    Map<Character, List<Integer>> stringListMap = new HashMap<>();

    inputString = inputString.replaceAll("\\s", "");
    char[] characters = inputString.toCharArray();

    for (int i = 0; i < characters.length; i++) {
      char c = characters[i];
      if (stringListMap.containsKey(c)) {
        List<Integer> currentList = stringListMap.get(c);
        currentList.add(i);
      } else {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(i);
        stringListMap.put(c, integerList);
      }
    }

    System.out.println(stringListMap);
  }
}
