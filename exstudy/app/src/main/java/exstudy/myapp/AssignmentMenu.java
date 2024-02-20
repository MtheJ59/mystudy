package exstudy.myapp;

import exstudy.myapp.vo.Assignment;
import exstudy.util.Prompt;

public class AssignmentMenu {

 static Assignment[] assignments = new Assignment[3];
 static int length = 0;

  static void execute() {
    printAssignmentMenu();

    while(true) {
      String input = Prompt.input("메인/과제> ");

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
          printAssignmentMenu();
          break;
        default :
          System.out.println("번호가 옳지 않습니다.");
      }
    }
  }

  static void printAssignmentMenu() {
    System.out.println("[과제]");
    System.out.println("1. 등록");
    System.out.println("2. 조회");
    System.out.println("3. 변경");
    System.out.println("4. 삭제");
      System.out.println("5. 목록");
    System.out.println("0. 이전");
  }

  static void add() {
    System.out.println("과제 등록:");

    if (length == assignments.length) {
        int oldSize = assignments.length;
        int newSize = oldSize + (oldSize / 2);

        Assignment[] arr = new Assignment[newSize];
        for (int i = 0; i < oldSize; i++) {
            arr[i] = assignments[i];
        }
        assignments = arr;
    }

    Assignment assignment = new Assignment();
    assignment.title = Prompt.input("과제명? ");
    assignment.content = Prompt.input("내용? ");
    assignment.deadline = Prompt.input("제출 마감일? ");

    assignments[length++] = assignment;
  }

  static void list() {
      System.out.println("과제 목록:");
      System.out.printf("%-20s\t%-10s\t%s\n", "Title", "Content", "Deadline");

      for (int i = 0; i < length; i++) {
          Assignment assignment = assignments[i];
          System.out.printf("%-20s\t%-10s\t%s\n", assignment.title, assignment.content, assignment.deadline);
      }
  }

  static void view() {
    System.out.println("과제 조회:");

    int index = Integer.parseInt(Prompt.input("번호? "));
    if (index < 0 || index >= length) {
        System.out.println("번호가 유효하지 않습니다.");
        return;
    }

    Assignment assignment = assignments[index];
    System.out.printf("과제명: %s\n", assignment.title);
    System.out.printf("내용: %s\n", assignment.content);
    System.out.printf("제출 마감일: %s\n", assignment.deadline);
  }

  static void modify() {
    System.out.println("과제 변경:");

    int index = Integer.parseInt(Prompt.input("번호? "));
    if (index < 0 || index >= length) {
        System.out.println("번호가 유효하지 않습니다.");
        return;
    }

    Assignment assignment = assignments[index];
    assignment.title = Prompt.input("과제명(%s)? ", assignment.title);
    assignment.content = Prompt.input("내용(%s)? ", assignment.content);
    assignment.deadline = Prompt.input("제출 마감일(%s)? ", assignment.deadline);
  }

  static void delete() {
    System.out.println("과제 삭제:");

    int index = Integer.parseInt(Prompt.input("번호? "));
    if (index < 0 || index >= length) {
        System.out.println("번호가 유효하지 않습니다.");
        return;
    }

    for (int i = index; i < (length -1); i++) {
        assignments[i] = assignments[i + 1];
    }
    assignments[--length] = null;
  }
}