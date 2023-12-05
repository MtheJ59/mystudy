package bitcamp.myapp.vo;

public class Menu {

  public Menu m1 = new Menu();
  public String[] menuItems;

  public Menu() {
  }

  public Menu(String[] menuItems) {
    this.menuItems = menuItems;

  }

  public static void main(String[] args) {
    // 과제 메뉴
    String[] assignmentMenuItems = {
        "1. 등록",
        "2. 조회",
        "3. 변경",
        "4. 삭제",
        "0. 이전"
    };
    Menu assignmentMenu = new Menu(assignmentMenuItems);
    assignmentMenu.printMenu("과제");

    // 게시글 메뉴
    String[] boardMenuItems = {
        "1. 등록",
        "2. 조회",
        "3. 변경",
        "4. 삭제",
        "0. 이전"
    };
    Menu boardMenu = new Menu(boardMenuItems);
    boardMenu.printMenu("게시글");
  }

  public void printMenu(String menuTitle) {
    System.out.println("[" + menuTitle + "]");
    for (String menuItem : menuItems) {
      System.out.println(menuItem);
    }
  }


}
