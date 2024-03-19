package bitcamp.app1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/c02_2")
public class Controller02_2 {

  // 테스트 방법:
  // => http://localhost:9999/eomcs-spring-webmvc/html/app1/c02_1.html

  @GetMapping // GET 요청일 때만 호출된다.
  @ResponseBody
  public String handler1() {
    return "get";
  }

  @PostMapping // POST 요청일 때만 호출된다.
  @ResponseBody
  public String handler2() {
    return "post";
  }
}
