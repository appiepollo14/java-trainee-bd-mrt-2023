package nl.avasten.H14;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StringCounter {

  private Map<String, Integer> stringIntegerMap = new HashMap<>();

  public int countString(String string) {

    if (!stringIntegerMap.containsKey(string)) {
      Set<Character> characterSet = new HashSet<>();
      char[] chars = string.toCharArray();

      for (Character c : chars) {
        characterSet.add(c);
      }

      int qtyOfUniqueCharsInString = characterSet.size();
      stringIntegerMap.put(string, qtyOfUniqueCharsInString);

      return qtyOfUniqueCharsInString;
    }
    return stringIntegerMap.get(string);
  }
}
