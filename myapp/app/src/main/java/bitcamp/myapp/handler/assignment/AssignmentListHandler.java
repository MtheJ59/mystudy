package bitcamp.myapp.handler.assignment;

import bitcamp.myapp.menu.Menu;
import bitcamp.myapp.menu.MenuHandler;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.AnsiEscape;

public class AssignmentListHandler implements MenuHandler {

  AssignmentRepository assignmentRepository;

  public AssignmentListHandler(AssignmentRepository assignmentRepository) {
    this.assignmentRepository = assignmentRepository;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "%s\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

    System.out.printf("%-20s\t%10s\t%s\n", "Title", "Writer", "Date");

    for (Assignment assignment : this.assignmentRepository.toArray()) {
      System.out.printf("%-20s\t%s\n", assignment.title, assignment.deadline);
    }
  }
}

