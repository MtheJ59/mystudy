package bitcamp.myapp.handler.assignment;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.AssignmentDao;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.Prompt;

public class AssignmentModifyHandler extends AbstractMenuHandler {

  private AssignmentDao assignmentDao;

  public AssignmentModifyHandler(AssignmentDao assignmentDao, Prompt prompt) {
    super(prompt);
    this.assignmentDao = assignmentDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("번호? ");

    Assignment oldAssignment = assignmentDao.findBy(no);
    if (oldAssignment == null) {
      System.out.println("과제 번호가 유효하지 않습니다.");
      return;
    }

    Assignment assignment = new Assignment();
    assignment.setNo(oldAssignment.getNo());
    assignment.setTitle(this.prompt.input("과제명(%s)? ", oldAssignment.getTitle()));
    assignment.setContent(this.prompt.input("내용(%s)? ", oldAssignment.getContent()));
    assignment.setDeadline(this.prompt.inputDate("제출 마감일(%s)? ", oldAssignment.getDeadline()));

    assignmentDao.update(assignment);
    System.out.println("과제를 변경했습니다.");
  }
}
