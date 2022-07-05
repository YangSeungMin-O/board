import React, { useEffect, useState } from 'react';

function Login() {
  return (
    <div>
      <form action="loginProcess" method="post">
        <h1>Login</h1>
        <input type="text" name="username" />
        <br />
        <input type="password" name="password" />
        <br />
        <button type="submit">Login</button>
      </form>
    </div>
  );
}
export default Login;