package co.kr.board.security.config;

import co.kr.board.security.vo.SecurityVo;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;

@Component
public class AuthorizationChecker {
  public boolean check(HttpServletRequest request, Authentication authentication) {
    SecurityVo securityVo = new SecurityVo();
    String userUrl = request.getRequestURI().toString();
    System.out.println("요청 URL = " + userUrl);
    if (userUrl.equals("/loginSuccess")) {
      return true;
    }
    return false;
  }
}

