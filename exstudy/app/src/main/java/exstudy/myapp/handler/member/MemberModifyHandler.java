package exstudy.myapp.handler.member;

import exstudy.menu.Menu;
import exstudy.menu.MenuHandler;
import exstudy.myapp.vo.Member;
import exstudy.util.AnsiEscape;
import exstudy.util.ObjectRepository;
import exstudy.util.Prompt;

public class MemberModifyHandler implements MenuHandler {

    Prompt prompt;
    ObjectRepository objectRepository;

    public MemberModifyHandler(Prompt prompt, ObjectRepository objectRepository) {
        this.prompt = prompt;
        this.objectRepository = objectRepository;
    }

    @Override
    public void action(Menu menu) {
        System.out.printf(AnsiEscape.ANSI_BOLD + "%s\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

        int index = this.prompt.inputInt("번호? ");
        Member old = (Member) this.objectRepository.get(index);
        if (old == null) {
            System.out.println("번호가 유효하지 않습니다.");
            return;
        }

        Member member = new Member();
        member.email = this.prompt.input("이메일(%s)? \n", member.email);
        member.name = this.prompt.input("이름(%s)? \n", member.name);
        member.password = this.prompt.input("비밀번호(%s)? \n", member.password);
        member.createdDate = this.prompt.input("가입일(%s)? \n", member.createdDate);
    }
}
