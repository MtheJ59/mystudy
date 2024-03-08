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
    System.out.printf("%-4s\t%-20s\t%s\n", "No", "Title", "Date");

    List<Department> list = departmentDao.findAll();

    for (Department department : list) {
      System.out.printf("%-4d\t%-20s\t%4$tY-%4$tm-%4$td\n",
          department.getNo(),
          department.getTitle(),
          department.getCreatedDate());
    }
  }
}
