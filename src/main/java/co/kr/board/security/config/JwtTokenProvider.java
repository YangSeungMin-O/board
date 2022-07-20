package co.kr.board.security.config;

import co.kr.board.security.service.CustomUserDetailsService;
import co.kr.board.security.service.SecurityService;
import co.kr.board.security.service.impl.SecurityMapper;
import co.kr.board.security.vo.SecurityVo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.security.Key;
import java.util.Base64;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import static javax.crypto.Cipher.SECRET_KEY;

@Component
public class JwtTokenProvider {

  @Autowired
  private CustomUserDetailsService customUserDetailsService;

  @Autowired
  private SecurityMapper securityMapper;

  public String createToken(String username, String userAuth) {
    System.out.println(username);
    System.out.println(userAuth);
    return "";
  }

}
