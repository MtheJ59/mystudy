package com.eomcs.lang.ex99;

// import java.io.InputStream; // import는 가져오는게아닌 가져올 위치를 알려주는 것
// import java.util.Scanner;

public class Test1 {

  public static void main(String[] args) throws Exception {
    java.io.InputStream in = System.in;
    java.util.Scanner keyIn = new java.util.Scanner(in);
    String str = keyIn.nextLine();
    // keyIn.nextLine(); // Scanner 정보가 들어있기에 사용 가능하다.
    // in.nextLine(); // Scanner 정보가 있어야 nextLine()을 사용 가능하다.
    // int b = in.read(); // read를 사용하여 쓸 수 있으나 출력을 하나하나 직접 입력해야하는 불편함이있다.
    System.out.println("===> " + str);
    keyIn.close();
  }
}
