package javaBook;

public class LengthExample {
  public static void main(String[] args) {
    String ssn = "9506241230123";
    int length = ssn.length();
    System.out.println(ssn.length());
    if (length == 13) {
      System.out.println("주민등록번호 자릿수가 맞습니다.");
    } else {
      System.out.println("주민등록번호 자릿수가 틀립니다.");
    }

    // ReplaceExample

    String oldStr = "자바 문자열은 불변입니다. 자바 문자열은 String입니다.";
    String newStr = oldStr.replace("자바", "JAVA");

    System.out.println(oldStr);
    System.out.println(newStr);

    // SubStringExample

    String ssn1 = "880815-1234567";

    String firstNum = ssn1.substring(0, 6);
    System.out.println(firstNum);

    String secondNum = ssn1.substring(7);
    System.out.println(secondNum);
  }
}

