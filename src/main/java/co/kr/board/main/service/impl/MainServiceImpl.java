package co.kr.board.main.service.impl;

import co.kr.board.main.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class MainServiceImpl implements MainService {
  @Autowired
  private MainMapper mapper;
  @Override
  public int getCount() {
    return mapper.getCount();
  }

  @Override
  public List<HashMap<String, Object>> getBoardData(String searchKey) {
    return mapper.getBoardData(searchKey);
  }
}
