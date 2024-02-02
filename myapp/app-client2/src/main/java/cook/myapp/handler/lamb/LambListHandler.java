package cook.myapp.handler.lamb;

import cook.menu.AbstractMenuHandler;
import cook.myapp.dao.LambDao;
import cook.myapp.vo.Lamb;
import cook.util.Prompt;
import java.util.List;

public class LambListHandler extends AbstractMenuHandler {

  private LambDao lambDao;

  public LambListHandler(LambDao lambDao, Prompt prompt) {
    super(prompt);
    this.lambDao = lambDao;
  }

  @Override
  protected void action() {
    System.out.printf("%-4s\t%-20s\t%10s\t%s\n", "No", "Title", "Cooks", "createdDate");

    List<Lamb> list = lambDao.findAll();

    for (Lamb lamb : list) {
      System.out.printf("%-4d\t%-20s\t%10s\t%4$tY-%4$tm-%4$td\n",
          lamb.getNo(),
          lamb.getTitle(),
          lamb.getCooks(),
          lamb.getCreatedDate());
    }
  }
}
