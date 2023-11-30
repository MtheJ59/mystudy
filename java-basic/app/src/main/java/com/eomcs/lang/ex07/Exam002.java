package com.eomcs.lang.ex07;

import java.util.Scanner;

// # 메서드 : 사용 전
//
public class Exam002 {

  static void printSpaces(int len) {
    int spaceCnt = 1;
    while (spaceCnt <= len) {
      System.out.print(" ");
      spaceCnt++;
    }
  }

  static void printStar(int len) {
    int starCnt = 1;
    while (starCnt <= len) {
      System.out.print("*");
      starCnt++;
    }
  }

  static int computeSpaceLenght(int len, int starLen) {
    return (len - starLen) / 2;
  }

  static int promptInt(String title) {
    Scanner keyScan = new Scanner(System.in);
    System.out.print(title);
    int len = keyScan.nextInt();
    keyScan.close();

    return len;
  }

  public static void main(String[] args) {
    int len = promptInt("밑변의 길이? ");


    for (int starLen = 1; starLen <= len; starLen += 2) {

      printSpaces(computeSpaceLenght(len, starLen));
      printStar(starLen);
      System.out.println();

    }
  }
}
