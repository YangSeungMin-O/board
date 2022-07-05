package co.kr.board.main.service.impl;

import co.kr.board.main.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MainServiceImpl implements MainService {
  private MainMapper mapper;

  @Override
  public int getCount() {
    return mapper.getCount();
  }
}
