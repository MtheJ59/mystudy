package exstudy.myapp;

import exstudy.menu.MenuGroup;
import exstudy.menu.MenuItem;
import exstudy.myapp.handler.HelpHandler;
import exstudy.myapp.handler.assignment.*;
import exstudy.myapp.handler.board.*;
import exstudy.myapp.handler.member.*;
import exstudy.util.ObjectRepository;
import exstudy.util.Prompt;

public class App {

    public static void main(String[] args) {
    Prompt prompt = new Prompt(System.in);
//    new MainMenu(prompt).execute();

        ObjectRepository assignmentRepository = new ObjectRepository();
        ObjectRepository boardRepository = new ObjectRepository();
        ObjectRepository greetingRepository = new ObjectRepository();
        ObjectRepository memberRepository = new ObjectRepository();

        MenuGroup mainMenu = new MenuGroup("메인");

        MenuGroup assignmentMenu = new MenuGroup("과제");
        assignmentMenu.add(new MenuItem("등록", new AssignmentAddHandler(prompt, assignmentRepository)));
        assignmentMenu.add(new MenuItem("조회", new AssignmentViewHandler(prompt, assignmentRepository)));
        assignmentMenu.add(new MenuItem("변경", new AssignmentModifyHandler(prompt, assignmentRepository)));
        assignmentMenu.add(new MenuItem("삭제", new AssignmentDeleteHandler(prompt, assignmentRepository)));
        assignmentMenu.add(new MenuItem("목록", new AssignmentListHandler(assignmentRepository)));
        mainMenu.add(assignmentMenu);

        MenuGroup boardMenu = new MenuGroup("게시판");
        boardMenu.add(new MenuItem("등록", new BoardAddHandler(prompt, boardRepository)));
        boardMenu.add(new MenuItem("조회", new BoardViewHandler(prompt, boardRepository)));
        boardMenu.add(new MenuItem("변경", new BoardModifyHandler(prompt, boardRepository)));
        boardMenu.add(new MenuItem("삭제", new BoardDeleteHandler(prompt, boardRepository)));
        boardMenu.add(new MenuItem("목록", new BoardListHandler(boardRepository)));
        mainMenu.add(boardMenu);

        MenuGroup greetingMenu = new MenuGroup("가입인사");
        greetingMenu.add(new MenuItem("등록", new BoardAddHandler(prompt, greetingRepository)));
        greetingMenu.add(new MenuItem("조회", new BoardViewHandler(prompt, greetingRepository)));
        greetingMenu.add(new MenuItem("변경", new BoardModifyHandler(prompt, greetingRepository)));
        greetingMenu.add(new MenuItem("삭제", new BoardDeleteHandler(prompt, greetingRepository)));
        greetingMenu.add(new MenuItem("목록", new BoardListHandler(greetingRepository)));
        mainMenu.add(greetingMenu);

        MenuGroup memberMenu = new MenuGroup("회원");
        memberMenu.add(new MenuItem("등록", new MemberAddHandler(prompt, memberRepository)));
        memberMenu.add(new MenuItem("조회", new MemberViewHandler(prompt, memberRepository)));
        memberMenu.add(new MenuItem("변경", new MemberModifyHandler(prompt, memberRepository)));
        memberMenu.add(new MenuItem("삭제", new MemberDeleteHandler(prompt, memberRepository)));
        memberMenu.add(new MenuItem("목록", new MemberListHandler(memberRepository)));
        mainMenu.add(memberMenu);

        mainMenu.add(new MenuItem("도움말", new HelpHandler()));

        mainMenu.execute(prompt);

    prompt.close();
    }
}
