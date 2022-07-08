package co.kr.board.main.service.impl;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface MainMapper {
  public int getCount();

  public List<HashMap<String, Object>> getBoardData(String searchKey);
}
