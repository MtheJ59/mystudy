package companyChart.myapp.dao.json;

import companyChart.myapp.dao.DepartmentDao;
import companyChart.myapp.vo.Department;
import java.util.List;

public class DepartmentDaoImpl extends AbstractDao<Department> implements DepartmentDao {

  private int lastKey;

  public DepartmentDaoImpl(String filepath) {
    super(filepath);

    // 마지막 게시글의 식별 번호를 알아낸다.
    lastKey = list.getLast().getNo();
  }

  @Override
  public void add(Department department) {
    department.setNo(++lastKey);
    this.list.add(department);
    saveData();
  }

  @Override
  public int delete(int no) {
    int index = indexOf(no);
    if (index == -1) {
      return 0;
    }

    list.remove(index);
    saveData();
    return 1;
  }

  @Override
  public List<Department> findAll() {
    return this.list.subList(0, list.size());
  }

  @Override
  public Department findBy(int no) {
    int index = indexOf(no);
    if (index == -1) {
      return null;
    }
    return list.get(index);
  }

  @Override
  public int update(Department department) {
    int index = indexOf(department.getNo());
    if (index == -1) {
      return 0;
    }
    list.set(index, department);
    saveData();
    return 1;
  }

  private int indexOf(int no) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }
}
