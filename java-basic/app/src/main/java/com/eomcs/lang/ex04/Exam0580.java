package com.eomcs.lang.ex04;

// # 배열 - 배열 인스턴스와 가비지
//
public class Exam0580 {
  public static void main(String[] args) {

    int[] arr1;
    arr1 = new int[5];
    arr1[0] = 100;

    // 레퍼런스에 다른 배열 인스턴스의 주소를 담을 수 있다.
    arr1 = new int[] {200, 200, 200};
    // 주의!
    // - arr1이 보관하고 있던 주소는 잃어버렸기 때문에 이전 배열 인스턴스는 사용할 수 없다.
    // - 이렇게 주소를 잃어버려 사용할 수 없는 인스턴스(메모리)를 '가비지(garbage)'라 부른다.
    //

    // 새 배열 인스턴스의 값 출력하기
    System.out.println(arr1[0]);
  }
}

// ## 가비지(garbage)
// - 주소를 잃어 버려 사용할 수 없는 메모리
// - 특정 조건이 되면 가비지 수집기(garbage collector)에 의해 메모리 해제된다.
// 메모리 해제? 다른 용도로 사용할 수 있도록 표시한다는 의미다.
//
// ## 가비지 수집 조건 = 가비지 컬렉터가 동작할 때
// - 메모리가 부족할 때
// - 운영체제로부터 메모리를 추가로 받기 전에 먼저 기존에 사용하던 메모리에서
// 가비지를 제거한다.
// - CPU가 한가할 때
// - 24시간 365일 내내 실행하는 서버 프로그램인 경우, 실행 중간에 CPU가 한가할 때
// 가비지를 제거한다.
// - 주의!
// - 프로그램(JVM)을 종료하면 JVM 사용한 메모리를 운영체제가 모두 회수한다.
//
// ## 가비지를 강제로 지우도록 명령하는 방법?
// - 자바는 없다!
// - C 언어 => free(메모리주소);
// - C++ 언어 => delete 객체주소;
// - 요즘 언어의 트랜드는 사용하지 않는 메모리를 개발자가 직접 해제하는 것이 아니라
// VM이 해제하는 것이다.
// 예) JavaScript, C#, Python, PHP, Go, Java 등
// - 요즘 언어의 트랜드는 VM으로 실행하는 것이다.
// 왜? 직접 기계어로 전환되면 메모리를 관리를 자동으로 수행할 수 없다.
//
// ## 가비지 컬렉터를 강제로 실행하는 방법?
// - 없다!
// - 단 원래 계획보다 가능한 빨리 실행하라고 독촉하는 방법은 있다.
// System.gc() 메서드 호출
// - 그런데 바로 실행할 지 나중에 실행할 지 그 시점을 보장하지는 않는다.
