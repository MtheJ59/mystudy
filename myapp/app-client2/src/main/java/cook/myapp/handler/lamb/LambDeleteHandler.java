package cook.myapp.handler.lamb;

import cook.menu.AbstractMenuHandler;
import cook.myapp.dao.LambDao;
import cook.util.Prompt;

public class LambDeleteHandler extends AbstractMenuHandler {

  private LambDao lambDao;

  public LambDeleteHandler(LambDao lambDao, Prompt prompt) {
    super(prompt);
    this.lambDao = lambDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("요리 번호? ");
    if (lambDao.delete(no) == 0) {
      System.out.println("요리 번호가 유효하지 않습니다.");
    } else {
      System.out.println("요리를 삭제했습니다!");
    }
  }
}
