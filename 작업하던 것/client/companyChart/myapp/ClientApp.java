package companyChart.myapp;

import companyChart.menu.MenuGroup;
import companyChart.myapp.dao.DepartmentDao;
import companyChart.myapp.dao.EmployeeDao;
import companyChart.myapp.dao.mysql.DepartmentDaoImpl;
import companyChart.myapp.handler.HelpHandler;
import companyChart.myapp.handler.department.DepartmentAddHandler;
import companyChart.myapp.handler.department.DepartmentDeleteHandler;
import companyChart.myapp.handler.department.DepartmentListHandler;
import companyChart.myapp.handler.department.DepartmentModifyHandler;
import companyChart.myapp.handler.department.DepartmentViewHandler;
import companyChart.myapp.handler.employee.EmployeeAddHandler;
import companyChart.myapp.handler.employee.EmployeeDeleteHandler;
import companyChart.myapp.handler.employee.EmployeeListHandler;
import companyChart.myapp.handler.employee.EmployeeModifyHandler;
import companyChart.myapp.handler.employee.EmployeeViewHandler;
import companyChart.util.Prompt;
import java.sql.Connection;
import java.sql.DriverManager;

public class ClientApp {

  Prompt prompt = new Prompt(System.in);

  DepartmentDao departmentDao;
  EmployeeDao employeeDao;

  MenuGroup mainMenu;

  ClientApp() {
    prepareDatabase();
    prepareMenu();
  }

  public static void main(String[] args) {
    System.out.println("[회사 관리 시스템]");
    new ClientApp().run();
  }

  void prepareDatabase() {
    try {

      Connection con = DriverManager.getConnection(
          "jdbc:mysql://localhost/studydb", "study", "Bitcamp!@#123");
//          "jdbc:mysql://db-ld29n-kr.vpc-pub-cdb.ntruss.com/studydb", "study", "Bitcamp!@#123");

      departmentDao = new DepartmentDaoImpl(con, 1);

    } catch (Exception e) {
      System.out.println("통신 오류!");
      e.printStackTrace();
    }
  }

  void prepareMenu() {
    mainMenu = MenuGroup.getInstance("ooo회사");

    MenuGroup departmentMenu = mainMenu.addGroup("부서");
    departmentMenu.addItem("부서 등록", new DepartmentAddHandler(departmentDao, prompt));
    departmentMenu.addItem("부서 조회", new DepartmentViewHandler(departmentDao, prompt));
    departmentMenu.addItem("부서 변경", new DepartmentModifyHandler(departmentDao, prompt));
    departmentMenu.addItem("부서 삭제", new DepartmentDeleteHandler(departmentDao, prompt));
    departmentMenu.addItem("부서 목록", new DepartmentListHandler(departmentDao, prompt));

    MenuGroup employeeMenu = mainMenu.addGroup("직원정보");
    employeeMenu.addItem("직원정보 등록", new EmployeeAddHandler(employeeDao, prompt));
    employeeMenu.addItem("직원정보 조회", new EmployeeViewHandler(employeeDao, prompt));
    employeeMenu.addItem("직원정보 변경", new EmployeeModifyHandler(employeeDao, prompt));
    employeeMenu.addItem("직원정보 삭제", new EmployeeDeleteHandler(employeeDao, prompt));
    employeeMenu.addItem("직원정보 목록", new EmployeeListHandler(employeeDao, prompt));

    mainMenu.addItem("도움말", new HelpHandler(prompt));
  }

  void run() {
    while (true) {
      try {
        mainMenu.execute(prompt);
        prompt.close();
        break;
      } catch (Exception e) {
        System.out.println("예외 발생!");
      }
    }
  }

}
