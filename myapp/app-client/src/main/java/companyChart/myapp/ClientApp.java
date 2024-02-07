package companyChart.myapp;

import companyChart.menu.MenuGroup;
import companyChart.myapp.dao.DepartmentDao;
import companyChart.myapp.dao.mysql.DepartmentDaoImpl;
import companyChart.myapp.handler.HelpHandler;
import companyChart.myapp.handler.department.DepartmentAddHandler;
import companyChart.myapp.handler.department.DepartmentDeleteHandler;
import companyChart.myapp.handler.department.DepartmentListHandler;
import companyChart.myapp.handler.department.DepartmentModifyHandler;
import companyChart.myapp.handler.department.DepartmentViewHandler;
import companyChart.util.Prompt;
import java.sql.Connection;
import java.sql.DriverManager;

public class ClientApp {

  Prompt prompt = new Prompt(System.in);

  DepartmentDao departmentDao;

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
//          "jdbc:mysql://db-ld27b-kr.vpc-pub-cdb.ntruss.com/studydb", "study", "Bitcamp!@#123");

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
