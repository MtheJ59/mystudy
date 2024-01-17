package javaBook;

public class IndexOfContainsExample {
  public static void main(String[] args) {
    String subject = "자바 프로그래밍";

    int location = subject.indexOf("프로그래밍");
    System.out.println(location);
    String substring = subject.substring(location);
    System.out.println(substring);

    location = subject.indexOf("자바");
    if (location == -1) {
      System.out.println("자바와 관련된 책이군요.");
    } else {
      System.out.println("자바와 관련 없는 책이군요.");
    }

    boolean result = subject.contains("자바");
    if (result) {
      System.out.println("자라와 관련된 책이군요.");
    } else {
      System.out.println("자바와 관련 없는 책이군요.");
    }

    // SplitExample

    String board = "1, 자바 학습, 참조 타입 String을 학습합니다., 홍길동";

    // 문자열 분리
    String[] tokens = board.split(",");

    // 인덱스별로 읽기
    System.out.println("번호: " + tokens[0]);
    System.out.println("제목: " + tokens[1]);
    System.out.println("내용: " + tokens[2]);
    System.out.println("성명: " + tokens[3]);
    System.out.println();

    // for 문을 이용한 읽기
    for (int i = 0; i < tokens.length; i++) {
      System.out.println(tokens[i]);
    }
  }
}
