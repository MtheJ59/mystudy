package codetree;

import java.util.Scanner;

public class Main5 {
  public static void main(String[] args) {
    // 두 자연수를 받아 a / b 의 결과를 소수점 20째까지 출력하는 프로그램

    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();
    int b = sc.nextInt();

    System.out.print(a / b + ".");

    a %= b;
    for (int i = 0; i < 20; i++) {
      a *= 10;
      System.out.print(a / b);

      a %= b;
    }
  }
}
