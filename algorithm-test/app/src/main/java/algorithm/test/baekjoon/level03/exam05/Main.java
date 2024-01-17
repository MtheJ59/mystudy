package algorithm.test.baekjoon.level03.exam05;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    String L = "";

    for (int i = 1; i <= (N / 4); i++) {
      L += "long ";
    }
    System.out.println(L + "int");
  }
}
