package co.kr.board.security.handler;

import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

public class FailureHandler implements AuthenticationFailureHandler {

  @Override
  public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
      throws IOException, ServletException {
    System.out.println("로그인 실패");
    String errorMessage;

    if(exception instanceof AuthenticationServiceException) {
      errorMessage = "시스템에 오류가 발생했습니다";
    }
    else if(exception instanceof BadCredentialsException) {
      errorMessage = "아이디 또는 비밀번호가 일치하지 않습니다";
    }
    else if(exception instanceof DisabledException) {
      errorMessage = "비활성화된 계정";
    }
    else if(exception instanceof LockedException) {
      errorMessage = "잠금처리된 계정";
    }
    else if(exception instanceof AccountExpiredException) {
      errorMessage = "만료된 계정";
    }
    else if(exception instanceof CredentialsExpiredException) {
      errorMessage = "비밀번호가 만료된 계정";
    } else{
      errorMessage = "계정을 찾을 수 없습니다";
    }

    response.sendRedirect("/loginFailure?errorMessage=" + URLEncoder.encode(errorMessage, "UTF-8"));
  }
}
