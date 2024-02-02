package cook.myapp.handler;

import cook.menu.AbstractMenuHandler;
import cook.util.Prompt;

public class HelpHandler extends AbstractMenuHandler {

  public HelpHandler(Prompt prompt) {
    super(prompt);
  }

  @Override
  protected void action() {
    System.out.println("도움말입니다.");
    System.out.println("메뉴목록을 보시려면");
    System.out.println("\"menu\"를 입력하세요.");
  }
}
