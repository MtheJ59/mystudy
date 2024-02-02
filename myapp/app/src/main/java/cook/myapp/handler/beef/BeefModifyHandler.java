package cook.myapp.handler.beef;

import cook.menu.AbstractMenuHandler;
import cook.myapp.dao.BeefDao;
import cook.myapp.vo.Beef;
import cook.util.Prompt;

public class BeefModifyHandler extends AbstractMenuHandler {

  private BeefDao beefDao;

  public BeefModifyHandler(BeefDao beefDao, Prompt prompt) {
    super(prompt);
    this.beefDao = beefDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("요리 번호? ");

    Beef oldBeef = beefDao.findBy(no);
    if (oldBeef == null) {
      System.out.println("요리 번호가 유효하지 않습니다.");
      return;
    }

    Beef beef = new Beef();
    beef.setNo(oldBeef.getNo()); // 기존 요리의 번호를 그대로 설정한다.
    beef.setTitle(this.prompt.input("요리 이름(%s)? ", oldBeef.getTitle()));
    beef.setContent(this.prompt.input("먹는법(%s)? ", oldBeef.getContent()));
    beef.setCooks(this.prompt.input("원하는 익힘(%s)? ", oldBeef.getCooks()));
    beef.setPrice(this.prompt.input("수정할 가격(%s)? ", oldBeef.getPrice()));

    beefDao.update(beef);
    System.out.println("요리를 변경했습니다.");
  }
}
