package co.kr.board.security.config;

import co.kr.board.security.service.CustomUserDetailsService;
import co.kr.board.security.service.impl.SecurityMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtTokenProvider {
  /*@Value("${secretKey}")*/
  private String secretKey = "jsdfgneuirvnuiefbvihbfhsdbvhjfsdbvyusekryvbfskdjfvhbsyvukrehjbsfvyuskhdbchdsj";
  public String createToken(String username, String userAuth) {
    Long expiredTime = 1000 * 60L * 60L * 2L; // 토큰 유효 시간 (2시간)
    Date ext = new Date(); // 토큰 만료 시간
    ext.setTime(ext.getTime() + expiredTime);

    String token = Jwts.builder()
        .claim("username", username) //토큰에 들어갈 정보 1
        .claim("userAuth", userAuth) //토큰에 들어갈 정보2
        .setIssuer("YangSeungMin") //토큰 생성자
        .setSubject("Test") //토큰 용도
        .setExpiration(ext) //토큰 만료 시간 설정
        .signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encodeToString(secretKey.getBytes())) // 알고리즘, 시크릿 키
        .compact(); // 토큰 생성
    return token;
  }
}
