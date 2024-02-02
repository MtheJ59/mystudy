package cook.myapp;

import cook.menu.MenuGroup;
import cook.myapp.dao.BeefDao;
import cook.myapp.dao.LambDao;
import cook.myapp.dao.json.BeefDaoImpl;
import cook.myapp.dao.json.LambDaoImpl;
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

public class App {

  Prompt prompt = new Prompt(System.in);

  LambDao lambDao = new LambDaoImpl("lamb.json");
  BeefDao beefDao = new BeefDaoImpl("beef.json");
  MenuGroup mainMenu;

  App() {
    prepareMenu();
  }

  public static void main(String[] args) {
    new App().run();
  }

  void prepareMenu() {
    mainMenu = MenuGroup.getInstance("요리 관리");

    MenuGroup lambMenu = mainMenu.addGroup("Lamb");
    lambMenu.addItem("양요리 등록", new LambAddHandler(lambDao, prompt));
    lambMenu.addItem("양요리 조회", new LambViewHandler(lambDao, prompt));
    lambMenu.addItem("양요리 변경", new LambModifyHandler(lambDao, prompt));
    lambMenu.addItem("양요리 삭제", new LambDeleteHandler(lambDao, prompt));
    lambMenu.addItem("양요리 목록", new LambListHandler(lambDao, prompt));

    MenuGroup beefMenu = mainMenu.addGroup("Beef");
    beefMenu.addItem("소요리 등록", new BeefAddHandler(beefDao, prompt));
    beefMenu.addItem("소요리 조회", new BeefViewHandler(beefDao, prompt));
    beefMenu.addItem("소요리 변경", new BeefModifyHandler(beefDao, prompt));
    beefMenu.addItem("소요리 삭제", new BeefDeleteHandler(beefDao, prompt));
    beefMenu.addItem("소요리 목록", new BeefListHandler(beefDao, prompt));

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
