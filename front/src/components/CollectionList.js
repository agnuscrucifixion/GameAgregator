import React, { useState, useEffect } from 'react';
import axios from '../api/axiosConfig';

const CollectionList = () => {
    const [collections, setCollections] = useState([]);
    const [userId, setUserId] = useState(1);

    useEffect(() => {
        axios.get(`/api/collections/user/${userId}`)
            .then(response => setCollections(response.data))
            .catch(error => console.error('Error fetching collections:', error));
    }, [userId]);

    return (
        <div>
            <h1>Collection List</h1>
            <ul>
                {collections.map(collection => (
                    <li key={collection.id}>{collection.name}</li>
                ))}
            </ul>
        </div>
    );
};

export default CollectionList;
