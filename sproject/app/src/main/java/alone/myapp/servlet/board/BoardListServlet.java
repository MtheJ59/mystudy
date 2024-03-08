package alone.myapp.servlet.board;

import alone.myapp.dao.BoardDao;
import alone.myapp.vo.Board;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/board/list")
public class BoardListServlet extends GenericServlet {

  private BoardDao boardDao;

  @Override
  public void init() {
    this.boardDao = (BoardDao) this.getServletContext().getAttribute("boardDao");
  }

  @Override
  public void service(ServletRequest servletRequest, ServletResponse servletResponse)
      throws ServletException, IOException {

    int category = Integer.valueOf(servletRequest.getParameter("category"));
    String title;
    if (category == 1) {
      title = "게시글";
    } else if (category == 2) {
      title = "가입인사";
    } else if (category == 3) {
      title = "잡담";
    } else if (category == 4) {
      title = "이벤트";
    } else {
      title = null;
    }

    servletResponse.setContentType("text/html;charset=UTF-8");
    PrintWriter out = servletResponse.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html lang='en'>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>비트캠프 데브옵스 5기</title>");
    out.println("</head>");
    out.println("<body>");
    out.printf("<h1>%s</h1>\n", title);

    out.printf("<a href='/board/form?category=%d'>새 글</a>\n", category);

    try {
      out.println("<table border='1'>");
      out.println("    <thead>");
      out.println("    <tr> <th>번호</th> <th>제목</th> <th>작성자</th> <th>등록일</th> <th>첨부파일</th> </tr>");
      out.println("    </thead>");
      out.println("    <tbody>");

      List<Board> list = boardDao.findAll(category);

      for (Board board : list) {
        out.printf(
            "<tr> <td>%d</td> <td><a href='/board/view?category=%d&no=%1$d'>%s</a></td> <td>%s</td> <td>%s</td> <td>%d</td> </tr>\n",
            board.getNo(),
            category,
            board.getTitle(),
            board.getWriter().getName(),
            board.getCreatedDate(),
            board.getFileCount());
      }

      out.println("    </tbody>");
      out.println("</table>");

    } catch (Exception e) {
      out.println("<p>목록 오류!</p>");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
    }

    out.println("</body>");
    out.println("</html>");
  }
}
