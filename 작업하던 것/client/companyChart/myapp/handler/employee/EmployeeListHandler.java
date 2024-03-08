package companyChart.myapp.handler.employee;

import companyChart.menu.AbstractMenuHandler;
import companyChart.myapp.dao.EmployeeDao;
import companyChart.myapp.vo.Employee;
import companyChart.util.Prompt;

import java.util.List;

public class EmployeeListHandler extends AbstractMenuHandler {

  private EmployeeDao employeeDao;

  public EmployeeListHandler(EmployeeDao employeeDao, Prompt prompt) {
    super(prompt);
    this.employeeDao = employeeDao;
  }

  @Override
  protected void action() {
    try {
      System.out.printf("%-4s\t%-20s\t%-10s\t%-10s\t%s\n", "No", "Name", "Email", "Tel", "Depm");

      List<Employee> list = employeeDao.findAll();

      for (Employee employee : list) {
        System.out.printf("%-4d\t%-20s\t%-10s\t%-10s\t%s\n",
            employee.getNo(),
            employee.getName(),
            employee.getEmail(),
            employee.getTel(),
            employee.getDepm());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
