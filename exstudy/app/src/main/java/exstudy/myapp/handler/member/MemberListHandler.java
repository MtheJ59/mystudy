package exstudy.myapp.handler.member;

import exstudy.menu.Menu;
import exstudy.menu.MenuHandler;
import exstudy.myapp.vo.Member;
import exstudy.util.AnsiEscape;

public class MemberListHandler implements MenuHandler {

    MemberRepository memberRepository;

    public MemberListHandler(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void action(Menu menu) {
        System.out.printf(AnsiEscape.ANSI_BOLD + "%s\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());
        System.out.printf("%-20s\t%10s\t%s\n", "Email", "Name", "CreatedDate");

        for (int i = 0; i < this.memberRepository.length; i++) {
            Member member = this.memberRepository.members[i];
            System.out.printf("%-20s\t%10s\t%s\n", member.email, member.name, member.createdDate);
        }
    }
}
