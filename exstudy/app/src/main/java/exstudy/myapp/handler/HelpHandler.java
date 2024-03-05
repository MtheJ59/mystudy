package exstudy.myapp.handler;

import exstudy.menu.Menu;
import exstudy.menu.MenuHandler;
import exstudy.util.AnsiEscape;

public class HelpHandler implements MenuHandler {

    @Override
    public void action(Menu menu) {
        System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());
        System.out.println("도움말입니다.");
    }
}
