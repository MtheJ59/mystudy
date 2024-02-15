package codetree;

import java.util.Scanner;

public class Main09 {
  public static void main(String[] args) {
    // 여기에 코드를 작성해주세요.

    Scanner sc = new Scanner(System.in);

    int x;
    int y;
    String e;

    while (true) {
      x = sc.nextInt();
      y = sc.nextInt();
      e = sc.next();

      if (!e.equals("C")) {
        System.out.println(x * y);
      } else {
        System.out.println(x * y);
        break;
      }
    }
    sc.close();
  }
}
