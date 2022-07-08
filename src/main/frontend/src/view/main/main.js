import { useEffect, useState } from 'react';
import axios from "axios";
import * as main2 from "./main2"

export default function Main() {
    const [list, setList] = useState([]);
    const [searchKey, setSearchKey] = useState([]);

    const onChange = (event) => {
      setSearchKey(event.target.value);
    }

    useEffect(() => {
      getData();
    }, []);

    function getData(searchKey) {
    console.log(searchKey);
      const url = "/api/boardData";
      const result = [];
      axios.get(url, {params : {searchKey: searchKey}})
      .then(function(response) {
        console.log("성공");
        const {data} = response;
        setList(data);
      })
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

  return (
    <div>
      <h1>Board Main</h1>
      <input type="text" placeholder="검색어를 입력하세요" onChange={onChange}/>
      <button type="button" onClick={searchData}>검색</button>
      <table border="1">
        <thead>
        <tr>
          <td>번호</td>
          <td>제목</td>
          <td>내용</td>
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
              <td>{item.board_content}</td>
              <td>{item.board_writer}</td>
              <td>{item.board_reg_date}</td>
              <td>{item.board_chg_date}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  )
}