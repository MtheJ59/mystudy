package cook.myapp.dao;

import cook.myapp.vo.Lamb;
import java.util.List;

public interface LambDao {

  void add(Lamb lamb);

  int delete(int no);

  List<Lamb> findAll();

  Lamb findBy(int no);

  int update(Lamb lamb);

}
