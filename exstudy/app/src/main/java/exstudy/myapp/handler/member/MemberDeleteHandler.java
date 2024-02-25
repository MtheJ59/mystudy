package exstudy.myapp.handler.member;

import exstudy.menu.Menu;
import exstudy.menu.MenuHandler;
import exstudy.myapp.vo.Member;
import exstudy.util.AnsiEscape;
import exstudy.util.Prompt;

import java.util.ArrayList;

public class MemberDeleteHandler implements MenuHandler {

    Prompt prompt;
    ArrayList<Member> objectRepository;

    public MemberDeleteHandler(Prompt prompt, ArrayList<Member> objectRepository) {
        this.prompt = prompt;
        this.objectRepository = objectRepository;
    }

    @Override
    public void action(Menu menu) {
        System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

        int index = this.prompt.inputInt("번호? ");
        if (this.objectRepository.remove(index) == null) {
            System.out.println("번호가 유효하지 않습니다.");
        }
    }
}
