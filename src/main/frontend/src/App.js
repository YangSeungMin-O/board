import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Home from './view/main/main';
import Login from './view/login/login';
import Success from './view/login/success';
import Failure from './view/login/failure';
import Axios from './view/test/axios';

  /*Link를 사용하면 A태그와 달리 새로고침이 없어서 부드러운 전환이 가능하다*/
  /*JS에서 Export할때는 항상 첫글자가 대문자여야 오류가 발생하지 않는다*/

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/loginPage" element={<Login />} />
        <Route path="/successPage" element={<Success />} />
        <Route path="/failurePage" element={<Failure />} />
        <Route path="/axiosPage" element={<Axios />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
