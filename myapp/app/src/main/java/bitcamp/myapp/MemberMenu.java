package bitcamp.myapp;

import bitcamp.myapp.vo.Member;
import bitcamp.util.Prompt;

public class MemberMenu {

  Member[] members = new Member[3];
  int length = 0;
  String title;
  Prompt prompt;

  public MemberMenu(String title, Prompt prompt) {
    this.title = title;
    this.prompt = prompt;
  }

  void add() {
    System.out.println("회원 등록");

    if (this.length == this.members.length) {
      int oldSize = this.members.length;
      int newSize = oldSize + (oldSize >> 1);

      Member[] arr = new Member[newSize];
      for (int i = 0; i < oldSize; i++) {
        arr[i] = this.members[i];
      }
      this.members = arr;
    }

    Member member = new Member();
    member.email = this.prompt.input("이메일? ");
    member.name = this.prompt.input("이름? ");
    member.password = this.prompt.input("비밀번호? ");
    member.createdDate = this.prompt.input("가입일? ");
  }

  void list() {
    System.out.println("회원 목록");
    System.out.printf("%s\t%s\t%s\t%s\n", "email", "name", "password", "createDate");

    for (int i = 0; i < this.length; i++) {
      Member member = this.members[i];
      System.out.printf("%s\t%s\t%s\t%s\n", member.email, member.name, member.password,
          member.createdDate);
    }
  }

  void view() {
    System.out.println("회원 조회");

    int index = Integer.parseInt(this.prompt.input("번호? "));
    if (index < 0 || index >= this.length) {
      System.out.println("회원 번호가 유효하지 않습니다.");
      return;
    }

    Member member = this.members[index];
    System.out.printf("이메일: %s\n", member.email);
    System.out.printf("이름: %s\n", member.name);
    System.out.printf("비밀번호: %s\n", member.password);
    System.out.printf("가입일: %s\n", member.createdDate);
  }

  void modify() {
    System.out.println("회원 변경");

    int index = Integer.parseInt(this.prompt.input("번호? "));
    if (index < 0 || index >= this.length) {
      System.out.println("회원 번호가 유효하지 않습니다.");
      return;
    }

    Member member = this.members[index];
    member.email = this.prompt.input("이메일? ", member.email);
    member.name = this.prompt.input("이름? ", member.name);
    member.password = this.prompt.input("비밀번호? ", member.password);
    member.createdDate = this.prompt.input("가입일? ", member.createdDate);
  }

  void delete() {
    System.out.println("회원 삭제");

    int index = Integer.parseInt(this.prompt.input("번호? "));
    if (index < 0 || index >= this.length) {
      System.out.println("회원 번호가 유효하지 않습니다.");
      return;
    }

    for (int i = index; i < (this.length - 1); i++) {
      this.members[i] = this.members[i + 1];
    }
    this.members[--this.length] = null;
  }

  void printMenu() {
    System.out.printf("[%s]\n", this.title);
    System.out.println("1. 등록");
    System.out.println("2. 조회");
    System.out.println("3. 변경");
    System.out.println("4. 삭제");
    System.out.println("5. 목록");
    System.out.println("6. 이전");
  }

  void execute() {
    this.printMenu();

    while (true) {
      String input = this.prompt.input("메인/%s> ", this.title);

      switch (input) {
        case "1":
          this.add();
          break;
        case "2":
          this.view();
          break;
        case "3":
          this.modify();
          break;
        case "4":
          this.delete();
          break;
        case "5":
          this.list();
          break;
        case "0":
          return;
        case "menu":
          this.printMenu();
          break;
        default:
          System.out.println("회원 번호가 옳지 않습니다.");
      }
    }
  }

}
