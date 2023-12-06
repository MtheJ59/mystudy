package bitcamp.myapp;

import bitcamp.myapp.vo.Member;

public class MemberMenu {

  static Member[] members = new Member[3];
  static int length = 0;

  static void printMemberMenu() {
    System.out.println("회원]");
    System.out.println("1. 등록");
    System.out.println("2. 조회");
    System.out.println("3. 변경");
    System.out.println("4. 삭제");
    System.out.println("5. 목록");
    System.out.println("0. 이전");
  }

  static void execute() {
    printMemberMenu();

    while (true) {
      String input = Prompt.input("메인/회원> ");
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
        case "5":
          list();
          break;
        case "0":
          return;
        case "menu":
          printMemberMenu();
        default:
          System.out.println("회원 번호가 유효하지 않습니다.");
      }
    }
  }

  static void add() {
    System.out.println("회원 등록");

    if (length == members.length) {
      int oldSize = members.length;
      int newSize = oldSize + (oldSize >> 1);

      Member[] arr = new Member[newSize];
      for (int i = 0; i < oldSize; i++) {
        arr[i] = members[i];
      }
      members = arr;
    }

    Member member = new Member();
    member.email = Prompt.input("이메일? ");
    member.name = Prompt.input("이름? ");
    member.password = Prompt.input("비밀번호? ");
    member.join = Prompt.input("가입일? ");

    members[length++] = member;
  }

  static void list() {
    System.out.println("회원 목록");
    System.out.printf("%-20s\t%s\t%5s\t%10s\n", "이메일", "이름", "비밀번호", "가입일");

    for (int i = 0; i < length; i++) {
      Member member = members[i];
      System.out.printf("%-20s\t%s\t%5s\t%10s\n", member.email, member.name, member.password,
          member.join);
    }
  }

  static void view() {
    System.out.println("회원 조회");

    int index = Integer.parseInt(Prompt.input("번호? "));
    if (index < 0 || index == length) {
      System.out.println("회원 번호가 유효하지 않습니다.");
      return;
    }

    Member member = members[index];
    System.out.printf("이메일: %s\n", member.email);
    System.out.printf("비밀번호: %s\n", member.password);
    System.out.printf("가입일: %s\n", member.join);
  }

  static void modify() {
    System.out.println("회원 변경");

    int index = Integer.parseInt(Prompt.input("번호? "));
    if (index < 0 || index == length) {
      System.out.println("회원 번호가 유효하지 않습니다.");
      return;
    }

    Member member = members[index];
    member.email = Prompt.input("이메일(%s)? ", member.email);
    member.name = Prompt.input("이름(%s)? ", member.name);
    member.password = Prompt.input("비밀번호(%s)? ", member.password);
    member.join = Prompt.input("가입일(%s)? ", member.join);
  }

  static void delete() {
    System.out.println("회원 삭제입니다.");

    int index = Integer.parseInt(Prompt.input("번호? "));
    if (index == 0 || index >= length) {
      System.out.println("회원 번호가 유효하지 않습니다.");
    }

    for (int i = index; i < (length - 1); i++) {
      members[i] = members[i + 1];
    }
    members[--length] = null;
  }
}

