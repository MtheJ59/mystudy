package codetree;

import java.util.Scanner;

public class Main7 {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    // 변수를 선언하여 정수를 입력받아, 해당 정수의 약수 중
    // 해당 정수를 제외한 나머지의 합이 정수값과 같다면 P를
    // 같지 않다면 N을 출력한다.

    // 변수를 선언하여 정수 n을 입력받아
    // i의 초기값이 1이고, n보다 작을 때만 실행되는 조건
    // i의 값이 1씩 증가하는 for문을 실행

    // 각 for loop마다 n을 i로 나누었을 때
    // 나머지가 없는지 판단하여 나머지가 0이라면
    // i는 n의 약수라는 뜻이므로
    // sumVal에 i값을 더한다.

    // for문이 끝난 뒤 n과 sumVal을 비교하여
    // 값이 같다면 P를 같지 않다며녀 N을 출력한다.



    int n = sc.nextInt();
    int sumVal = 0;

    for (int i = 1; i < n; i++) {
      if (n % i == 0) {
        sumVal += i;
      }
    }
    if (n == sumVal) {
      System.out.println("P");
    } else {
      System.out.println("N");
    }
  }
}
