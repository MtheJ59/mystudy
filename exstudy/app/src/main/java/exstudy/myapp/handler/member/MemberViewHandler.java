package exstudy.myapp.handler.member;

import exstudy.menu.Menu;
import exstudy.menu.MenuHandler;
import exstudy.myapp.vo.Member;
import exstudy.util.AnsiEscape;
import exstudy.util.Prompt;

import java.util.ArrayList;

public class MemberViewHandler implements MenuHandler {

    Prompt prompt;
    ArrayList<Member> objectRepository;

    public MemberViewHandler(Prompt prompt, ArrayList<Member> objectRepository) {
        this.prompt = prompt;
        this.objectRepository = objectRepository;
    }

    @Override
    public void action(Menu menu) {
        System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

        int index = this.prompt.inputInt("번호? ");
        Member member = this.objectRepository.get(index);
        if (member == null) {
            System.out.println("번호가 유효하지 않습니다.");
            return;
        }
        System.out.printf("이메일: %s\n", member.email);
        System.out.printf("이름: %s\n", member.name);
        System.out.printf("비밀번호: %s\n", member.password);
        System.out.printf("가입일: %s\n", member.createdDate);
    }
}
