import React from 'react';
import axios from "axios";

function Login() {
  return (
    <div className="container">
      <form action="loginProcess" method="post">
        <br />
        <h1>로그인</h1>
        <br />
        <input type="text" name="username" className="form-control" />
        <br />
        <input type="password" name="password" className="form-control" />
        <br />
        <button type="submit" className="btn btn-success">Login</button>
      </form>
    </div>
  );
}
export default Login;