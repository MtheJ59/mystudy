package bitcamp.myapp;

import bitcamp.myapp.vo.Menu;

public class BoardMenu {

  static String title;
  static String content;
  static String writer;
  static String createdDate;

//  static void printBoardMenu() {
//    System.out.println("[게시글]");
//    System.out.println("1. 등록");
//    System.out.println("2. 조회");
//    System.out.println("3. 변경");
//    System.out.println("4. 삭제");
//    System.out.println("0. 이전");
//  }

  static void execute() {
    Menu m1 = new Menu();
    m1.printMenu("게시글");
    while (true) {
      String input = Prompt.input("메인/게시글> ");
      switch (input) {
        case "1":
          add();
          break;
        case "2":
          view();
          break;
        case "3":
          modify();
          break;
        case "4":
          delete();
          break;
        case "0":
          return;
        case "menu":
          m1.printMenu("게시글");
          break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다.");
          break;
      }
    }
  }

  static void add() {
    System.out.println("게시글 등록:");
    title = Prompt.input("제목? ");
    content = Prompt.input("내용? ");
    writer = Prompt.input("작성자? ");
    createdDate = Prompt.input("작성일? ");
  }

  static void view() {
    printView();
  }

  static void modify() {
    System.out.println("게시글 변경:");
    title = Prompt.input("제목(%s)? ", title);
    content = Prompt.input("내용(%s)? ", content);
    writer = Prompt.input("작성자(%s)? ", writer);
    createdDate = Prompt.input("작성일(%s)? ", createdDate);
  }

  static void delete() {
    System.out.println("게시글 삭제:");
    title = "";
    content = "";
    writer = "";
    createdDate = "";
  }

  static void printView() {
    System.out.println("게시글 조회:");
    System.out.printf("제목: %s\n", title);
    System.out.printf("내용: %s\n", content);
    System.out.printf("작성자: %s\n", writer);
    System.out.printf("작성일: %s\n", createdDate);
  }
}
