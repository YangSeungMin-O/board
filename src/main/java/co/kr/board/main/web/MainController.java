package co.kr.board.main.web;

import co.kr.board.main.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class MainController {
  @Autowired
  private MainService service;
  @GetMapping("/api/boardData")
  public List<HashMap<String, Object>> boardData(String searchKey, int page) {
    page = (page-1)*10;
    List<HashMap<String, Object>> boardData = service.getBoardData(searchKey, page);
    return boardData;
  }
  @GetMapping("/api/totalPageCnt")
  public int boardDataCnt(String searchKey) {
    int totalPage = (int)Math.ceil(((double)service.getTotalPage(searchKey))/10);
    return totalPage;
  }
}
