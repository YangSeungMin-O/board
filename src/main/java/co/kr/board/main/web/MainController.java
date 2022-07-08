package co.kr.board.main.web;

import co.kr.board.main.service.MainService;
import co.kr.board.main.service.impl.MainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;

@RestController
public class MainController {
  @Autowired
  private MainService service;
  @GetMapping("/api/hello")
  public String hello() {
    int a = service.getCount();
    System.out.println(a);
    return "안녕하세요 리액트와 스프링부트를 Proxy 설정을 통해 연결하고 있습니다 : " + a + "입니다";
  }

  @GetMapping("/api/boardData")
  public List<HashMap<String, Object>> boardData(String searchKey) {

    List<HashMap<String, Object>> boardData = service.getBoardData(searchKey);
    System.out.println(boardData);

    return boardData;
  }
}
