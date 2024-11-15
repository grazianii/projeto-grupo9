import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';

function ReceitasList() {
  const [receitas, setReceitas] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8081/api/receitas')
      .then(response => setReceitas(response.data))
      .catch(error => console.error('Erro ao buscar receitas:', error));
  }, []);

  return (
    <div>
      <h2>Receitas</h2>
      <ul>
        {receitas.map(receita => (
          <li key={receita.id}>
            <Link to={`/receitas/${receita.id}`}>{receita.nome}</Link>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default ReceitasList;
