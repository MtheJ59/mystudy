package algorithm.test.baekjoon.test;

import java.util.Scanner;

public class Main07 {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();

    int A = a;
    int B = b;
    int C = c;

    if (a > b) {
      System.out.println(A * 100);
    } else if (a < b) {
      System.out.println(B * 100);
    } else if (b < c) {
      System.out.println(C * 100);
    }

    if (a == b || a == c || c == b) {
      System.out.println(A * 1000 + 10000);
      if (a == b && a != c) {
        if (a == c && b != c) {
          System.out.println(A * 100 + 1000);
        } else if (b == c && a != b) {
          System.out.println(B * 100 + 1000);
        } else {
          System.out.println(C * 100 + 1000);
        }
      }
    }
  }
}


