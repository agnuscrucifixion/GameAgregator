import React, { useState, useEffect } from 'react';
import axios from '../api/axiosConfig';

const GameList = () => {
    const [games, setGames] = useState([]);
    const [search, setSearch] = useState('');

    useEffect(() => {
        if (search) {
            axios.get(`/api/games/search?title=${search}`)
                .then(response => setGames(response.data))
                .catch(error => console.error('Error fetching games:', error));
        } else {
            axios.get('/api/games')
                .then(response => setGames(response.data))
                .catch(error => console.error('Error fetching games:', error));
        }
    }, [search]);

    return (
        <div>
            <h1>Game List</h1>
            <input
                type="text"
                value={search}
                onChange={(e) => setSearch(e.target.value)}
                placeholder="Search games..."
            />
            <ul>
                {games.map(game => (
                    <li key={game.id}>{game.title}</li>
                ))}
            </ul>
        </div>
    );
};

export default GameList;
