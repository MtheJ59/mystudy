import java.util.Scanner;

public class BoardMenu {

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
    System.out.println("제목:");
    System.out.println("내용:");
    System.out.println("작성자:");
    System.out.println("작성일:");
  }

}
