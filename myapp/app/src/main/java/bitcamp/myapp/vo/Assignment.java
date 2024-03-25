package bitcamp.myapp.vo;

import lombok.*;

import java.io.Serializable;
import java.sql.Date;

@NoArgsConstructor // 파라미터가 없는 기본 생성자 만들어줘
//@RequiredArgsConstructor // final이 있으면 final을 받는 필수 생성자 만들어줘
//@AllArgsConstructor // 모든 생성자 만들어줘
@Data
public class Assignment implements Serializable {

  private static final long serialVersionUID = 100L;

  private int no;
  private String title;
  private String content;
  private Date deadline;


}
