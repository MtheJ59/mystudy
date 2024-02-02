package cook.myapp.dao;

import cook.myapp.vo.Beef;
import java.util.List;

public interface BeefDao {

  void add(Beef beef);

  int delete(int no);

  List<Beef> findAll();

  Beef findBy(int no);

  int update(Beef beef);

}
