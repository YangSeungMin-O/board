import { useEffect, useState } from 'react';
import axios from "axios";
//import * as main2 from "./main2"

export default function Main() {
    /* 데이터 리스트 */
    const [list, setList] = useState([]);
    /* 페이지 번호 */
    const [page, setPage] = useState(1);
    /* 페이지 번호 총 갯수 */
    const [totalPage, setTotalPage] = useState([]);
    /* 페이지 전환 시 */
    const pageChange = (event) => {
      setPage(event.target.value);
    }
    /* 검색키워드 */
    const [searchKey, setSearchKey] = useState([]);
    /* 검색키워드 변경 시 실시간 반영 */
    const searchKeyChange = (event) => {
      setSearchKey(event.target.value);
    }
    /* 맨처음 리스트 불러오기 */
    useEffect(() => {
      getData();
    }, [page]);

    function getData(searchKey) {
      const url = "/api/boardData";
      const url2 = "/api/boardDataCnt";
      const result = [];
      axios.all([axios.get(url,{params : { searchKey: searchKey, page: page }}), axios.get(url2,{params : { searchKey: searchKey, page: page }})])
      .then(
        axios.spread((response, response2) => {
          const {data} = response;
          setList(data);
          setTotalPage(Math.ceil(response2.data/10));
        })
      )
      .catch(function(error) {
        console.log("실패");
        alert("데이터를 가져오는데 실패하였습니다")
      })
      return result;
    }

   function searchData() {
      console.log("검색 시행");
      getData(searchKey)
   }

   function createPageNumber() {
      var pageArr = [];
      for (let i = 0; i < totalPage; i++) {
        pageArr.push(<button key={i+1} value={i+1} onClick={pageChange}>{i+1}</button>);
      }
      return pageArr;
   }

  return (
    <div>
      <h1>Board Main</h1>
      <input type="text" placeholder="검색어를 입력하세요" onChange={searchKeyChange}/>
      <button type="button" onClick={searchData}>검색</button>
      <table border="1">
        <thead>
        <tr>
          <td>번호</td>
          <td>제목</td>
          <td>작성자</td>
          <td>작성일</td>
          <td>수정일</td>
        </tr>
        </thead>
        <tbody>
          {list.map((item) => (
            <tr key={item.board_no}>
              <td>{item.board_no}</td>
              <td>{item.board_title}</td>
              <td>{item.board_writer}</td>
              <td>{item.board_reg_date}</td>
              <td>{item.board_chg_date}</td>
            </tr>
          ))}
        </tbody>
      </table>
      <div>
        {createPageNumber()}
      </div>
    </div>
  )
}