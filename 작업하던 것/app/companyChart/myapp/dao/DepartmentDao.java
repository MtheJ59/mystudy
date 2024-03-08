package companyChart.myapp.dao;

import companyChart.myapp.vo.Department;
import java.util.List;

public interface DepartmentDao {

  void add(Department department);

  int delete(int no);

  List<Department> findAll();

  Department findBy(int no);

  int update(Department department);

}
