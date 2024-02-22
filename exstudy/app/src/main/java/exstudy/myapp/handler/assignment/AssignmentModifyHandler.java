package exstudy.myapp.handler.assignment;

import exstudy.menu.Menu;
import exstudy.menu.MenuHandler;
import exstudy.myapp.vo.Assignment;
import exstudy.util.AnsiEscape;
import exstudy.util.ObjectRepository;
import exstudy.util.Prompt;

public class AssignmentModifyHandler implements MenuHandler {

  Prompt prompt;
  ObjectRepository objectRepository;

  public AssignmentModifyHandler(Prompt prompt, ObjectRepository objectRepository) {
    this.prompt = prompt;
    this.objectRepository = objectRepository;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "%s\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

    int index = this.prompt.inputInt("번호? ");
    Assignment old = (Assignment) this.objectRepository.get(index);
    if (old == null) {
      System.out.println("번호가 유효하지 않습니다.");
      return;
    }

    Assignment assignment = new Assignment();
    assignment.title = this.prompt.input("과제명(%s)? ", assignment.title);
    assignment.content = this.prompt.input("내용(%s)? ", assignment.content);
    assignment.deadline = this.prompt.input("제출 마감일(%s)? ", assignment.deadline);

    this.objectRepository.set(index, assignment);
  }
}
