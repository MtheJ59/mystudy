package cook.myapp.handler.lamb;

import cook.menu.AbstractMenuHandler;
import cook.myapp.dao.LambDao;
import cook.myapp.vo.Lamb;
import cook.util.Prompt;

public class LambViewHandler extends AbstractMenuHandler {

  private LambDao lambDao;
  private Prompt prompt;

  public LambViewHandler(LambDao lambDao, Prompt prompt) {
    super(prompt);
    this.lambDao = lambDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("요리 번호? ");

    Lamb lamb = lambDao.findBy(no);
    if (lamb == null) {
      System.out.println("요리 번호가 유효하지 않습니다.");
      return;
    }

    System.out.printf("요리 번호: %d\n", lamb.getNo());
    System.out.printf("요리 이름: %s\n", lamb.getTitle());
    System.out.printf("먹는법: %s\n", lamb.getContent());
    System.out.printf("원하는 익힘: %s\n", lamb.getCooks());
    System.out.printf("작성일: %1$tY-%1$tm-%1$td\n", lamb.getCreatedDate());
  }
}
