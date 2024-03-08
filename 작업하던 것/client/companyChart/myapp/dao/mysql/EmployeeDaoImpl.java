package companyChart.myapp.dao.mysql;

import companyChart.myapp.dao.DaoException;
import companyChart.myapp.dao.EmployeeDao;
import companyChart.myapp.vo.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

  int category;
  Connection con;

  public EmployeeDaoImpl(Connection con, int category) {
    this.con = con;
    this.category = category;
  }

  @Override
  public void add(Employee employee) {
    try (PreparedStatement pstmt = con.prepareStatement(
        "insert into employees(name,email,tel,jumin,joindate,addr,depm) values(?,?,?,?,?,?,?)")) {

      pstmt.setString(1, employee.getName());
      pstmt.setString(2, employee.getEmail());
      pstmt.setString(3, employee.getTel());
      pstmt.setString(4, employee.getJumin());
      pstmt.setString(5, employee.getJoinDate());
      pstmt.setString(6, employee.getAddr());
      pstmt.setString(7, employee.getDepm());

      pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try (PreparedStatement pstmt = con.prepareStatement(
        "delete from employees where employee_no=?")) {

      pstmt.setInt(1, no);

      return pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 삭제 오류", e);
    }
  }

  @Override
  public List<Employee> findAll() {
    try (PreparedStatement pstmt = con.prepareStatement(
        "select employee_no, title"
            + " from employees order by employee_no desc")) {

      try (ResultSet rs = pstmt.executeQuery()) {

        ArrayList<Employee> list = new ArrayList<>();

        while (rs.next()) {
          Employee employee = new Employee();
          employee.setNo(rs.getInt("employee_no"));
          employee.setName(rs.getString("name"));

          list.add(employee);
        }
        return list;
      }

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public Employee findBy(int no) {
    try (PreparedStatement pstmt = con.prepareStatement(
        "select * from employees where employee_no=?")) {

      pstmt.setInt(1, no);

      try (ResultSet rs = pstmt.executeQuery()) {
        if (rs.next()) {
          Employee employee = new Employee();
          employee.setNo(rs.getInt("employee_no"));
          employee.setName(rs.getString("name"));
          employee.setEmail(rs.getString("email"));

          return employee;
        }
        return null;
      }

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public int update(Employee employee) {
    try (PreparedStatement pstmt = con.prepareStatement(
        "update employees set title=?, content=? where employee_no=?")) {

      pstmt.setString(1, employee.getName());
      pstmt.setString(2, employee.getEmail());
      pstmt.setInt(4, employee.getNo());

      return pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 변경 오류", e);
    }
  }
}
