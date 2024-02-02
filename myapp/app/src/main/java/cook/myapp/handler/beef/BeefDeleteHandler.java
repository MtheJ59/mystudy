package cook.myapp.handler.beef;

import cook.menu.AbstractMenuHandler;
import cook.myapp.dao.BeefDao;
import cook.util.Prompt;

public class BeefDeleteHandler extends AbstractMenuHandler {

  private BeefDao beefDao;

  public BeefDeleteHandler(BeefDao beefDao, Prompt prompt) {
    super(prompt);
    this.beefDao = beefDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("요리 번호? ");
    if (beefDao.delete(no) == 0) {
      System.out.println("요리 번호가 유효하지 않습니다.");
    } else {
      System.out.println("요리를 삭제했습니다!");
    }
  }
}
