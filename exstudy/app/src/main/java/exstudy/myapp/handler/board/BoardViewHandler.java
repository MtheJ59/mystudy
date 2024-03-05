package exstudy.myapp.handler.board;

import exstudy.menu.Menu;
import exstudy.menu.MenuHandler;
import exstudy.myapp.vo.Board;
import exstudy.util.AnsiEscape;
import exstudy.util.Prompt;

import java.util.ArrayList;

public class BoardViewHandler implements MenuHandler {

  Prompt prompt;
  ArrayList<Board> objectRepository;

  public BoardViewHandler(Prompt prompt, ArrayList<Board> objectRepository) {
    this.prompt = prompt;
    this.objectRepository = objectRepository;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

    int index = this.prompt.inputInt("번호? ");
    Board board = this.objectRepository.get(index);
    if (board == null) {
      System.out.println("번호가 유효하지 않습니다.");
      return;
    }
    System.out.printf("과제명: %s\n", board.title);
    System.out.printf("내용: %s\n", board.content);
    System.out.printf("작성자: %s\n", board.writer);
    System.out.printf("작성일: %s\n", board.createdDate);
  }
}
