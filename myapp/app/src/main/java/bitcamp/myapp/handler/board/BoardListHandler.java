package bitcamp.myapp.handler.board;

import bitcamp.myapp.menu.Menu;
import bitcamp.myapp.menu.MenuHandler;
import bitcamp.myapp.vo.Board;
import bitcamp.util.AnsiEscape;

public class BoardListHandler implements MenuHandler {

  BoardRepository boardRepository;

  public BoardListHandler(BoardRepository boardRepository) {
    this.boardRepository = boardRepository;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "%s\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

    System.out.printf("%-20s\t%10s\t%s\n", "Title", "Writer", "Date");

    for (Board board : boardRepository.toArray()) {
      System.out.printf("%-20s\t%10s\t%s\n", board.title, board.writer, board.createdDate);
    }
  }
}
