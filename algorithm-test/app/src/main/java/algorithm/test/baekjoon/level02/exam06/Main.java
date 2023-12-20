package algorithm.test.baekjoon.level02.exam06;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int A = sc.nextInt();
    int B = sc.nextInt();
    int C = sc.nextInt();

    int min = A * 60 + B;
    min = min + C;

    int hour = (min / 60) % 24;
    int minute = min % 60;

    System.out.println(hour + " " + minute);
  }
}


