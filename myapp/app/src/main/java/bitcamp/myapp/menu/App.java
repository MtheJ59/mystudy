package bitcamp.myapp.menu;

import bitcamp.myapp.util.Prompt;

public class App {

  public static void main(String[] agrs) {
    Prompt prompt = new Prompt(System.in);
    new MainMenu(prompt).execute();
    prompt.close();
  }

}
