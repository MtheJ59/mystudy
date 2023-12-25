package algorithm.test.baekjoon.test;

import java.util.Scanner;

public class Main5 {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int H = sc.nextInt();
    int M = sc.nextInt();

    // 입력받은 시간에서 + 45분 하여 출력하기
    // (0 <= H <= 23, 0 <= M <= 59)
    // 24시간 표현방식이며 0:0(자정) 23:59(다음날 자정 1분전)
    // 불필요한 0은 사용하지 않음

    if (M < 45) {
      H--;
      M = 60 - (45 - M);
      if (H < 0) {
        H = 23;
      }
      System.out.println(H + " " + M);
    } else {
      System.out.println((H + 24) % 24 + " " + (M - 45));
    }
  }

}


