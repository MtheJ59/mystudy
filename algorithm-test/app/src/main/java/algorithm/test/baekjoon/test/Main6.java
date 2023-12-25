package algorithm.test.baekjoon.test;

import java.util.Scanner;

public class Main6 {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int H = sc.nextInt();
    int M = sc.nextInt();
    int O = sc.nextInt();

    int min = H * 60 + M;
    min = min + O;

    int hour = (min / 60) % 24;
    int minute = min % 60;

    System.out.println(hour);
    System.out.println(minute);

    System.out.println(hour + " " + minute);
  }
}

