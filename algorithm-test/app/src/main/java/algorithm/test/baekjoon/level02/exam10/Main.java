package algorithm.test.baekjoon.level02.exam10;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();

    // 주사위의 숫자가 다 다를때
    if (a != b && a != c && b != c) {
      if (a > b && a > c) {
        System.out.println(a * 100);
      } else if (b > a && b > c) {
        System.out.println(b * 100);
      } else if (c > a && c > b) {
        System.out.println(c * 100);
      }
    } else if (a == b && a == c && b == c) {
      System.out.println(10000 + (a * 1000));
    } else if (a != b) {
      if (a > b) {
        System.out.println(1000 + (c * 100));
      } else {
        System.out.println(1000 + (c * 100));
      }
    } else if (a != c) {
      if (a > c) {
        System.out.println(1000 + (b * 100));
      } else {
        System.out.println(1000 + (b * 100));
      }
    } else if (b != c) {
      if (b > c) {
        System.out.println(1000 + (a * 100));
      } else {
        System.out.println(1000 + (a * 100));
      }
    }
  }
}

