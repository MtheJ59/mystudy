package exstudy.myapp.handler.assignment;

import exstudy.menu.Menu;
import exstudy.menu.MenuHandler;
import exstudy.myapp.vo.Assignment;
import exstudy.util.AnsiEscape;

public class AssignmentListHandler implements MenuHandler {

  AssignmentRepository assignmentRepository;

  public AssignmentListHandler(AssignmentRepository assignmentRepository) {
    this.assignmentRepository = assignmentRepository;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "%s\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());
    System.out.printf("%-20s\t%-10s\t%s\n", "Title", "Content", "Deadline");

    for (int i = 0; i < this.assignmentRepository.length; i++) {
      Assignment assignment = this.assignmentRepository.assignments[i];
      System.out.printf("%-20s\t%-10s\t%s\n", assignment.title, assignment.content,
          assignment.deadline);
    }
  }
}
