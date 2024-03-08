package companyChart.myapp.handler.department;

import companyChart.menu.AbstractMenuHandler;
import companyChart.myapp.dao.DepartmentDao;
import companyChart.myapp.vo.Department;
import companyChart.util.Prompt;
import java.util.List;

public class DepartmentListHandler extends AbstractMenuHandler {

  private DepartmentDao departmentDao;

  public DepartmentListHandler(DepartmentDao departmentDao, Prompt prompt) {
    super(prompt);
    this.departmentDao = departmentDao;
  }

  @Override
  protected void action() {
    try {
      System.out.printf("%-4s\t%-20s\n", "No", "Title");

      List<Department> list = departmentDao.findAll();

      for (Department department : list) {
        System.out.printf("%-4d\t%-20s\n",
            department.getNo(),
            department.getTitle());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
