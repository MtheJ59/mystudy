import java.util.Scanner;

public class BoardMenu {

  static String title;
  static String content;
  static String writer;
  static String createdDate;

  static void excute() {
    printBoardMenu();
    while (true) {
      String input = Prompt.input("게시글");

      switch (input) {
        case "1":
          add();
          break;
        case "2":
          System.out.println("조회입니다.");
          break;
        case "3":
          System.out.println("변경입니다.");
          break;
        case "4":
          System.out.println("삭제입니다.");
          break;
        case "0":
          return;
        case "menu":
          printBoardMenu();
          break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다.");
      }
    }
  }

  static void printBoardMenu() {
    System.out.println("[게시글]");
    System.out.println("1. 등록");
    System.out.println("2. 조회");
    System.out.println("3. 변경");
    System.out.println("4. 삭제");
    System.out.println("0. 이전");
  }

  static void add() {
    System.out.println("게시글 등록:");
    title = Prompt.input("제목:");
    content = Prompt.input("내용:");
    writer = Prompt.input("작성자:");
    createdDate = Prompt.input("작성일:");
  }

  static void view() {
    System.out.println("게시글 조회:");
    System.out.printf("제목: %s\n", title);
  }

}
