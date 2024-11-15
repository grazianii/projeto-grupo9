import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import ReceitasList from './components/ReceitasList';
import ReceitaDetails from './components/ReceitaDetails';

function App() {
  return (
    <Router>
      <div>
        <h1>Portal de Receitas</h1>
        <Routes>
          <Route path="/" element={<ReceitasList />} />
          <Route path="/receitas/:id" element={<ReceitaDetails />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
