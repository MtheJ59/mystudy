package bitcamp.myapp.handler.member;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.vo.Member;
import bitcamp.util.DBConnectionPool;
import bitcamp.util.Prompt;
import java.sql.Connection;

public class MemberAddHandler extends AbstractMenuHandler {

  private DBConnectionPool connectionPool;
  private MemberDao memberDao;

  public MemberAddHandler(DBConnectionPool connectionPool, MemberDao memberDao) {
    this.connectionPool = connectionPool;
    this.memberDao = memberDao;
  }

  @Override
  protected void action(Prompt prompt) {
    Connection con = null;
    try {
      Member member = new Member();
      member.setEmail(prompt.input("이메일? "));
      member.setName(prompt.input("이름? "));
      member.setPassword(prompt.input("암호? "));
      memberDao.add(member);
      con = connectionPool.getConnection();
      con.setAutoCommit(false);

      memberDao.add(member);
      memberDao.add(member);

      Thread.sleep(10000);

      memberDao.add(member);

      con.commit();
    } catch (Exception e) {
      try {
        con.rollback();
      } catch (Exception e2) {
      } finally {
        connectionPool.returnConnection(con);
      }
    }
  }
}