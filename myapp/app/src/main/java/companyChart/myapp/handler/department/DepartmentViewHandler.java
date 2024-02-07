package companyChart.myapp.handler.department;

import companyChart.menu.AbstractMenuHandler;
import companyChart.myapp.dao.DepartmentDao;
import companyChart.myapp.vo.Department;
import companyChart.util.Prompt;

public class DepartmentViewHandler extends AbstractMenuHandler {

  private DepartmentDao departmentDao;

  public DepartmentViewHandler(DepartmentDao departmentDao, Prompt prompt) {
    super(prompt);
    this.departmentDao = departmentDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("부서 번호? ");

    Department department = departmentDao.findBy(no);
    if (department == null) {
      System.out.println("부서 번호가 유효하지 않습니다.");
      return;
    }

    System.out.printf("부서 번호: %d\n", department.getNo());
    System.out.printf("부서 이름: %s\n", department.getTitle());
    System.out.printf("하는 일: %s\n", department.getContent());
    System.out.printf("작성일: %1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS\n", department.getCreatedDate());
  }
}
