package com.eomcs.oop.ex02.step07.util;

// 다른 패키지에서 이 클래스와 멤버(필드 및 메소드)를 접근할 수 있도록
// public 으로 공개한다.
//
public class Calculator {

  public int result = 0; // 인스턴스 필드 이다. 변수를 만들라는 지시
                         // Heap 에 변수를 만들어 저장한다.

  public void plus(int value) {

    this.result += value;
  }

  public void minus(int value) {
    this.result -= value;
  }

  public void multiple(int value) {
    this.result *= value;
  }

  public void divide(int value) {
    this.result /= value;
  }

  // 다음 메소드는 result 변수를 사요하지 않기 때문에
  // Calculator의 인스턴스 주소를 받을 필요가 없다.
  public static int abs(int a) {
    // 스태틱 메소드는 this라는 내장 변수가 없다.
    return a >= 0 ? a : a * -1;
  }
}
