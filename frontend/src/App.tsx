import { styled } from '@mui/joy';
import { Route, Routes } from 'react-router-dom';
import Header from './components/Header.tsx';
import InternalSpace from './pages/InternalSpace.tsx';
import LandingPage from './pages/LandingPage.tsx';
import Login from './pages/Login.tsx';

function App() {
  const Wrapper = styled('div')`
    min-height: 100vh;
    display: grid;
    grid-template-rows: auto 1fr;
  `;

  return (
    <Wrapper>
      <Header />
      <Routes>
        <Route path={'/'} element={<LandingPage />} />
        <Route path={'/login'} element={<Login />} />
        <Route path={'/internal'} element={<InternalSpace />} />
      </Routes>
    </Wrapper>
  );
}

export default App;
