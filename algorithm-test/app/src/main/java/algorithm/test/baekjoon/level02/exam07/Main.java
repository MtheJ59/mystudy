package algorithm.test.baekjoon.level02.exam07;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();

    if (a != b && a != c && b != c) { // 값이 다 다르다면
      int good;
      if (a > b) {
        if (c > a) { // c > a > b 라면
          good = c;
        } else { // a 가 제일 크다면
          good = a;
        }
      } else {
        if (c > b) { // c > b > a 라면
          good = c;
        } else { // b > c > a 라면
          good = b;
        }
      }
      System.out.println(good * 100);
    } else {
      if (a == b && a == c) { // a,b,c의 값이 같다면
        System.out.println(10000 + a * 1000);
      } else {
        if (a == b || a == c) { // a가 b나 c 둘중 하나랑 같다면
          System.out.println(1000 + a * 100);
        } else { // b와 c가 같을 경우
          System.out.println(1000 + b * 100);
        }
      }
    }
  }
}

