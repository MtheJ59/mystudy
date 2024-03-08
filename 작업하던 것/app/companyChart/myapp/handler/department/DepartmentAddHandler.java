package companyChart.myapp.handler.department;

import companyChart.menu.AbstractMenuHandler;
import companyChart.myapp.dao.DepartmentDao;
import companyChart.myapp.vo.Department;
import companyChart.util.Prompt;
import java.util.Date;

public class DepartmentAddHandler extends AbstractMenuHandler {

  private DepartmentDao departmentDao;

  public DepartmentAddHandler(DepartmentDao departmentDao, Prompt prompt) {
    super(prompt);
    this.departmentDao = departmentDao;
  }

  @Override
  protected void action() {
    Department department = new Department();
    department.setTitle(this.prompt.input("부서 이름? "));
    department.setContent(this.prompt.input("하는 일? "));
    department.setCreatedDate(new Date());

    departmentDao.add(department);
  }
}
