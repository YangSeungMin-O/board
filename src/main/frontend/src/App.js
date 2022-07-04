import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import Home from './view/home';
import About from './view/about';
import Profile from './view/profile';

  /*Link를 사용하면 A태그와 달리 새로고침이 없어서 부드러운 전환이 가능하다*/
  /*JS에서 Export할때는 항상 첫글자가 대문자여야 오류가 발생하지 않는다*/

function App() {
  return (
  <BrowserRouter>
  <nav>
    <Link to='/'>Home</Link>
    <Link to='/about'>About</Link>
    <Link to='/profile'>Profile</Link>
  </nav>
    <header>----------------------------------</header>
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/about" element={<About />} />
      <Route path="/profile" element={<Profile />} />
    </Routes>
    <footer>----------------------------------</footer>
  </BrowserRouter>
  );
}

export default App;
