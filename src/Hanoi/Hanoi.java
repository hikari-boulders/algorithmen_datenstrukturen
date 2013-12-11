package Hanoi;

public class Hanoi {

  static int schritte = 0;

  public static void main(String[] args) {
    solveHanoi(4);
  }

  public static void solveHanoi(int scheiben) {

    if (scheiben == 0) {
      System.out.print("Bitte mindetens eine Scheibe mitgeben!");
    }

    move(scheiben, "a", "b", "c");
    System.out.print("Es werden " + schritte + " Schritte benötigt");
  }

  public static void move(int n, String source, String temp, String destination) {
    schritte = schritte + 1;
    if (n == 1) {
      System.out.println("Bewege Scheiben von " + source + " nach "
          + destination);
    } else {
      move(n - 1, source, destination, temp);
      System.out.println("Bewege Scheiben von " + source + " nach "
          + destination);

      move(n - 1, temp, source, destination);
    }
  }

}
