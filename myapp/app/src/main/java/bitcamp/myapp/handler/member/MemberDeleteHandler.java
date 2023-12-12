package bitcamp.myapp.handler.member;

import bitcamp.myapp.menu.Menu;
import bitcamp.myapp.menu.MenuHandler;
import bitcamp.util.AnsiEscape;
import bitcamp.util.Prompt;

public class MemberDeleteHandler implements MenuHandler {

  Prompt prompt;
  MemberRepository memberRepository;

  public MemberDeleteHandler(MemberRepository memberRepository, Prompt prompt) {
    this.memberRepository = memberRepository;
    this.prompt = prompt;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

    int index = this.prompt.inputInt("번호? ");
    if (this.memberRepository.remove(index) == null) {
      System.out.println("회원 번호가 유효하지 않습니다.");
    }
  }
}
