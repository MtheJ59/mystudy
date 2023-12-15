package algorithm.test.baekjoon.level01.exam09;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    // a,b,c(1 <= a, b, c <= 10^12)이 공백을 사이에 두고 주어진다.
    // int의 최대 값은 2,147,483,647 이기 때문에 10^12승인
    // 10,000,000,000,000의 값을 담기엔 정수 int 최대 값이 작기에
    // long을 사용한다.
    long a = sc.nextLong();
    long b = sc.nextLong();
    long c = sc.nextLong();

    System.out.println((a) + (b) + (c));
  }

}
