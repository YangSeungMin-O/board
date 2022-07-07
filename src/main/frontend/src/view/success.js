import { useNavigate } from 'react-router-dom';
import React from 'react';

function Success() {
  let navigate = useNavigate();
  return (
    <div>
      <h1>로그인 성공</h1>
    </div>
  )
}
export default Success;
