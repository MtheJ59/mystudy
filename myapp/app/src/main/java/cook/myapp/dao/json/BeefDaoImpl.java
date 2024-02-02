package cook.myapp.dao.json;

import cook.myapp.dao.BeefDao;
import cook.myapp.vo.Beef;
import java.util.List;

public class BeefDaoImpl extends AbstractDao<Beef> implements BeefDao {

  private int lastKey;

  public BeefDaoImpl(String filepath) {
    super(filepath);

    lastKey = list.getLast().getNo();
  }

  @Override
  public void add(Beef beef) {
    beef.setNo(++lastKey);
    this.list.add(beef);
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
  public List<Beef> findAll() {
    return this.list.subList(0, list.size());
  }

  @Override
  public Beef findBy(int no) {
    int index = indexOf(no);
    if (index == -1) {
      return null;
    }
    return list.get(index);
  }

  @Override
  public int update(Beef beef) {
    int index = indexOf(beef.getNo());
    if (index == -1) {
      return 0;
    }
    list.set(index, beef);
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
