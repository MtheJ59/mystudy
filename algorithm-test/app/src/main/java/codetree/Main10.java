package codetree;

import java.util.Scanner;

public class Main10 {
  public static void main(String[] args) {
    // 여기에 코드를 작성해주세요.

    Scanner sc = new Scanner(System.in);


    int count = 0;
    int sum = 0;

    while (true) {
      int age = sc.nextInt();
      if (age > 29 || age < 19) {
        break;
      } else {
        count++;
        sum += age;
      }

      double SV = (double) sum / count;
      System.out.printf("%.2f", SV);
    }
  }
}
