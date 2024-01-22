public class MainMenu {

  static final String ANSI_CLEAR = "\033[0m";
  static final String ANSI_BOLD_Yellow = "\033[1;33m";
  static final String ANSI_Yellow = "\033[0;33m";
  static final String APP_TITLE = ANSI_BOLD_Yellow + "[과제관리 시스템]" + ANSI_CLEAR;
  static final String[] MENUS = {
      "1. 과제",
      "2. 게시글",
      "3. 도움말",
      ANSI_Yellow + "0. 종료" + ANSI_CLEAR
  };

  static void excute() {

    printMenu();

    loop:
    while (true) {
      String input = Prompt.input("메인");

      switch (input) {
        case "1":
          AssigmentMenu.excute();
          break;
        case "2":
          BoardMenu.excute();
          break;
        case "3":
          System.out.println("도움말입니다.");
          break;
        case "0":
          System.out.println("종료입니다.");
          break loop;
        case "menu":
          printMenu();
          break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다.");
      }
    }

    Prompt.close();
  }

  static void printMenu() {
    System.out.println(APP_TITLE);
    System.out.println();
    for (String menu : MENUS) {
      System.out.println(menu);
    }
  }
}
