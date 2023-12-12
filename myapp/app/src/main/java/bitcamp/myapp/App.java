package bitcamp.myapp;

import bitcamp.myapp.handler.HelpMenuHandler;
import bitcamp.myapp.handler.assignment.AssignmentAddHandler;
import bitcamp.myapp.handler.assignment.AssignmentDeleteHandler;
import bitcamp.myapp.handler.assignment.AssignmentListHandler;
import bitcamp.myapp.handler.assignment.AssignmentModifyHandler;
import bitcamp.myapp.handler.assignment.AssignmentRepository;
import bitcamp.myapp.handler.assignment.AssignmentViewHandler;
import bitcamp.myapp.handler.board.BoardAddHandler;
import bitcamp.myapp.handler.board.BoardDeleteHandler;
import bitcamp.myapp.handler.board.BoardListHandler;
import bitcamp.myapp.handler.board.BoardModifyHandler;
import bitcamp.myapp.handler.board.BoardRepository;
import bitcamp.myapp.handler.board.BoardViewHandler;
import bitcamp.myapp.handler.member.MemberAddHandler;
import bitcamp.myapp.handler.member.MemberDeleteHandler;
import bitcamp.myapp.handler.member.MemberListHandler;
import bitcamp.myapp.handler.member.MemberModifyHandler;
import bitcamp.myapp.handler.member.MemberRepository;
import bitcamp.myapp.handler.member.MemberViewHandler;
import bitcamp.myapp.menu.MenuGroup;
import bitcamp.myapp.menu.MenuItem;
import bitcamp.util.Prompt;

public class App {

  public static void main(String[] args) throws Exception {
    Prompt prompt = new Prompt(System.in);
//    new MainMenu(prompt).execute();

    BoardRepository boardRepository = new BoardRepository();
    BoardRepository greeringRepository = new BoardRepository();
    AssignmentRepository assignmentRepository = new AssignmentRepository();
    MemberRepository memberRepository = new MemberRepository();

    MenuGroup mainMenu = new MenuGroup("메인");

    MenuGroup assignmentMenu = new MenuGroup("과제");
    assignmentMenu.add(new MenuItem
        ("등록", new AssignmentAddHandler(assignmentRepository, prompt)));
    assignmentMenu.add(new MenuItem
        ("조회", new AssignmentViewHandler(assignmentRepository, prompt)));
    assignmentMenu.add(new MenuItem
        ("변경", new AssignmentModifyHandler(assignmentRepository, prompt)));
    assignmentMenu.add(new MenuItem
        ("삭제", new AssignmentDeleteHandler(assignmentRepository, prompt)));
    assignmentMenu.add(new MenuItem
        ("목록", new AssignmentListHandler(assignmentRepository)));
    mainMenu.add(assignmentMenu);

    MenuGroup boardMenu = new MenuGroup("게시글");
    boardMenu.add(new MenuItem("등록", new BoardAddHandler(boardRepository, prompt)));
    boardMenu.add(new MenuItem("조회", new BoardViewHandler(boardRepository, prompt)));
    boardMenu.add(new MenuItem("변경", new BoardModifyHandler(boardRepository, prompt)));
    boardMenu.add(new MenuItem("삭제", new BoardDeleteHandler(boardRepository, prompt)));
    boardMenu.add(new MenuItem("목록", new BoardListHandler(boardRepository)));
    mainMenu.add(boardMenu);

    MenuGroup memberMenu = new MenuGroup("회원");
    memberMenu.add(new MenuItem("등록", new MemberAddHandler(memberRepository, prompt)));
    memberMenu.add(new MenuItem("조회", new MemberViewHandler(memberRepository, prompt)));
    memberMenu.add(new MenuItem("변경", new MemberModifyHandler(memberRepository, prompt)));
    memberMenu.add(new MenuItem("삭제", new MemberDeleteHandler(memberRepository, prompt)));
    memberMenu.add(new MenuItem("목록", new MemberListHandler(memberRepository)));
    mainMenu.add(memberMenu);

    MenuGroup greetingMenu = new MenuGroup("가입인사");
    greetingMenu.add(new MenuItem("등록", new BoardAddHandler(greeringRepository, prompt)));
    greetingMenu.add(new MenuItem("조회", new BoardViewHandler(greeringRepository, prompt)));
    greetingMenu.add(new MenuItem("변경", new BoardModifyHandler(greeringRepository, prompt)));
    greetingMenu.add(new MenuItem("삭제", new BoardDeleteHandler(greeringRepository, prompt)));
    greetingMenu.add(new MenuItem("목록", new BoardListHandler(greeringRepository)));
    mainMenu.add(greetingMenu);

    mainMenu.add(new MenuItem("도움말", new HelpMenuHandler()));

    mainMenu.execute(prompt);

    prompt.close();
  }
}
