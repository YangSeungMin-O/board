package co.kr.board.security.config;

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

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.security.Key;
import java.util.Base64;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import static javax.crypto.Cipher.SECRET_KEY;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

  @Resource(name = "securityMapper")
  private SecurityMapper securityMapper;
  private String secretKey = "agefyugeruywgfuyiewrgfyuwegruiyfwgeryufiwgeriuyfgweyurfgwevbfdusbvudfsbvdsuyfvbsdyuvbsdukyvbdusyrfbuykbfuybuwyebfwyeukdbwkuydbqyubxuyqbxyqubxquysbxqyuxsbquysxbqyusxbquykvcuyqvcuqkyvcuqsbyxcuqkbxqysubxqusxbquysxbqycvquxvqusyxvqyuvxkuqvxqubxsquysbxquybxquyb";
  private long tokenValidTime = 30 * 60 * 1000L; // 토큰 유효시간 30

  // 객체 초기화, secretKey를 Base64로 인코딩한다.
  @PostConstruct
  protected void init() {
    secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
  }
  public String createToken(String userPk,  String roles) {
    Claims claims = Jwts.claims().setSubject(userPk); // JWT payload 에 저장되는 정보단위, 보통 여기서 user를 식별하는 값을 넣는다.
    claims.put("roles", roles); // 정보는 key / value 쌍으로 저장된다.
    Date now = new Date();
    return Jwts.builder()
        .setClaims(claims) // 정보 저장
        .setIssuedAt(now) // 토큰 발행 시간 정보
        .setExpiration(new Date(now.getTime() + tokenValidTime)) // set Expire Time
        .signWith(SignatureAlgorithm.HS256, secretKey)  // 사용할 암호화 알고리즘과 // signature 에 들어갈 secret값 세팅
        .compact();
  }
}
