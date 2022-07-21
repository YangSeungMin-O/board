package co.kr.board.security.service.impl;

import co.kr.board.security.vo.SecurityVo;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SecurityMapper {
  SecurityVo getUserAccount(String username);
}
