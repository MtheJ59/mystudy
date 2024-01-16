package com.eomcs.reflect.ex06.a;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Exam1211 {
  public static void main(String[] args) {

    Class<?> clazz = Exam1211.class;
    ClassLoader classLoader = clazz.getClassLoader();

    // 클래스 메소드가 아니라 컴파일을 통해 자동 생성되는 타입이다.
    // 즉, 변수이다.
    // 각 클래스들의 인터페이스에 대한 정보가 들어있다.
    Class<?> aType = A.class; // A 인터페이스의 정보 = A 타입 정보 = A의 타입
    Class<?> bType = B.class; // B 인터페이스의 정보 = B 타입 정보 = B의 타입
    Class<?> cType = C.class; // C 인터페이스의 정보 = C 타입 정보 = C의 타입

    Class<?>[] interfaceTypes = new Class<?>[] {aType, bType, cType};

    InvocationHandler invocationHandler = new InvocationHandler() {

      @Override
      public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("===> " + method.getName());
        return null;
      }
    };

    // newProxyInstance()가 리턴한 객체는
    // A, B, C 인터페이스를 모두 구현한 객체 (클래스의 인스턴스)다.
    Object obj = Proxy.newProxyInstance(classLoader, interfaceTypes, invocationHandler);

    ((A) obj).m1();
    ((B) obj).m2();
    ((C) obj).m3();
  }
}
