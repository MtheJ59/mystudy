package bitcamp.myapp.handler.assignment;

import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.Prompt;

public class AssignmentModifyHandler implements MenuHandler {

  AssignmentRepository assignmentRepository;
  Prompt prompt;

  public AssignmentModifyHandler(AssignmentRepository assignmentRepository,Prompt prompt) {
    this.assignmentRepository = assignmentRepository;
    this.prompt = prompt;
  }

  @Override
  public void action() {
    System.out.println("과제 변경:");

    int index = this.prompt.inputInt("번호? ");
    if (index < 0 || index >= this.assignmentRepository.length) {
      System.out.println("과제 번호가 유효하지 않습니다.");
      return;
    }

    Assignment assignment = this.assignmentRepository.assignments[index];
    assignment.title = this.prompt.input("과제명(%s)? ", assignment.title);
    assignment.content = this.prompt.input("내용(%s)? ", assignment.content);
    assignment.deadline = this.prompt.input("제출 마감일(%s)? ", assignment.deadline);
  }
}
