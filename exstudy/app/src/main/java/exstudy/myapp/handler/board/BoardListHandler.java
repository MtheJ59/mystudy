package exstudy.myapp.handler.board;

import exstudy.menu.Menu;
import exstudy.menu.MenuHandler;
import exstudy.myapp.vo.Board;
import exstudy.util.AnsiEscape;

import java.util.ArrayList;

public class BoardListHandler implements MenuHandler {

  ArrayList<Board> objectRepository;

  public BoardListHandler(ArrayList<Board> objectRepository) {
    this.objectRepository = objectRepository;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());
    System.out.printf("%-20s\t%10s\t%s\n", "Title", "Writer", "Date");

    for (Object object : this.objectRepository.toArray()) {
      Board board = (Board) object;
      System.out.printf("%-20s\t%10s\t%s\n", board.title, board.writer, board.createdDate);
    }
  }
}
