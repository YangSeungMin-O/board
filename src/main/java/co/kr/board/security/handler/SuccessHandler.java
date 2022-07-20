package co.kr.board.security.handler;

import co.kr.board.security.config.JwtTokenProvider;
import co.kr.board.security.vo.SecurityVo;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@Configuration
public class SuccessHandler implements AuthenticationSuccessHandler {
  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
      throws IOException, ServletException {
    System.out.println("로그인 성공 핸들러");
    JwtTokenProvider jwtTokenProvider = new JwtTokenProvider();
    SecurityVo securityVo = (SecurityVo)authentication.getPrincipal();
    String token = jwtTokenProvider.createToken(securityVo.getUsername(), securityVo.getUserRole());
    response.sendRedirect("/loginSuccess?token=" + URLEncoder.encode(token, "UTF-8"));
  }
}
