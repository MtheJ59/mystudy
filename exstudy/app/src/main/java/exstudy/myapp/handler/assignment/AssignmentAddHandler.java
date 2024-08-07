package exstudy.myapp.handler.assignment;

import exstudy.menu.Menu;
import exstudy.menu.MenuHandler;
import exstudy.myapp.vo.Assignment;
import exstudy.util.AnsiEscape;
import exstudy.util.Prompt;

import java.util.ArrayList;

public class AssignmentAddHandler implements MenuHandler {

Prompt prompt;
  ArrayList<Assignment> objectRepository;

  public AssignmentAddHandler(Prompt prompt, ArrayList<Assignment> objectRepository) {
    this.prompt = prompt;
    this.objectRepository = objectRepository;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

    Assignment assignment = new Assignment();
    assignment.title = this.prompt.input("과제명? ");
    assignment.content = this.prompt.input("내용? ");
    assignment.deadline = this.prompt.input("제출 마감일? ");

    this.objectRepository.add(assignment);
  }

}
