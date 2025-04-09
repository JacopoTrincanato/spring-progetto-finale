import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css'
import GlobalContext from './contexts/GlobalContext'
import DefaultLayout from './layout/DefaultLayout';

function App() {

  //creo la costante per l'url dell'API
  const apiUrl = import.meta.env.API_URL;

  return (
    <>
      <GlobalContext.Provider value={{ apiUrl }}>
        <BrowserRouter>
          <Routes>
            <Route element={<DefaultLayout />}>
              <Route path='/' />
              <Route path='/optionals' />
            </Route>
          </Routes>
        </BrowserRouter>
      </GlobalContext.Provider>
    </>
  )
}

export default App
