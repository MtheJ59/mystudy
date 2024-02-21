package exstudy.myapp;

import exstudy.myapp.vo.Member;
import exstudy.util.Prompt;

public class MemberMenu {

  static Member[] members = new Member[3];
  static int length = 0;

  static void execute() {
    printMenu();

    while(true) {
      String input = Prompt.input("메인/회원> ");

      switch(input) {
        case "1" :
          add();
          break;
        case "2" :
          view();
          break;
        case "3" :
          modify();
        case "4" :
          delete();
          break;
        case "5" :
          list();
          break;
        case "0" :
          return;
        case "menu" :
          printMenu();
          break;
        default :
          System.out.println("번호가 옳지 않습니다.");
      }
    }
  }

  static void printMenu() {
    System.out.println("[회원]");
    System.out.println("1. 등록");
    System.out.println("2. 조회");
    System.out.println("3. 변경");
    System.out.println("4. 삭제");
    System.out.println("5. 목록");
    System.out.println("0. 삭제");
  }

  static void add() {
    System.out.println("회원 등록:");

    if(length == members.length) {
      int oldSize = members.length;
      int newSize = oldSize + (oldSize / 2);

      Member[] arr = new Member[newSize];
      for (int i = 0; i < oldSize; i++) {
        arr[i] = members[i];
      }
      members = arr;
    }

    Member member = new Member();
    member.email = Prompt.input("이메일? ");
  }
}
