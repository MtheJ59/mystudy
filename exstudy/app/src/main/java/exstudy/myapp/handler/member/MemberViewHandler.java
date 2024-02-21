package exstudy.myapp.handler.member;

import exstudy.menu.Menu;
import exstudy.menu.MenuHandler;
import exstudy.myapp.vo.Member;
import exstudy.util.AnsiEscape;
import exstudy.util.Prompt;

public class MemberViewHandler implements MenuHandler {

    Prompt prompt;
    MemberRepository memberRepository;

    public MemberViewHandler(Prompt prompt, MemberRepository memberRepository) {
        this.prompt = prompt;
        this.memberRepository = memberRepository;
    }

    @Override
    public void action(Menu menu) {
        System.out.printf(AnsiEscape.ANSI_BOLD + "%s\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

        int index = this.prompt.inputInt("번호? ");
        if (index < 0 || index >= this.memberRepository.length) {
            System.out.println("번호가 유효하지 않습니다.");
            return;
        }

        Member member = this.memberRepository.members[index];
        System.out.printf("이메일: %s\n", member.email);
        System.out.printf("이름: %s\n", member.name);
        System.out.printf("비밀번호: %s\n", member.password);
        System.out.printf("가입일: %s\n", member.createdDate);
    }
}
