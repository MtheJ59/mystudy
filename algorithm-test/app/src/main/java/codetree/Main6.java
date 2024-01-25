package codetree;

import java.util.Scanner;

public class Main6 {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();
    int b = sc.nextInt();
    int count = 0;
    int sumVal = 0;
    int sumVal2 = 0;
    int sumVal3 = 0;
    float avVal = 0;

    for (int i = a; i <= b; i++) {
      if (i % 5 == 0) {
        sumVal += i;
        count += 1;
      } else if (i % 7 == 0) {
        sumVal2 += i;
        count += 1;
      }
      sumVal3 = sumVal + sumVal2;
    }
    avVal = (float) sumVal3 / count;

    System.out.printf("%s %.1f", sumVal3, avVal);
  }
}
