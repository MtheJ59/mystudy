package companyChart.myapp.handler.employee;

import companyChart.menu.AbstractMenuHandler;
import companyChart.myapp.dao.EmployeeDao;
import companyChart.myapp.vo.Employee;
import companyChart.util.Prompt;

public class EmployeeModifyHandler extends AbstractMenuHandler {

  private EmployeeDao employeeDao;

  public EmployeeModifyHandler(EmployeeDao employeeDao, Prompt prompt) {
    super(prompt);
    this.employeeDao = employeeDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("직원 번호? ");

    Employee oldEmployee = employeeDao.findBy(no);
    if (oldEmployee == null) {
      System.out.println("직원 번호가 유효하지 않습니다.");
      return;
    }

    Employee employee = new Employee();
    employee.setNo(oldEmployee.getNo());
    employee.setName(this.prompt.input("직원 이름(%s)? ", oldEmployee.getName()));
    employee.setEmail(this.prompt.input("이메일(%s)? ", oldEmployee.getEmail()));
    employee.setTel(this.prompt.input("전화번호(%s)? ", oldEmployee.getTel()));
    employee.setAddr(this.prompt.input("주소(%s)? ", oldEmployee.getAddr()));
    employee.setDepm((this.prompt.input("부서(%s)? ", oldEmployee.getDepm())));

    employeeDao.update(employee);
    System.out.println("직원 정보를 변경했습니다.");
  }
}
