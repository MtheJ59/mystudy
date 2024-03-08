package companyChart.myapp.handler.department;

import companyChart.menu.AbstractMenuHandler;
import companyChart.myapp.dao.DepartmentDao;
import companyChart.myapp.vo.Department;
import companyChart.util.Prompt;

public class DepartmentModifyHandler extends AbstractMenuHandler {

  private DepartmentDao departmentDao;

  public DepartmentModifyHandler(DepartmentDao departmentDao, Prompt prompt) {
    super(prompt);
    this.departmentDao = departmentDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("부서 번호? ");

    Department oldDepartment = departmentDao.findBy(no);
    if (oldDepartment == null) {
      System.out.println("부서 번호가 유효하지 않습니다.");
      return;
    }

    Department department = new Department();
    department.setNo(oldDepartment.getNo());
    department.setTitle(this.prompt.input("부서 이름(%s)? ", oldDepartment.getTitle()));
    department.setContent(this.prompt.input("하는 일(%s)? ", oldDepartment.getContent()));

    departmentDao.update(department);
    System.out.println("부서 정보를 변경했습니다.");
  }
}
