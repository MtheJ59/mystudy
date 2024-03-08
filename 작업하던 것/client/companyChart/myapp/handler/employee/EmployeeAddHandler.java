package companyChart.myapp.handler.employee;

import companyChart.menu.AbstractMenuHandler;
import companyChart.myapp.dao.EmployeeDao;
import companyChart.myapp.vo.Employee;
import companyChart.util.Prompt;

public class EmployeeAddHandler extends AbstractMenuHandler {

  private EmployeeDao employeeDao;

  public EmployeeAddHandler(EmployeeDao employeeDao, Prompt prompt) {
    super(prompt);
    this.employeeDao = employeeDao;
  }

  @Override
  protected void action() {
    try {
      Employee employee = new Employee();
      employee.setName(this.prompt.input("직원 이름? "));
      employee.setEmail(this.prompt.input("이메일? "));
      employee.setTel(this.prompt.input("전화번호? "));
      employee.setJumin(this.prompt.input("주민번호? "));
      employee.setJoinDate(this.prompt.input("입사일? "));
      employee.setAddr(this.prompt.input("주소? "));
      employee.setDepm(this.prompt.input("부서? "));


      employeeDao.add(employee);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
