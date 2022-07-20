package co.kr.board.security.service;

import co.kr.board.security.service.impl.SecurityMapper;
import co.kr.board.security.vo.SecurityVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
  @Autowired
  private SecurityMapper securityMapper;
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    SecurityVo securityVo = securityMapper.getUserAccount(username);
    if(securityVo == null) {
      System.out.println("존재하지 않는 아이디 = " + username);
      throw new UsernameNotFoundException("User not authorized");
    }
    return securityVo;
  }
}
