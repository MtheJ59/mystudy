package cook.myapp.handler.lamb;

import cook.menu.AbstractMenuHandler;
import cook.myapp.dao.LambDao;
import cook.myapp.vo.Lamb;
import cook.util.Prompt;

public class LambModifyHandler extends AbstractMenuHandler {

  private LambDao lambDao;

  public LambModifyHandler(LambDao lambDao, Prompt prompt) {
    super(prompt);
    this.lambDao = lambDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("요리 번호? ");

    Lamb oldLamb = lambDao.findBy(no);
    if (oldLamb == null) {
      System.out.println("요리 번호가 유효하지 않습니다.");
      return;
    }

    Lamb lamb = new Lamb();
    lamb.setNo(oldLamb.getNo()); // 기존 요리의 번호를 그대로 설정한다.
    lamb.setTitle(this.prompt.input("요리 이름(%s)? ", oldLamb.getTitle()));
    lamb.setContent(this.prompt.input("먹는법(%s)? ", oldLamb.getContent()));
    lamb.setCooks(this.prompt.input("원하는 익힘(%s)? ", oldLamb.getCooks()));
    lamb.setCreatedDate(oldLamb.getCreatedDate());

    lambDao.update(lamb);
    System.out.println("요리를 변경했습니다.");
  }
}
