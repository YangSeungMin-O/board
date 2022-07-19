package co.kr.board.security.vo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class SecurityVo implements UserDetails {
  private String userId;
  private String userPw;
  private String userNb;
  private String userName;
  private String userToken;
  private String userRole;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return Collections.singletonList(new SimpleGrantedAuthority(this.userRole));
  }

  @Override
  public String getUsername() {
    return this.userId;
  }

  @Override
  public String getPassword() {
    return this.userPw;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  /* 사용자 번호 */
  public String getUserNb() {
    return userNb;
  }
  public void setUserNb(String userNb) {
    this.userNb = userNb;
  }
  /* 사용자 이름 */
  public String getUserName() {
    return userName;
  }
  public void setUserName(String userName) {
    this.userName = userName;
  }
  /* 사용자 토큰 */
  public String getUserToken() {
    return userToken;
  }
  public void setUserToken(String userToken) {
    this.userToken = userToken;
  }
  /* 사용자 토큰 */
  public String getUserRole() {
    return userRole;
  }
  public void setUserRole(String userRole) {
    this.userRole = userRole;
  }
}
