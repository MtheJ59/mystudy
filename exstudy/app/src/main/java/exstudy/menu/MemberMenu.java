package exstudy.menu;

import exstudy.myapp.vo.Member;
import exstudy.util.Prompt;

public class MemberMenu {

  Prompt prompt;
  String title;


  public MemberMenu(String title, Prompt prompt) {
    this.title = title;
    this.prompt = prompt;
  }

  void execute() {
    printMenu();
    while(true) {
      String input = this.prompt.input("메인/%s> ", this.title);

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

  void printMenu() {
    System.out.printf("[%s]\n", this.title);
    System.out.println("1. 등록");
    System.out.println("2. 조회");
    System.out.println("3. 변경");
    System.out.println("4. 삭제");
    System.out.println("5. 목록");
    System.out.println("0. 삭제");
  }

  void add() {
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
    member.email = this.prompt.input("이메일? ");
    member.name = this.prompt.input("이름? ");
    member.password = this.prompt.input("비밀번호? ");
    member.createdDate = this.prompt.input("가입일? ");

    members[length++] = member;
  }

  void list() {
    System.out.println("회원 목록:");
    System.out.printf("%-20s\t%10s\t%s\n", "Email", "Name", "CreatedDate");

    for (int i = 0; i < length; i++) {
      Member member = members[i];
      System.out.printf("%-20s\t%10s\t%s\n", member.email, member.name, member.createdDate);
    }
  }

  void view() {
    System.out.println("회원 조회:");

    int index = this.prompt.inputInt("번호? ");
    if (index < 0 || index >= length) {
      System.out.println("번호가 유효하지 않습니다.");
      return;
    }

    Member member = members[index];
    System.out.printf("이메일: %s\n", member.email);
    System.out.printf("이름: %s\n", member.name);
    System.out.printf("비밀번호: %s\n", member.password);
    System.out.printf("가입일: %s\n", member.createdDate);
  }

  void modify() {
    System.out.println("회원 변경:");

    int index = this.prompt.inputInt("번호? ");
    if (index < 0 || index >= length) {
      System.out.println("번호가 유효하지 않습니다.");
      return;
    }

    Member member = members[index];
    member.email = this.prompt.input("이메일(%s)? \n", member.email);
    member.name = this.prompt.input("이름(%s)? \n", member.name);
    member.password = this.prompt.input("비밀번호(%s)? \n", member.password);
    member.createdDate = this.prompt.input("가입일(%s)? \n", member.createdDate);
  }

  void delete() {
    System.out.println("회원 삭제:");

    int index = this.prompt.inputInt("번호? ");
    if (index < 0 || index >= length) {
      System.out.println("번호가 유효하지 않습니다.");
      return;
    }

    for (int i = index; i < (length - 1); i++) {
      members[i] = members[i + 1];
    }
    members[--length] = null;
  }
}
