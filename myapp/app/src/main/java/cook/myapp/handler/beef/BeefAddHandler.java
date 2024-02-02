package cook.myapp.handler.beef;

import cook.menu.AbstractMenuHandler;
import cook.myapp.dao.BeefDao;
import cook.myapp.vo.Beef;
import cook.util.Prompt;

public class BeefAddHandler extends AbstractMenuHandler {

  private BeefDao beefDao;

  public BeefAddHandler(BeefDao beefDao, Prompt prompt) {
    super(prompt);
    this.beefDao = beefDao;
  }

  @Override
  protected void action() {
    Beef beef = new Beef();
    beef.setTitle(this.prompt.input("요리 이름? "));
    beef.setContent(this.prompt.input("먹는법? "));
    beef.setCooks(this.prompt.input("원하는 익힘? "));
    beef.setPrice(this.prompt.input("가격? "));

    beefDao.add(beef);
  }
}
