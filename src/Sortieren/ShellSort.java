package Sortieren;

public class ShellSort {

  public static void main(String[] args) {
    int[] anArray;
    anArray = new int[20000];

    for (int i = 0; i < anArray.length; i++) {
      Double zahl = (Math.random() * anArray.length);
      anArray[i] = zahl.intValue();
    }

    // System.out.println("Array vor dem sortieren:");
    // arrayprintout(anArray);
    long time = 0;
    for (int i = 1; i < 1000; i++) {
      time = time + ShellSortAlgorithm(anArray, 16);
      if (i > 1) {
        time = time / 2;
      }
    }
    System.out.println("Dursch. Zeit:" + time);
    // H-Grösse und durchschnittliche Zeit bei einem 20000er int-array:
    // h = 2, T=203180
    // h = 4, T=180058
    // h = 8, T=196783
    // h = 128, T=344716
    // h = 1024, T=441202
    // h = 10000, T=577697
  }

  public static long ShellSortAlgorithm(int[] array, Integer hSequenz) {
    long before = System.nanoTime();
    int h = hSequenz;
    int e;
    int j;
    while (h > 0) {
      for (int i = 0; i < (array.length - h); i++) {
        e = array[i + h];
        j = i;
        while (j >= 0 && e < array[j]) {
          array[j + h] = array[j];
          j = j - h;
        }
        array[j + h] = e;
      }
      h = h / 2;
    }
    long after = System.nanoTime();
    long runningTime = (after - before);
    // System.out.println("Benötigte zeit (nano): " + runningTime);
    return runningTime;
  }

  public static void arrayprintout(int[] anArray) {
    for (int i = 0; i < anArray.length; i++) {
      System.out.print(anArray[i] + ", ");
    }
    System.out.println();
  }
}
