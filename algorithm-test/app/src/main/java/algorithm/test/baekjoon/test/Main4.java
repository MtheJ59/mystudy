package algorithm.test.baekjoon.test;

import java.util.Scanner;

public class Main4 {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int x = sc.nextInt();
    int y = sc.nextInt();

    // 좌표가 모두 양수이면 제1사분면
    // 좌표 x가 음수 y가 양수이면 제2사분면
    // 좌표 x가 양수 y가 음수이면 제4사분면
    // 좌표가 모두 음수이면 제3사분면
    // x,y 값에 대한 사분면 하나를 출력

    if (x > 0 && y > 0) {
      System.out.println("1");
    }
    if (x > 0 && y < 0) {
      System.out.println("4");
    }
    if (x < 0 && y > 0) {
      System.out.println("2");
    }
    if (x < 0 && y < 0) {
      System.out.println("3");
    }

  }

}


