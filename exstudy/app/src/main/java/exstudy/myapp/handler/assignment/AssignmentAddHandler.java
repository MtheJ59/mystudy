package exstudy.myapp.handler.assignment;

import exstudy.menu.Menu;
import exstudy.menu.MenuHandler;
import exstudy.myapp.vo.Assignment;
import exstudy.util.AnsiEscape;
import exstudy.util.Prompt;

public class AssignmentAddHandler implements MenuHandler {

Prompt prompt;
AssignmentRepository assignmentRepository;

  public AssignmentAddHandler(Prompt prompt, AssignmentRepository assignmentRepository) {
    this.prompt = prompt;
    this.assignmentRepository = assignmentRepository;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

    if (this.assignmentRepository.length == this.assignmentRepository.assignments.length) {
      int oldSize = this.assignmentRepository.assignments.length;
      int newSize = oldSize + (oldSize / 2);

      Assignment[] arr = new Assignment[newSize];
      for (int i = 0; i < oldSize; i++) {
        arr[i] = this.assignmentRepository.assignments[i];
      }
      this.assignmentRepository.assignments = arr;
    }

    Assignment assignment = new Assignment();
    assignment.title = this.prompt.input("과제명? ");
    assignment.content = this.prompt.input("내용? ");
    assignment.deadline = this.prompt.input("제출 마감일? ");

    this.assignmentRepository.assignments[this.assignmentRepository.length++] = assignment;
  }

}
