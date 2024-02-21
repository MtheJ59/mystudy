package exstudy.myapp.handler.board;

import exstudy.menu.Menu;
import exstudy.menu.MenuHandler;
import exstudy.util.AnsiEscape;
import exstudy.util.Prompt;

public class BoardDeleteHandler implements MenuHandler {

  Prompt prompt;
  BoardRepository boardRepository;

  public BoardDeleteHandler(Prompt prompt, BoardRepository boardRepository) {
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

    for (int i = index; i < (this.boardRepository.length - 1); i++) {
      this.boardRepository.boards[i] = this.boardRepository.boards[i + 1];
    }
    this.boardRepository.length--;
    this.boardRepository.boards[this.boardRepository.length] = null;
  }
}
