package exstudy.myapp.handler.member;

import exstudy.menu.Menu;
import exstudy.menu.MenuHandler;
import exstudy.myapp.vo.Member;
import exstudy.util.AnsiEscape;
import exstudy.util.Prompt;

public class MemberAddHandler implements MenuHandler {

    Prompt prompt;
    MemberRepository memberRepository;

    public MemberAddHandler(Prompt prompt, MemberRepository memberRepository) {
        this.prompt = prompt;
        this.memberRepository = memberRepository;
    }

    @Override
    public void action(Menu menu) {
        System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

        if(this.memberRepository.length == this.memberRepository.members.length) {
            int oldSize = this.memberRepository.members.length;
            int newSize = oldSize + (oldSize / 2);

            Member[] arr = new Member[newSize];
            for (int i = 0; i < oldSize; i++) {
                arr[i] = this.memberRepository.members[i];
            }
            this.memberRepository.members = arr;
        }

        Member member = new Member();
        member.email = this.prompt.input("이메일? ");
        member.name = this.prompt.input("이름? ");
        member.password = this.prompt.input("비밀번호? ");
        member.createdDate = this.prompt.input("가입일? ");

        this.memberRepository.members[this.memberRepository.length++] = member;
    }
}
