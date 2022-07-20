package co.kr.board.security.service.impl;

import co.kr.board.security.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService {
  @Autowired
  private SecurityMapper securityMapper;
}
