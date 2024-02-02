package cook.myapp.handler.beef;

import cook.menu.AbstractMenuHandler;
import cook.myapp.dao.BeefDao;
import cook.myapp.vo.Beef;
import cook.util.Prompt;

public class BeefViewHandler extends AbstractMenuHandler {

  private BeefDao beefDao;

  public BeefViewHandler(BeefDao beefDao, Prompt prompt) {
    super(prompt);
    this.beefDao = beefDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("요리 번호? ");

    Beef beef = beefDao.findBy(no);
    if (beef == null) {
      System.out.println("요리 번호가 유효하지 않습니다.");
      return;
    }

    System.out.printf("요리 번호: %d\n", beef.getNo());
    System.out.printf("요리 이름: %s\n", beef.getTitle());
    System.out.printf("먹는법: %s\n", beef.getContent());
    System.out.printf("원하는 익힘: %s\n", beef.getCooks());
    System.out.printf("가격: %s\n", beef.getPrice());
  }
}
