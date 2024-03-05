package exstudy.myapp.handler.member;

import exstudy.menu.Menu;
import exstudy.menu.MenuHandler;
import exstudy.myapp.vo.Member;
import exstudy.util.AnsiEscape;
import exstudy.util.Prompt;

import java.util.ArrayList;

public class MemberModifyHandler implements MenuHandler {

    Prompt prompt;
    ArrayList<Member> objectRepository;

    public MemberModifyHandler(Prompt prompt, ArrayList<Member> objectRepository) {
        this.prompt = prompt;
        this.objectRepository = objectRepository;
    }

    @Override
    public void action(Menu menu) {
        System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

        int index = this.prompt.inputInt("번호? ");
        Member oldMember = this.objectRepository.get(index);
        if (oldMember == null) {
            System.out.println("번호가 유효하지 않습니다.");
            return;
        }

        Member member = new Member();
        member.email = this.prompt.input("이메일(%s)? \n", oldMember.email);
        member.name = this.prompt.input("이름(%s)? \n", oldMember.name);
        member.password = this.prompt.input("비밀번호(%s)? \n", oldMember.password);
        member.createdDate = this.prompt.input("가입일(%s)? \n", oldMember.createdDate);
    }
}
