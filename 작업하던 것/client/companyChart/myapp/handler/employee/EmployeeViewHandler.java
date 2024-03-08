package companyChart.myapp.handler.employee;

import companyChart.menu.AbstractMenuHandler;
import companyChart.myapp.dao.EmployeeDao;
import companyChart.myapp.vo.Employee;
import companyChart.util.Prompt;

public class EmployeeViewHandler extends AbstractMenuHandler {

  private EmployeeDao employeeDao;

  public EmployeeViewHandler(EmployeeDao employeeDao, Prompt prompt) {
    super(prompt);
    this.employeeDao = employeeDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("직원 번호? ");

    Employee employee = employeeDao.findBy(no);
    if (employee == null) {
      System.out.println("직원 번호가 유효하지 않습니다.");
      return;
    }

    System.out.printf("직원 번호: %d\n", employee.getNo());
    System.out.printf("직원 이름: %s\n", employee.getName());
    System.out.printf("부서: %s\n", employee.getDepm());
    System.out.printf("전화번호: %s\n", employee.getTel());
    System.out.printf("이메일: %s\n", employee.getEmail());
  }
}
