package exstudy.myapp.handler.member;

import exstudy.menu.Menu;
import exstudy.menu.MenuHandler;
import exstudy.myapp.vo.Member;
import exstudy.util.AnsiEscape;
import exstudy.util.ObjectRepository;

public class MemberListHandler implements MenuHandler {

    ObjectRepository objectRepository;

    public MemberListHandler(ObjectRepository objectRepository) {
        this.objectRepository = objectRepository;
    }

    @Override
    public void action(Menu menu) {
        System.out.printf(AnsiEscape.ANSI_BOLD + "%s\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());
        System.out.printf("%-20s\t%10s\t%s\n", "Email", "Name", "CreatedDate");

        for (Object object : this.objectRepository.toArray()) {
            Member member = (Member) object;
            System.out.printf("%-20s\t%10s\t%s\n", member.email, member.name, member.createdDate);
        }
    }
}
