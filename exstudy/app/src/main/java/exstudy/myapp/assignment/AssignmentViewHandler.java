package exstudy.myapp.assignment;

import exstudy.menu.Menu;
import exstudy.menu.MenuHandler;
import exstudy.myapp.vo.Assignment;
import exstudy.util.AnsiEscape;
import exstudy.util.Prompt;

public class AssignmentViewHandler implements MenuHandler {

  Prompt prompt;
  AssignmentRepository assignmentRepository;

  public AssignmentViewHandler(Prompt prompt, AssignmentRepository assignmentRepository) {
    this.prompt = prompt;
    this.assignmentRepository = assignmentRepository;
  }

  @Override
  public void action(Menu menu) {
      System.out.printf(AnsiEscape.ANSI_BOLD + "%s\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

      int index = this.prompt.inputInt("번호? ");
      if (index < 0 || index >= this.assignmentRepository.length) {
        System.out.println("번호가 유효하지 않습니다.");
        return;
      }

      Assignment assignment = this.assignmentRepository.assignments[index];
      System.out.printf("과제명: %s\n", assignment.title);
      System.out.printf("내용: %s\n", assignment.content);
      System.out.printf("제출 마감일: %s\n", assignment.deadline);
    }
  }

