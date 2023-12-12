package bitcamp.myapp.handler.assignment;

import bitcamp.myapp.menu.Menu;
import bitcamp.myapp.menu.MenuHandler;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.AnsiEscape;
import bitcamp.util.Prompt;

public class AssignmentAddHandler implements MenuHandler {

  Prompt prompt;
  AssignmentRepository assignmentRepository;
  Assignment assignment = new Assignment();

  public AssignmentAddHandler(AssignmentRepository assignmentRepository, Prompt prompt) {
    this.assignmentRepository = assignmentRepository;
    this.prompt = prompt;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "%s\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

    Assignment assignment = new Assignment();
    assignment.title = this.prompt.input("과제명? ");
    assignment.content = this.prompt.input("내용? ");
    assignment.deadline = this.prompt.input("제출 마감일? ");

    this.assignmentRepository.add(assignment);
  }
}
