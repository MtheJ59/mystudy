package bitcamp.myapp.handler;

import bitcamp.myapp.menu.Menu;
import bitcamp.myapp.menu.MenuHandler;
import bitcamp.util.AnsiEscape;

public class HelpMenuHandler implements MenuHandler {

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "%s\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

    System.out.println("도움말입니다.");
  }
}
