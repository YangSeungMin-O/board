import { useEffect, useState } from 'react';
import axios from "axios";

export default function Main() {
/* JS ---------------------------------------------------------------- */
  const [totalPage, setTotalPage] = useState([]);
  const [page, setPage] = useState(1);
  const pageChange = (event) => {
    setPage(event.target.text);
  }
  const [list, setList] = useState([]);
  const [searchKey, setSearchKey] = useState("");
  const searchKeyChange = (event) => {
    setSearchKey(event.target.value);
  };

  useEffect(() => {
    getTotalPage();
  }, []);

  useEffect(() => {
    getData();
  }, [page]);

  function getData() {
    const url = "/api/boardData";
    axios.get(url, {params: {searchKey: searchKey, page: page}})
    .then(function(response) {
        console.log("데이터 가져오기 성공");
        const {data} = response;
        setList(data);
    })
    .catch(function(error) {
        console.log("데이터 가져오기 실패");
        console.log(error);
    })
  }

  function getTotalPage() {
    const url = "/api/totalPageCnt";
    axios.get(url, {params: {searchKey: searchKey}})
    .then(function(response) {
        console.log("totalPage 가져오기 성공");
        let pageArray = [];
        for (let i = 0; i < response.data; i++) {
          pageArray.push(i);
        }
        setTotalPage(pageArray);
    })
    .catch(function(error) {
        console.log("totalPage 가져오기 실패");
        console.log(error);
    })
  }

  function searchData() {
      console.log("검색 시행");
      setPage(1);
      getData(searchKey);
      getTotalPage(searchKey);
  }
/* CSS --------------------------------------------------------------- */
  const insertBtnStyle = {
    display: 'inline-block',
    float: 'right'
  }
  const searchInputStyle = {
    float: 'right',
    width: '25%'
  }
  const searchBtnStyle = {
      float: 'right'
  }
  return (
    <div>
      <div className="container">
        <br/>
        <h1>Board</h1>
        <button type="button" className="btn btn-success" style={searchBtnStyle} onClick={searchData}>검색</button>
        <input type="text" className="form-control" style={searchInputStyle} placeholder="검색어 입력" onChange={searchKeyChange}></input>
        <table className="table table-hover text-center">
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
          <nav aria-label="Page navigation example">
            <ul className="pagination justify-content-center">
              <li className="page-item">
                <a className="page-link" href="#" aria-label="Previous">
                  <span aria-hidden="true">&laquo;</span>
                </a>
              </li>
              <ul id="pageNum" className="pagination justify-content-center">
                {totalPage.map((item) => (
                  <li key={item+1} className="page-item"><a className="page-link" href="#" onClick={pageChange} value={item+1}>{item+1}</a></li>
                ))}
              </ul>
              <li className="page-item">
                <a className="page-link" href="#" aria-label="Next">
                  <span aria-hidden="true">&raquo;</span>
                </a>
              </li>
            </ul>
          </nav>
        </div>
        <div style={insertBtnStyle}>
          <button type="button" className="btn btn-success">게시물 등록</button>
        </div>
      </div>
    </div>
  )
}