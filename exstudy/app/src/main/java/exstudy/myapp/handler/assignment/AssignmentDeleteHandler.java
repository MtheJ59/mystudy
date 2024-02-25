package exstudy.myapp.handler.assignment;

import exstudy.menu.Menu;
import exstudy.menu.MenuHandler;
import exstudy.myapp.vo.Assignment;
import exstudy.util.AnsiEscape;
import exstudy.util.Prompt;

import java.util.ArrayList;

public class AssignmentDeleteHandler implements MenuHandler {

  Prompt prompt;
  ArrayList<Assignment> objectRepository;

  public AssignmentDeleteHandler(Prompt prompt, ArrayList<Assignment> objectRepository) {
    this.prompt = prompt;
    this.objectRepository = objectRepository;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

    int index = this.prompt.inputInt("번호? ");
    if (this.objectRepository.remove(index) == null) {
      System.out.println("번호가 유효하지 않습니다.");
    }
  }
}
