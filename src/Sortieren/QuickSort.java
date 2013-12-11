package Sortieren;

public class QuickSort {

  public static void main(String[] args) {
    int[] anArray;
    anArray = new int[50];

    for (int i = 0; i < anArray.length; i++) {
      Double zahl = (Math.random() * anArray.length);
      anArray[i] = zahl.intValue();
    }

    // System.out.println("Array vor dem sortieren:");
    arrayprintout(anArray);
    QuickSortAlgorithm(anArray, 0, anArray.length - 1);
    arrayprintout(anArray);

    // Die beste Laufzeit beträgt O(n log n). Dies hängt von einem guten
    // Pivot-Element ab. Am besten wird der der Median aller Werte genommen.
    // Die Schlechteste Laufzeit beträgt O(n^2). Dies passiert unter folgenden
    // Bedingungen:
    // - Das Pivotelement ist entweder das grösste oder kleinste Element, und
    // die Liste liegt bereits sortiert vor.
    //

  }

  private static void QuickSortAlgorithm(int[] array, int first, int last) {
    int x = array[(first + last) / 2];
    int i = first;
    int j = last;

    if (first < last) {
      // Array Splitten
      do {
        while (array[i] < x && i < last) {
          i = i + 1;
        }
        while (x < array[j] && j > first) {
          j = j - 1;
        }

        if (i <= j) {
          int temp = array[i];
          array[i] = array[j];
          array[j] = temp;
          i = i + 1;
          j = j - 1;
        }

      } while (i < j);

      QuickSortAlgorithm(array, first, j);
      QuickSortAlgorithm(array, i, last);

    }
  }

  public static void arrayprintout(int[] anArray) {
    for (int i = 0; i < anArray.length; i++) {
      System.out.print(anArray[i] + ", ");
    }
    System.out.println();
  }

}
