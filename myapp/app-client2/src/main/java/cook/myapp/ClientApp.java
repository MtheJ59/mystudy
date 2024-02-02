package cook.myapp;

import cook.menu.MenuGroup;
import cook.myapp.dao.BeefDao;
import cook.myapp.dao.LambDao;
import cook.myapp.dao.mysql.LambDaoImpl;
import cook.myapp.handler.HelpHandler;
import cook.myapp.handler.beef.BeefAddHandler;
import cook.myapp.handler.beef.BeefDeleteHandler;
import cook.myapp.handler.beef.BeefListHandler;
import cook.myapp.handler.beef.BeefModifyHandler;
import cook.myapp.handler.beef.BeefViewHandler;
import cook.myapp.handler.lamb.LambAddHandler;
import cook.myapp.handler.lamb.LambDeleteHandler;
import cook.myapp.handler.lamb.LambListHandler;
import cook.myapp.handler.lamb.LambModifyHandler;
import cook.myapp.handler.lamb.LambViewHandler;
import cook.util.Prompt;
import java.sql.Connection;
import java.sql.DriverManager;

public class ClientApp {

  Prompt prompt = new Prompt(System.in);

  LambDao lambDao;
  BeefDao beefDao;
  MenuGroup mainMenu;

  ClientApp() {
    prepareDatabase();
    prepareMenu();
  }

  public static void main(String[] args) {
    System.out.println("[메뉴 관리 시스템]");
    new ClientApp().run();
  }

  void prepareDatabase() {
    try {
      // JVM이 JDBC 드라이버 파일(.jar)에 설정된대로 자동으로 처리한다.
      // 생략 가능!
//      Driver driver = new com.mysql.jdbc.Driver();
//      DriverManager.registerDriver(driver);

      Connection con = DriverManager.getConnection(
//          "jdbc:mysql://localhost/studydb", "study", "Bitcamp!@#123");
          "jdbc:mysql://db-ld29n-kr.vpc-pub-cdb.ntruss.com/studydb", "study", "Bitcamp!@#123");

      lambDao = new LambDaoImpl(con, 1);

    } catch (Exception e) {
      System.out.println("통신 오류!");
      e.printStackTrace();
    }
  }

  void prepareMenu() {
    mainMenu = MenuGroup.getInstance("메인 메뉴 선택");

    MenuGroup lambMenu = mainMenu.addGroup("양고기");
    lambMenu.addItem("요리 등록", new LambAddHandler(lambDao, prompt));
    lambMenu.addItem("요리 조회", new LambViewHandler(lambDao, prompt));
    lambMenu.addItem("요리 변경", new LambModifyHandler(lambDao, prompt));
    lambMenu.addItem("요리 삭제", new LambDeleteHandler(lambDao, prompt));
    lambMenu.addItem("요리 목록", new LambListHandler(lambDao, prompt));

    MenuGroup beefMenu = mainMenu.addGroup("소고기");
    beefMenu.addItem("요리 등록", new BeefAddHandler(beefDao, prompt));
    beefMenu.addItem("요리 조회", new BeefViewHandler(beefDao, prompt));
    beefMenu.addItem("요리 변경", new BeefModifyHandler(beefDao, prompt));
    beefMenu.addItem("요리 삭제", new BeefDeleteHandler(beefDao, prompt));
    beefMenu.addItem("요리 목록", new BeefListHandler(beefDao, prompt));

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
