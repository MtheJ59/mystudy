package exstudy.myapp.handler.assignment;

import exstudy.menu.Menu;
import exstudy.menu.MenuHandler;
import exstudy.myapp.vo.Assignment;
import exstudy.util.AnsiEscape;
import exstudy.util.Prompt;

import java.util.ArrayList;

public class AssignmentModifyHandler implements MenuHandler {

  Prompt prompt;
  ArrayList<Assignment> objectRepository;

  public AssignmentModifyHandler(Prompt prompt, ArrayList<Assignment> objectRepository) {
    this.prompt = prompt;
    this.objectRepository = objectRepository;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

    int index = this.prompt.inputInt("번호? ");
    Assignment oldAssignment = this.objectRepository.get(index);
    if (oldAssignment == null) {
      System.out.println("번호가 유효하지 않습니다.");
      return;
    }

    Assignment assignment = new Assignment();
    assignment.title = this.prompt.input("과제명(%s)? ", oldAssignment.title);
    assignment.content = this.prompt.input("내용(%s)? ", oldAssignment.content);
    assignment.deadline = this.prompt.input("제출 마감일(%s)? ", oldAssignment.deadline);

    this.objectRepository.set(index, assignment);
  }
}
