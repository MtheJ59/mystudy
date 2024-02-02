package algorithm.test.baekjoon.level03.exam06;

import java.util.Scanner;

public class test {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int prod = 0;
    float d = n;

    for (int i = 1; i <= n; i++) {
      d /= i;
      prod++;
      if ((int) d <= 1) {
        System.out.print(prod);
        break;
      }
    }
  }
}

