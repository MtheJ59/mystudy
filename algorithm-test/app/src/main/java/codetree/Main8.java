package codetree;

import java.util.Scanner;

public class Main8 {
  public static void main(String[] args) {
    // 여기에 코드를 작성해주세요.
    Scanner sc = new Scanner(System.in);
    int v = 0;
    int c = 0;

    while (true) {
      int n = sc.nextInt();        

      if (n % 2 == 0) {
        v = n / 2;
        c++;

      } else {
        continue;
      }
      System.out.println(v);
      if (c == 3) {
        break;
      }
    }
  }
}
