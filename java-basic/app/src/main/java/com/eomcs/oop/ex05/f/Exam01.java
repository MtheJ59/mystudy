// 상속 - 클래스 로딩과 인스턴스 생성 과정
package com.eomcs.oop.ex05.f;

public class Exam01 {
  public static void main(String[] args) {
    // B 클래스의 설계도에 따라 Heap 영역에 변수를 준비한다.
    // - B 클래스는 A 클래스에 기능을 덧붙인 것이라 선언했기 때문에
    // A 클래스의 설계도에 따라 A 클래스에 선언된 인스턴스 변수도 함께 생성된다.
    B obj = new B();

    obj.v1 = 100; // A 클래스 설계도에 따라 만든 변수
    obj.v2 = 200; // B 클래스 설계도에 따라 만든 변수

    System.out.printf("v2=%d, v1=%d\n", obj.v2, obj.v1);
    System.out.println("---------------------------------");

    // 클래스는 오직 한 번만 로딩된다.
    // - 그래서 static 블록도 위에서 한 번 실행되면 다시 실행하지 않는다.
    //
    B obj2 = new B();
    obj2.v1 = 1000;
    obj2.v2 = 2000;
    System.out.printf("v2=%d, v1=%d\n", obj2.v2, obj2.v1);
    System.out.println("---------------------------------");

    C obj3 = new C();
    obj3.v1 = 10000;
    obj3.v3 = 20000;
    System.out.printf("v3=%d, v1=%d\n", obj3.v3, obj3.v1);

    // B 클래스의 인스턴스 생성 과정
    // 1) B의 수퍼 클래스가 로딩되어 있지 않다면, 수퍼 클래스(A 클래스)를 먼저 로딩한다.
    // - 스태틱 필드 생성한 후
    // - 스태틱 블록 실행한다.
    // 2) 그런 후 B 클래스를 로딩한다.
    // - 스태틱 필드 생성한 후
    // - 스태틱 블록 실행한다.
    // 3) 인스턴스 필드 생성
    // - 수퍼 클래스의 인스턴스 필드부터 생성한다.
    // v1 | v2 : A의 v1 필드 생성, B의 v2 필드 생성
    // 0 | 0 : 각 필드를 기본 값으로 설정한다.
    // 100 | 0 : A 클래스의 생성자 수행
    // 100 | 200 : B 클래스의 생성자 수행
    //
    // - B 클래스의 인스턴스는 수퍼 클래스의 인스턴스 필드도 포함한다.
    //

    // 인스턴스 생성 절차 정리!
    // 1) 상속 받은 수퍼 클래스를 먼저 메모리에 로딩한다.
    // 이미 로딩되어 있다면 다시 로딩하지는 않는다.
    // 2) 그런 후 해당 클래스를 메모리에 로딩한다.
    // 마찬가지로 이미 로딩되어 있다면 다시 로딩하지는 않는다.
    // 3) 수퍼 클래스에 선언된 대로 인스턴스 변수를 Heap에 만든다.
    // 4) 해당 클래스에 선언된 대로 인스턴스 변수를 Heap에 만든다.
    // 5) 수퍼 클래스부터 생성자를 실행하며 해당 클래스까지 내려온다.
    // => 호출은 해당 클래스부터 수퍼 클래스로 따라 올라간다.

    // 그래서 인스턴스를 생성할 때는 항상 상속 받아야 하는 클래스 파일이 모두 있어야 한다.
    // 테스트 하는 방법?
    // => A.class 파일을 제거하고 실행해 보라!

  }
}

// 용어 정리!
// 상속(inheritance)
// - 기존에 만든 클래스를 자신의 코드처럼 사용하는 기법이다.
// - 보통 기존 코드를 손대지 않고 새 코드를 덧붙일 때 많이 사용한다.
//
// 수퍼클래스(super class) = 부모클래스(parents class)
// - B 클래스 입장에서, B 클래스에게 상속 해주는 A 클래스를 말한다.
//
// 서브클래스(sub class) = 자식클래스(child class)
// - A 클래스 입장에서, A 클래스가 상속해주는 B 클래스를 말한다.
//
// 즉 수퍼 클래스나 서브 클래스는 상대적인 개념이다.


