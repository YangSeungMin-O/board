import React from 'react';
import axios from "axios";

function Main() {
  return (
    <div>
      <h1>Board Main</h1>
      <table>
        <tr>
          <td>번호</td>
          <td>제목</td>
          <td>내용</td>
          <td>작성자</td>
          <td>작성일</td>
        </tr>
      </table>
    </div>
  )
}
export default Main;
