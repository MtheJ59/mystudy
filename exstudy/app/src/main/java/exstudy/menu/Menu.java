package exstudy.menu;

import exstudy.util.Prompt;

public interface Menu {

  public abstract void execute(Prompt prompt);

  public abstract String getTitle();

}
