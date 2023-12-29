package algorithm.test.baekjoon.test;

import java.util.Scanner;

public class Main12 {
  public static void main(String[] args) {
    // 여기에 코드를 작성해주세요.

    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();

    if (a >= 80) {
      System.out.println("pass");
    } else {
      System.out.println((80 - a) + "more score");
    }
  }
}
