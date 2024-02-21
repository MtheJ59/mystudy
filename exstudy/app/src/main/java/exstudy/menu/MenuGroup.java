package exstudy.menu;

import exstudy.util.Prompt;

public class MenuGroup implements Menu {

  String title;
  Menu[] menus = new Menu[10];
  int menuSize;

  public MenuGroup(String title) {
    this.title = title;
  }

  @Override
  public void execute(Prompt prompt) {
    this.printMenu();
    while(true) {
      String input = prompt.input("%s\n", this.title);

      if (input.equals("menu")) {
        this.printMenu();
        continue;
      } else if (input.equals("0")) {
        break;
      }

      int menuNo = Integer.parseInt(input);
      if (menuNo < 1 || menuNo >= this.menuSize) {
        System.out.println("번호가 옳지 않습니다.");
        continue;
      }
      this.menus[menuSize - 1].execute(prompt);
    }
  }

  void printMenu() {
    System.out.printf("[%s]\n", this.title);
    for (int i = 0; i < menuSize; i++) {
      System.out.printf("%d. %s\n", menus[i], getTitle());
    }
    System.out.printf("0. %s\n", "이전");
  }

  @Override
  public String getTitle() {
    return this.title;
  }

  public void add(Menu menu) {
    if (this.menuSize == this.menus.length) {
      int oldSize = this.menus.length;
      int newSize = oldSize + (oldSize / 2);

      Menu[] arr = new Menu[newSize];
      for (int i = 0; i < oldSize; i++) {
        arr[i] = this.menus[i];
      }
      this.menus = arr;
    }
    this.menus[this.menuSize++] = menu;
  }

  public void remove(Menu menu) {
    int index = this.indexOf(menu);
    if (index == -1) {
      return;
    }
  }

  int indexOf(Menu menu) {
    for (int i = 0; i < menuSize; i++) {
      if (menu == this.menus[i]) {
        return i;
      }
    }
    return -1;
  }

}
