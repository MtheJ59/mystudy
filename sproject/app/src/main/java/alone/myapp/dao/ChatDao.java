package alone.myapp.dao;

import alone.myapp.vo.Assignment;
import java.util.List;

public interface ChatDao {

  void add(Assignment assignment);

  int delete(int no);

  List<Assignment> findAll();

  Assignment findBy(int no);

  int update(Assignment assignment);

}
