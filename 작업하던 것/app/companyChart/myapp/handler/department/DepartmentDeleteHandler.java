package companyChart.myapp.handler.department;

import companyChart.menu.AbstractMenuHandler;
import companyChart.myapp.dao.DepartmentDao;
import companyChart.util.Prompt;

public class DepartmentDeleteHandler extends AbstractMenuHandler {

  private DepartmentDao departmentDao;

  public DepartmentDeleteHandler(DepartmentDao departmentDao, Prompt prompt) {
    super(prompt);
    this.departmentDao = departmentDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("부서 번호? ");
    if (departmentDao.delete(no) == 0) {
      System.out.println("부서 번호가 유효하지 않습니다.");
    } else {
      System.out.println("삭제했습니다!");
    }
  }
}
