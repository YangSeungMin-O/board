package co.kr.board.main.service;

import java.util.HashMap;
import java.util.List;

public interface MainService {
  public int getCount();

  public List<HashMap<String, Object>> getBoardData();
}
