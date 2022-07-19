package co.kr.board.security.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SecurityController {

  @GetMapping("/loginPage")
  public String loginPage() {
    return "loginPage.html";
  }

  @GetMapping("/loginFailure")
  public String loginFailure(String errorMessage) {
    System.out.println(errorMessage);
    return errorMessage;
  }

  @GetMapping("/loginSuccess")
  public String loginSuccess(String token) {
    System.out.println("로그인 성공 컨트롤러");
    System.out.println(token);
    return "/";
  }
}
