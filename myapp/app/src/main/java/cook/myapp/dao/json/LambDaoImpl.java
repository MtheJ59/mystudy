package cook.myapp.dao.json;

import cook.myapp.dao.LambDao;
import cook.myapp.vo.Lamb;
import java.util.List;

public class LambDaoImpl extends AbstractDao<Lamb> implements LambDao {

  private int lastKey;

  public LambDaoImpl(String filepath) {
    super(filepath);

    lastKey = list.getLast().getNo();
  }

  @Override
  public void add(Lamb lamb) {
    lamb.setNo(++lastKey);
    this.list.add(lamb);
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
  public List<Lamb> findAll() {
    return this.list.subList(0, list.size());
  }

  @Override
  public Lamb findBy(int no) {
    int index = indexOf(no);
    if (index == -1) {
      return null;
    }
    return list.get(index);
  }

  @Override
  public int update(Lamb lamb) {
    int index = indexOf(lamb.getNo());
    if (index == -1) {
      return 0;
    }
    list.set(index, lamb);
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
