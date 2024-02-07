package companyChart.myapp.handler.employee;

import companyChart.menu.AbstractMenuHandler;
import companyChart.myapp.dao.EmployeeDao;
import companyChart.util.Prompt;

public class EmployeeDeleteHandler extends AbstractMenuHandler {

  private EmployeeDao employeeDao;

  public EmployeeDeleteHandler(EmployeeDao employeeDao, Prompt prompt) {
    super(prompt);
    this.employeeDao = employeeDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("직원 번호? ");
    if (employeeDao.delete(no) == 0) {
      System.out.println("직원 번호가 유효하지 않습니다.");
    } else {
      System.out.println("삭제했습니다!");
    }
  }
}
