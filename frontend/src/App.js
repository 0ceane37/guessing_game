import React, { useState } from 'react';
import './App.css';

function App() {
  const [guess, setGuess] = useState('');
  const [message, setMessage] = useState('Devinez un nombre entre 1 et 100');
  const [attempts, setAttempts] = useState(0);

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await fetch('http://localhost:8080/api/game/verify', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          'Access-Control-Allow-Origin': '*'
        },
        body: JSON.stringify({ guess: parseInt(guess) }),
      });
      const data = await response.json();
      setMessage(data.message);
      setAttempts(prev => prev + 1);
      if (data.isCorrect) {
        setAttempts(0);
      }
    } catch (error) {
      setMessage('Erreur de connexion au serveur');
    }
    setGuess('');
  };

  return (
    <div className="App">
      <header className="App-header">
        <h1>Jeu de Devinettes</h1>
        <p>{message}</p>
        <form onSubmit={handleSubmit}>
          <input
            type="number"
            value={guess}
            onChange={(e) => setGuess(e.target.value)}
            placeholder="Entrez un nombre"
          />
          <button type="submit">Deviner</button>
        </form>
        <p>Nombre d'essais : {attempts}</p>
      </header>
    </div>
  );
}

export default App;