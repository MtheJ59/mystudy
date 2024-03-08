package companyChart.myapp.vo;

import java.io.Serializable;
import java.util.Date;

public class Department implements Serializable {

  private static final long serialVersionUID = 100L;

  private int no;
  private String title;
  private String content;
  private Date createdDate;

  @Override
  public String toString() {
    return "Board{" +
        "no=" + no +
        ", title='" + title + '\'' +
        ", content='" + content + '\'' +
        ", createdDate=" + createdDate +
        '}';
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }
}
