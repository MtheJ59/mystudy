package cook.myapp.handler.lamb;

import cook.menu.AbstractMenuHandler;
import cook.myapp.dao.LambDao;
import cook.myapp.vo.Lamb;
import cook.util.Prompt;
import java.util.Date;

public class LambAddHandler extends AbstractMenuHandler {

  private LambDao lambDao;

  public LambAddHandler(LambDao lambDao, Prompt prompt) {
    super(prompt);
    this.lambDao = lambDao;
  }

  @Override
  protected void action() {
    Lamb lamb = new Lamb();
    lamb.setTitle(this.prompt.input("요리 이름? "));
    lamb.setContent(this.prompt.input("먹는법? "));
    lamb.setCooks(this.prompt.input("원하는 익힘? "));
    lamb.setCreatedDate(new Date());

    lambDao.add(lamb);
  }
}
