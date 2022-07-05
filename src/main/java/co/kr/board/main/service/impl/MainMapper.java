package co.kr.board.main.service.impl;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

@Mapper
public interface MainMapper {
  public int getCount();
}
