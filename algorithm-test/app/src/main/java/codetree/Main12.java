package codetree;

import java.util.Scanner;

public class Main12 {
  public static void main(String[] args) {
    // 여기에 코드를 작성해주세요.
    // 2의 거듭제곱수 중 하나인 n을 입력받아, n=2 x 를 만족하는 x 값을 구하는 코드를 작성해보세요.

    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int x = 1;

    while (true) {
      if (n / 2 == 1) {
        break;
      } else {
        x++;
        n = n / 2;
      }

    }
    System.out.print(x);
  }
}
