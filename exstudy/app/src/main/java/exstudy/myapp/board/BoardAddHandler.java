package exstudy.myapp.board;

import exstudy.menu.Menu;
import exstudy.menu.MenuHandler;
import exstudy.myapp.vo.Board;
import exstudy.util.AnsiEscape;
import exstudy.util.Prompt;

public class BoardAddHandler implements MenuHandler {

  Prompt prompt;
  BoardRepository boardRepository;

  public BoardAddHandler(Prompt prompt, BoardRepository boardRepository) {
    this.prompt = prompt;
    this.boardRepository = boardRepository;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "%s\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

    if (this.boardRepository.length == this.boardRepository.boards.length) {
      int oldSize = this.boardRepository.boards.length;
      int newSize = oldSize + (oldSize / 2);

      Board[] arr = new Board[newSize];
      for (int i = 0; i < oldSize; i++) {
        arr[i] = this.boardRepository.boards[i];
      }
      this.boardRepository.boards = arr;
    }

    Board board = new Board();
    board.title = this.prompt.input("과제명? ");
    board.content = this.prompt.input("내용? ");
    board.writer = this.prompt.input("작성자? ");
    board.createdDate = this.prompt.input("작성일? ");

    this.boardRepository.boards[this.boardRepository.length] = board;
    this.boardRepository.length++;
  }
}
