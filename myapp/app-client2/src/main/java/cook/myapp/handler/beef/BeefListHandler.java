package cook.myapp.handler.beef;

import cook.menu.AbstractMenuHandler;
import cook.myapp.dao.BeefDao;
import cook.myapp.vo.Beef;
import cook.util.Prompt;
import java.util.List;

public class BeefListHandler extends AbstractMenuHandler {

  private BeefDao beefDao;

  public BeefListHandler(BeefDao beefDao, Prompt prompt) {
    super(prompt);
    this.beefDao = beefDao;
  }

  @Override
  protected void action() {
    System.out.printf("%-4s\t%-20s\t%s\n", "No", "Title", "createdDate");

    List<Beef> list = beefDao.findAll();

    for (Beef beef : list) {
      System.out.printf("%-4d\t%-20s\t%4$tY-%4$tm-%4$td\n",
          beef.getNo(),
          beef.getTitle(),
          beef.getCreatedDate());
    }
  }
}
