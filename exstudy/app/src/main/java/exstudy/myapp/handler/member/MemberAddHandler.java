package exstudy.myapp.handler.member;

import exstudy.menu.Menu;
import exstudy.menu.MenuHandler;
import exstudy.myapp.vo.Member;
import exstudy.util.AnsiEscape;
import exstudy.util.Prompt;

import java.util.ArrayList;

public class MemberAddHandler implements MenuHandler {

    Prompt prompt;
    ArrayList<Member> objectRepository;

    public MemberAddHandler(Prompt prompt, ArrayList<Member> objectRepository) {
        this.prompt = prompt;
        this.objectRepository = objectRepository;
    }

    @Override
    public void action(Menu menu) {
        System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

        Member member = new Member();
        member.email = this.prompt.input("이메일? ");
        member.name = this.prompt.input("이름? ");
        member.password = this.prompt.input("비밀번호? ");
        member.createdDate = this.prompt.input("가입일? ");

        this.objectRepository.add(member);
    }
}
