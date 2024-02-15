package codetree;


// OOOOOO-OOOOOOO 형식으로 이루어져 있는 주민번호를 입력받아,
// -를 제외하여 출력하는 프로그램을 작성해보세요.

import java.util.Scanner;

public class Main02 {
  public static void main(String[] args) {
    // 여기에 코드를 작성해주세요.

    Scanner sc = new Scanner(System.in);
    sc.useDelimiter("-");
    int a = sc.nextInt();
    int b = sc.nextInt();

    System.out.println(a + "" + b);
  }
}

// import java.util.Scanner;
//
// public class Main {
// public static void main(String[] args) {
// // 여기에 코드를 작성해주세요.
//
// Scanner sc = new Scanner(System.in);
// sc.useDelimiter("-");
// int a = sc.nextInt();
// int b = sc.nextInt();
//
// System.out.printf("%d" + "%d", a,b);
// }
// }
