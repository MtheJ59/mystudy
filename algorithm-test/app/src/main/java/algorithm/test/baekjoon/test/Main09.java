package algorithm.test.baekjoon.test;

// import java.util.Scanner;
//
// public class Main9 {
// public static void main(String[] args) {
// // 여기에 코드를 작성해주세요.
//
// Scanner sc = new Scanner(System.in);
//
//
// int a = sc.nextInt();
// int b = sc.nextInt();
// double c = b / ((a * 0.01) * (a * 0.01));
// int d = (int) c;
//
//
// if (d >= 25) {
// System.out.println(d);
// System.out.println("Obesity");
// }
// }
// }
// 위 방식은 테스트에서 실패 함
// 514 333을 넣었을 때

import java.util.Scanner;

public class Main09 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int h, w;

    h = sc.nextInt();
    w = sc.nextInt();

    int bmi = w * 100 * 100 / (h * h);

    System.out.println(bmi);
    if (bmi >= 25)
      System.out.println("Obesity");
  }
}
