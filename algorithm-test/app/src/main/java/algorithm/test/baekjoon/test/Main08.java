package algorithm.test.baekjoon.test;

import java.util.Scanner;

public class Main08 {
  public static void main(String[] args) {
    // 여기에 코드를 작성해주세요.
    Scanner sc = new Scanner(System.in);
    sc.useDelimiter("-");
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();

    System.out.printf("0%s-%s-%s", a, c, b);
  }
}