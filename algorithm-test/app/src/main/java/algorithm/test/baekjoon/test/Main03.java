package algorithm.test.baekjoon.test;

import java.util.Scanner;

public class Main03 {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();

    // 윤년이면 1 아니면 0을 출력
    // 윤년은 4의 배수이면서 100의 배수가 아니면서 400의 배수 일 때
    // 예로 2012년은 4의 배수이면서 100의 배수가 아니라서 윤년
    // 1900년은 100의 배수이고 400의 배수는 아니라서 윤년이 아님
    // 2000년은 400의 배수여서 윤년

    if (a % 4 == 0) {
      if (a % 400 == 0)
        System.out.println("1");
      else if (a % 100 == 0)
        System.out.println("0");
      else
        System.out.println("1");
    } else
      System.out.println("0");

  }

}


