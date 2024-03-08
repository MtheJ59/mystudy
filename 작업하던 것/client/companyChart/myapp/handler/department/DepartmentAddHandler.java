package companyChart.myapp.handler.department;

import companyChart.menu.AbstractMenuHandler;
import companyChart.myapp.dao.DepartmentDao;
import companyChart.myapp.vo.Department;
import companyChart.util.Prompt;

public class DepartmentAddHandler extends AbstractMenuHandler {

  private DepartmentDao departmentDao;

  public DepartmentAddHandler(DepartmentDao departmentDao, Prompt prompt) {
    super(prompt);
    this.departmentDao = departmentDao;
  }

  @Override
  protected void action() {
    try {
      Department department = new Department();
      department.setTitle(this.prompt.input("부서 이름? "));
      department.setContent(this.prompt.input("하는 일? "));

      departmentDao.add(department);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
