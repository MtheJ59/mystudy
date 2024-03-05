package exstudy.myapp.handler.assignment;

import exstudy.menu.Menu;
import exstudy.menu.MenuHandler;
import exstudy.myapp.vo.Assignment;
import exstudy.util.AnsiEscape;

import java.util.ArrayList;

public class AssignmentListHandler implements MenuHandler {

  ArrayList<Assignment> objectRepository;

  public AssignmentListHandler(ArrayList<Assignment> objectRepository) {
    this.objectRepository = objectRepository;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());
    System.out.printf("%-20s\t%s\n", "Title", "Deadline");

    for (Object object : this.objectRepository.toArray()) {
      Assignment assignment = (Assignment) object;
      System.out.printf("%-20s\t%s\n", assignment.title, assignment.deadline);
    }
  }
}
