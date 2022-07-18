import { useEffect, useState } from 'react';
import { Search } from 'react-bootstrap-icons';
import axios from "axios";

export default function Main() {
/* JS ---------------------------------------------------------------- */
  const [list, setList] = useState([]);
  const [page, setPage] = useState(1);
  const [searchKey, setSearchKey] = useState("");
  const searchKeyChange = (event) => {
    setSearchKey(event.target.value);
  };

  useEffect(() => {
    getData();
  }, []);

  function getData() {
    const url = "/api/boardData";
    axios.get(url, {params: {searchKey: searchKey, page: page}})
    .then(function(response) {
        console.log("성공");
        const {data} = response;
        setList(data);
    })
    .catch(function(error) {
        console.log("실패");
        console.log(error);
    })
  }

  function getTotalPage() {

  }

  function searchData() {
      console.log("검색 시행");
      getData(searchKey)
  }
/* CSS --------------------------------------------------------------- */
  const pageNavStyle = {

  }
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
        <div style={pageNavStyle}>
          <nav aria-label="Page navigation example">
            <ul className="pagination justify-content-center">
              <li className="page-item">
                <a className="page-link" href="#" aria-label="Previous">
                  <span aria-hidden="true">&laquo;</span>
                </a>
              </li>
              <li className="page-item"><a className="page-link" href="#">1</a></li>
              <li className="page-item"><a className="page-link" href="#">2</a></li>
              <li className="page-item"><a className="page-link" href="#">3</a></li>
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