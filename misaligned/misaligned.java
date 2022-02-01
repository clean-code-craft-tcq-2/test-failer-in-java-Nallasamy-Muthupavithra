class misaligned {

  static String majorColors[] = { "White", "Red", "Black", "Yellow", "Violet" };
  static String minorColors[] = { "Blue", "Orange", "Green", "Brown", "Slate" };

  static void printColorMap() {
    int i = 0, j = 0;
    for (i = 0; i < 5; i++) {
      for (j = 0; j < 5; j++) {
        System.out.println(formatColorPair(i, j));
      }
    }
  }

  private static String formatColorPair(final int i, final int j) {
    int pairNumber = formPairNumber(i, j);
    return pairNumber + "\t" + majorColors[i] + "\t" + minorColors[j] + "\n";
  }

  private static int formPairNumber(final int i, final int j) {
    return (i * 5) + j;
  }

  public static void main(final String[] args) {
    assert (24 == formPairNumber(4, 4));
    assert (formatColorPair(0, 0).equals("0\tWhite\tBlue"));
    
    printColorMap();
    System.out.println("All is well (maybe!)");
  }
}
