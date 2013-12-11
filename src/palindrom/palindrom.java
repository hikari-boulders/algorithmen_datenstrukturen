package palindrom;

public class palindrom {

  public static void main(String[] args) {
    palindrom("maoooam");

  }

  public static boolean palindrom(String s) {

    if (s.length() < 2) {
      System.out.print(true);
      return true;
    }

    if (s.charAt(0) == s.charAt(s.length() - 1)) {
      palindrom(s.substring(1, s.length() - 1));
    } else {
      System.out.print(false);
      return false;
    }
    return false;

  }

}
