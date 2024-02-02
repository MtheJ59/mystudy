package cook.myapp.dao.mysql;

import cook.myapp.dao.BeefDao;
import cook.myapp.dao.DaoException;
import cook.myapp.vo.Beef;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BeefDaoImpl implements BeefDao {

  int category;
  Connection con;

  public BeefDaoImpl(Connection con, int category) {
    this.con = con;
    this.category = category;
  }

  @Override
  public void add(Beef beef) {
    try {
      Statement stmt = con.createStatement();
      stmt.executeUpdate(
          String.format(
              "insert into beefs(title,content,category) values('%s','%s','%d')",
              beef.getTitle(), beef.getContent(), this.category));

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate(String.format("delete from beefs where beef_no=%d", no));

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public List<Beef> findAll() {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from beefs where category=" + this.category);

      ArrayList<Beef> list = new ArrayList<>();

      while (rs.next()) {
        Beef beef = new Beef();
        beef.setNo(rs.getInt("beef_no"));
        beef.setTitle(rs.getString("title"));
        beef.setContent(rs.getString("content"));
        beef.setCreatedDate(rs.getDate("created_date"));

        list.add(beef);
      }
      return list;

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public Beef findBy(int no) {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from beefs where beef_no = " + no);

      if (rs.next()) {
        Beef beef = new Beef();
        beef.setNo(rs.getInt("beef_no"));
        beef.setTitle(rs.getString("title"));
        beef.setContent(rs.getString("content"));
        beef.setCreatedDate(rs.getDate("created_date"));

        return beef;
      }
      return null;

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public int update(Beef beef) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate(
          String.format("update beefs set title='%s', content='%s', where beef_no=%d",
              beef.getTitle(), beef.getContent(), beef.getNo()));

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }
}
