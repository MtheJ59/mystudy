package exstudy.myapp.handler.assignment;

import exstudy.menu.Menu;
import exstudy.menu.MenuHandler;
import exstudy.util.AnsiEscape;
import exstudy.util.Prompt;

public class AssignmentDeleteHandler implements MenuHandler {

  Prompt prompt;
  AssignmentRepository assignmentRepository;

  public AssignmentDeleteHandler(Prompt prompt, AssignmentRepository assignmentRepository) {
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

    for (int i = index; i < (this.assignmentRepository.length -1); i++) {
      this.assignmentRepository.assignments[i] = this.assignmentRepository.assignments[i + 1];
    }
    this.assignmentRepository.assignments[--this.assignmentRepository.length] = null;
  }
}
