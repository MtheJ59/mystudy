package bitcamp.myapp.handler.greeting;

import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Board;

// 게시글의 '목록' 메뉴를 선택했을 때 작업을 수행하는 클래스
// - 반드시 MenuHandler 규칙에 따라 클래스를 작성해야 한다.
//
public class GreetingListHandler implements MenuHandler {

  GreetingRepository greetingRepository;

  public GreetingListHandler(GreetingRepository greetingRepository) {
    this.greetingRepository = greetingRepository;
  }

  @Override
  public void action() {
    System.out.println("게시글 목록:");
    System.out.printf("%-20s\t%10s\t%s\n", "Title", "Writer", "Date");

    for (int i = 0; i < this.greetingRepository.length; i++) {
      Board board = this.greetingRepository.boards[i];
      System.out.printf("%-20s\t%10s\t%s\n", board.title, board.writer, board.createdDate);
    }
  }
}
