import { useEffect, useState } from 'react';
import { ArchiveFill, MicFill, CameraVideo, Inboxes, Bell, PersonCircle } from 'react-bootstrap-icons';
import axios from "axios";

export default function Main() {
/* JS ---------------------------------------------------------------- */
  const [list, setList] = useState([]);

  useEffect(() => {
    getData();
  }, []);

  const getData = () => {
    console.log("Hello World!")
  }
/* CSS --------------------------------------------------------------- */
  const pageNavStyle = {
    float: 'left'
  }
  const insertBtnStyle = {
    float: 'right'
  }
  const searchInputStyle = {
    float: 'right',
    width: '15%'
  }
  return (
    <div>
      <div className="container">
        <br/>
        <h1>Board</h1>
        <input type="text" className="form-control" style={searchInputStyle} placeholder="검색어 입력"></input>
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
            <tr>
              <td>1</td>
              <td>2</td>
              <td>3</td>
              <td>4</td>
              <td>5</td>
            </tr>
            <tr>
              <td>1</td>
              <td>2</td>
              <td>3</td>
              <td>4</td>
              <td>5</td>
            </tr>
            <tr>
              <td>1</td>
              <td>2</td>
              <td>3</td>
              <td>4</td>
              <td>5</td>
            </tr>
            <tr>
              <td>1</td>
              <td>2</td>
              <td>3</td>
              <td>4</td>
              <td>5</td>
            </tr>
            <tr>
              <td>1</td>
              <td>2</td>
              <td>3</td>
              <td>4</td>
              <td>5</td>
            </tr>
            <tr>
              <td>1</td>
              <td>2</td>
              <td>3</td>
              <td>4</td>
              <td>5</td>
            </tr>
          </tbody>
        </table>
        <div style={pageNavStyle}>
          <nav aria-label="Page navigation example">
            <ul className="pagination">
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
        <button type="button" className="btn btn-success" style={insertBtnStyle}>게시물 등록</button>
      </div>
    </div>
  )
}