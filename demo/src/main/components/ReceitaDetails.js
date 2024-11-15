import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import axios from 'axios';

function ReceitaDetails() {
  const { id } = useParams();
  const [receita, setReceita] = useState(null);

  useEffect(() => {
    axios.get(`http://localhost:8081/api/receitas/${id}`)
      .then(response => setReceita(response.data))
      .catch(error => console.error('Erro ao buscar detalhes da receita:', error));
  }, [id]);

  if (!receita) return <p>Carregando...</p>;

  return (
    <div>
      <h2>{receita.nome}</h2>
      <p><strong>Descrição:</strong> {receita.descricao}</p>
      <p><strong>Ingredientes:</strong> {receita.ingredientes}</p>
      <p><strong>Modo de Preparo:</strong> {receita.modoPreparo}</p>
    </div>
  );
}

export default ReceitaDetails;
