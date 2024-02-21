package exstudy.myapp.board;

import exstudy.menu.Menu;
import exstudy.menu.MenuHandler;
import exstudy.myapp.vo.Board;
import exstudy.util.AnsiEscape;
import exstudy.util.Prompt;

public class BoardViewHandler implements MenuHandler {

  Prompt prompt;
  BoardRepository boardRepository;

  public BoardViewHandler(Prompt prompt, BoardRepository boardRepository) {
    this.prompt = prompt;
    this.boardRepository = boardRepository;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "%s\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

    int index = this.prompt.inputInt("번호? ");
    if (index < 0 || index >= this.boardRepository.length) {
      System.out.println("번호가 유효하지 않습니다.");
      return;
    }

    Board board = this.boardRepository.boards[index];
    System.out.printf("과제명: %s\n", board.title);
    System.out.printf("내용: %s\n", board.content);
    System.out.printf("작성자: %s\n", board.writer);
    System.out.printf("작성일: %s\n", board.createdDate);
  }
}
