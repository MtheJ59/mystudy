package exstudy.menu;

import exstudy.util.Prompt;

public class MenuItem implements Menu {

  String title;
  MenuHandler menuHandler;

  public MenuItem(String title) {
    this.title = title;
  }

  public MenuItem(String title, MenuHandler menuHandler) {
    this.title = title;
    this.menuHandler = menuHandler;
  }

  public void execute(Prompt prompt) {
    if (this.menuHandler != null) {
      this.menuHandler.action(this);
    }
  }

  @Override
  public String getTitle() {
    return this.title;
  }
}
