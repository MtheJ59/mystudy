package bitcamp.myapp.handler.member;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.vo.Member;
import bitcamp.util.Prompt;

public class MemberModifyHandler extends AbstractMenuHandler {

  private MemberDao memberDao;

  public MemberModifyHandler(MemberDao memberDao, Prompt prompt) {
    super(prompt);
    this.memberDao = memberDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("번호? ");

    Member oldMember = memberDao.findBy(no);
    if (oldMember == null) {
      System.out.println("회원 번호가 유효하지 않습니다.");
      return;
    }

    Member member = new Member();
    member.setNo(oldMember.getNo());
    member.setEmail(this.prompt.input("이메일(%s)? ", oldMember.getEmail()));
    member.setName(this.prompt.input("이름(%s)? ", oldMember.getName()));
    member.setPassword(this.prompt.input("새 암호? "));
    member.setCreatedDate(oldMember.getCreatedDate());

    memberDao.update(member);
    System.out.println("회원 정보를 변경했습니다.");
  }
}
