import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class misaligned {

  static int printColorMap() {
    Map<Integer, String[]> colorPairsMap = getColorPairs();
    for (Entry<Integer, String[]> colorPairIterator : colorPairsMap.entrySet()) {
      String[] colorPair = colorPairIterator.getValue();
      System.out.printf("%d | %s | %s\n", colorPairIterator.getKey(), colorPair[0], colorPair[1]);
    }
    return colorPairsMap.size();
  }

  static Map<Integer, String[]> getColorPairs() {
    String majorColors[] = { "White", "Red", "Black", "Yellow", "Violet" };
    String minorColors[] = { "Blue", "Orange", "Green", "Brown", "Slate" };
    Map<Integer, String[]> colorPairs = new HashMap<>();
    String[] colorPair = new String[2];
    int i = 0;
    int j = 0;
    for (i = 0; i < 5; i++) {
      for (j = 0; j < 5; j++) {
        colorPair[0] = majorColors[i];
        colorPair[1] = minorColors[j];
        colorPairs.put((i * 5) + j, colorPair);
      }
    }
    return colorPairs;
  }

  public static void main(final String[] args) {
    int result = printColorMap();
    assert (result == 25);

    Map<Integer, String[]> colorPairsMap = getColorPairs();
    assert("White"==colorPairsMap.get(3)[0]);
    assert("Green"== colorPairsMap.get(3)[1]);

    System.out.println("All is well (maybe!)");
  }
}
