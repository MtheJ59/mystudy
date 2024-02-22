package exstudy.myapp.handler.board;

import exstudy.menu.Menu;
import exstudy.menu.MenuHandler;
import exstudy.myapp.vo.Board;
import exstudy.util.AnsiEscape;
import exstudy.util.ObjectRepository;
import exstudy.util.Prompt;

public class BoardModifyHandler implements MenuHandler {

  Prompt prompt;
  ObjectRepository objectRepository;

  public BoardModifyHandler(Prompt prompt, ObjectRepository objectRepository) {
    this.prompt = prompt;
    this.objectRepository = objectRepository;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "%s\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

    int index = this.prompt.inputInt("번호? ");
    Board old = (Board) this.objectRepository.get(index);
    if (old == null) {
      System.out.println("번호가 유효하지 않습니다.");
      return;
    }

    Board board = new Board();
    board.title = this.prompt.input("과제명(%s)? ", board.title);
    board.content = this.prompt.input("내용(%s)? ", board.content);
    board.writer = this.prompt.input("작성자(%s)? ", board.writer);
    board.createdDate = this.prompt.input("작성일(%s)? ", board.createdDate);

    this.objectRepository.set(index, board);
  }
}
