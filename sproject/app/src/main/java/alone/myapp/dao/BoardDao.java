package alone.myapp.dao;

import alone.myapp.vo.Board;
import java.util.List;

public interface BoardDao {

  void add(Board board);

  int delete(int no);

  List<Board> findAll(int category);

  Board findBy(int no);

  int update(Board board);

}