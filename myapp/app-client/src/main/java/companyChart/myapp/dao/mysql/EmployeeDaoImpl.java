package companyChart.myapp.dao.mysql;

import companyChart.myapp.dao.DaoException;
import companyChart.myapp.dao.DepartmentDao;
import companyChart.myapp.vo.Department;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements DepartmentDao {

    int category;
    Connection con;

    public EmployeeDaoImpl(Connection con, int category) {
        this.con = con;
        this.category = category;
    }

    @Override
    public void add(Department department) {
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into departments(title,content) values(?,?)")) {

            pstmt.setString(1, department.getTitle());
            pstmt.setString(2, department.getContent());

            pstmt.executeUpdate();

        } catch (Exception e) {
            throw new DaoException("데이터 입력 오류", e);
        }
    }

    @Override
    public int delete(int no) {
        try (PreparedStatement pstmt = con.prepareStatement(
                "delete from departments where department_no=?")) {

            pstmt.setInt(1, no);

            return pstmt.executeUpdate();

        } catch (Exception e) {
            throw new DaoException("데이터 삭제 오류", e);
        }
    }

    @Override
    public List<Department> findAll() {
        try (PreparedStatement pstmt = con.prepareStatement(
                "select department_no, title"
                        + " from departments order by department_no desc")) {

            try (ResultSet rs = pstmt.executeQuery()) {

                ArrayList<Department> list = new ArrayList<>();

                while (rs.next()) {
                    Department department = new Department();
                    department.setNo(rs.getInt("department_no"));
                    department.setTitle(rs.getString("title"));

                    list.add(department);
                }
                return list;
            }

        } catch (Exception e) {
            throw new DaoException("데이터 가져오기 오류", e);
        }
    }

    @Override
    public Department findBy(int no) {
        try (PreparedStatement pstmt = con.prepareStatement(
                "select * from departments where department_no=?")) {

            pstmt.setInt(1, no);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Department department = new Department();
                    department.setNo(rs.getInt("department_no"));
                    department.setTitle(rs.getString("title"));
                    department.setContent(rs.getString("content"));

                    return department;
                }
                return null;
            }

        } catch (Exception e) {
            throw new DaoException("데이터 가져오기 오류", e);
        }
    }

    @Override
    public int update(Department department) {
        try (PreparedStatement pstmt = con.prepareStatement(
                "update departments set title=?, content=? where department_no=?")) {

            pstmt.setString(1, department.getTitle());
            pstmt.setString(2, department.getContent());
            pstmt.setInt(4, department.getNo());

            return pstmt.executeUpdate();

        } catch (Exception e) {
            throw new DaoException("데이터 변경 오류", e);
        }
    }
}
