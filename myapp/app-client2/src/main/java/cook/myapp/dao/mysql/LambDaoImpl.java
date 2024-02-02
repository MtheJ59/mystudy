package cook.myapp.dao.mysql;

import cook.myapp.dao.DaoException;
import cook.myapp.dao.LambDao;
import cook.myapp.vo.Lamb;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LambDaoImpl implements LambDao {

  int category;
  Connection con;

  public LambDaoImpl(Connection con, int category) {
    this.con = con;
    this.category = category;
  }

  @Override
  public void add(Lamb lamb) {
    try {
      Statement stmt = con.createStatement();
      stmt.executeUpdate(
          String.format(
              "insert into lambs(title,content,cooks,category) values('%s','%s','%s','%d')",
              lamb.getTitle(), lamb.getContent(), lamb.getCooks(), this.category));

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate(String.format("delete from lambs where lamb_no=%d", no));

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public List<Lamb> findAll() {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from lambs where category=" + this.category);

      ArrayList<Lamb> list = new ArrayList<>();

      while (rs.next()) {
        Lamb lamb = new Lamb();
        lamb.setNo(rs.getInt("lamb_no"));
        lamb.setTitle(rs.getString("title"));
        lamb.setContent(rs.getString("content"));
        lamb.setCooks(rs.getString("cooks"));
        lamb.setCreatedDate(rs.getDate("created_date"));

        list.add(lamb);
      }
      return list;

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public Lamb findBy(int no) {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from lambs where lamb_no = " + no);

      if (rs.next()) {
        Lamb lamb = new Lamb();
        lamb.setNo(rs.getInt("lamb_no"));
        lamb.setTitle(rs.getString("title"));
        lamb.setContent(rs.getString("content"));
        lamb.setCooks(rs.getString("cooks"));
        lamb.setCreatedDate(rs.getDate("created_date"));

        return lamb;
      }
      return null;

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public int update(Lamb lamb) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate(
          String.format("update lambs set title='%s', content='%s', cooks='%s' where lamb_no=%d",
              lamb.getTitle(), lamb.getContent(), lamb.getCooks(), lamb.getNo()));

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }
}
