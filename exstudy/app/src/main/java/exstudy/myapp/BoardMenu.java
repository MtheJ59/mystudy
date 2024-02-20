package exstudy.myapp;


import exstudy.myapp.vo.Board;
import exstudy.util.Prompt;

public class BoardMenu {

  static Board[] boards = new Board[3];
  static int length = 0;

  static void execute() {
    printBoardMenu();

    while(true) {
      String input = Prompt.input("메인/게시글> ");

      switch(input) {
        case "1" :
         add();
          break;
        case "2" :
          view();
          break;
        case "3" :
          modify();
          break;
        case "4" :
          delete();
          break;
        case "5" :
          list();
          break;
        case "0" :
          return;
        case "menu" :
          printBoardMenu();
          break;
        default :
          System.out.println("번호가 옳지 않습니다.");
      }
    }
  }

  static void printBoardMenu() {
    System.out.println("[게시글]");
    System.out.println("1. 등록");
    System.out.println("2. 조회");
    System.out.println("3. 변경");
    System.out.println("4. 삭제");
    System.out.println("5. 목록");
    System.out.println("0. 이전");
  }

  static void add() {
    System.out.println("과제 등록:");

    if (length == boards.length) {
      int oldSize = boards.length;
      int newSize = oldSize + (oldSize / 2);

      Board[] arr = new Board[newSize];
      for (int i = 0; i < oldSize; i++) {
        arr[i] = boards[i];
      }
      boards = arr;
    }

    Board board = new Board();
    board.title = Prompt.input("과제명? ");
    board.content = Prompt.input("내용? ");
    board.writer = Prompt.input("작성자? ");
    board.createdDate = Prompt.input("작성일? ");

    boards[length] = board;
    length++;
  }

  static void list() {
    System.out.println("과제 목록:");
    System.out.printf("%-20s\t%10s\t%s\n", "Title", "Writer", "Date");

    for (int i = 0; i < length; i++) {
      Board board = boards[i];
      System.out.printf("%-20s\t%10s\t%s\n", board.title, board.writer, board.createdDate);
    }
  }

  static void view() {
    System.out.println("과제 조회:");

    int index = Integer.parseInt(Prompt.input("번호? "));
    if (index < 0 || index >= length) {
      System.out.println("번호가 유효하지 않습니다.");
      return;
    }

    Board board = boards[index];
    System.out.printf("과제명: %s\n", board.title);
    System.out.printf("내용: %s\n", board.content);
    System.out.printf("작성자: %s\n", board.writer);
    System.out.printf("작성일: %s\n", board.createdDate);
  }

  static void modify() {
    System.out.println("과제 변경:");

    int index = Integer.parseInt(Prompt.input("번호? "));
    if (index < 0 || index >= length) {
      System.out.println("번호가 유효하지 않습니다.");
      return;
    }

    Board board = boards[index];
    board.title = Prompt.input("과제명(%s)? ", board.title);
    board.content = Prompt.input("내용(%s)? ", board.content);
    board.writer = Prompt.input("작성자(%s)? ", board.writer);
    board.createdDate = Prompt.input("작성일(%s)? ", board.createdDate);
  }

  static void delete() {
    System.out.println("과제 삭제:");

    int index = Integer.parseInt(Prompt.input("번호? "));
    if (index < 0 || index >= length) {
      System.out.println("번호가 유효하지 않습니다.");
      return;
    }

    for (int i = index; i < (length - 1); i++) {
      boards[i] = boards[i + 1];
    }
    length--;
    boards[length] = null;
  }
}
