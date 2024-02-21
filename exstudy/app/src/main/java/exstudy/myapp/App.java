package exstudy.myapp;

import exstudy.menu.BoardMenu;
import exstudy.menu.HelpMenu;
import exstudy.menu.MainMenu;
import exstudy.menu.MemberMenu;
import exstudy.menu.MenuGroup;
import exstudy.menu.MenuItem;
import exstudy.myapp.assignment.AssignmentAddHandler;
import exstudy.myapp.assignment.AssignmentDeleteHandler;
import exstudy.myapp.assignment.AssignmentListHandler;
import exstudy.myapp.assignment.AssignmentModifyHandler;
import exstudy.myapp.assignment.AssignmentRepository;
import exstudy.myapp.assignment.AssignmentViewHandler;
import exstudy.util.Prompt;

public class App {

    public static void main(String[] args) {
    Prompt prompt = new Prompt(System.in);
    new MainMenu(prompt).execute();

        AssignmentRepository assignmentRepository = new AssignmentRepository();

        MenuGroup mainMenu = new MenuGroup("메인");

        MenuGroup assignmentMenu = new MenuGroup("과제");
        assignmentMenu.add(new MenuItem("등록", new AssignmentAddHandler(prompt, assignmentRepository)));
        assignmentMenu.add(new MenuItem("조회", new AssignmentViewHandler(prompt, assignmentRepository)));
        assignmentMenu.add(new MenuItem("변경", new AssignmentModifyHandler(prompt, assignmentRepository)));
        assignmentMenu.add(new MenuItem("삭제", new AssignmentDeleteHandler(prompt, assignmentRepository)));
        assignmentMenu.add(new MenuItem("목록", new AssignmentListHandler(assignmentRepository)));
        mainMenu.add(assignmentMenu);

        BoardMenu boardMenu = new BoardMenu("게시판", this.prompt);
        BoardMenu greetingMenu = new BoardMenu("가입인사", this.prompt);
        MemberMenu memberMenu = new MemberMenu("회원", this.prompt);
        HelpMenu helpMenu = new HelpMenu("도움말", this.prompt);

        mainMenu.execute(prompt);


    prompt.close();
    }
}
