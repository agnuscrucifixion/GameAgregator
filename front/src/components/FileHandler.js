import React, { useState } from 'react';
import useWebSocket from 'react-use-websocket';

const FileHandler = () => {
    const [fileName, setFileName] = useState('');
    const { sendMessage, lastMessage } = useWebSocket('ws://localhost:8080/download', {
        onOpen: () => console.log('WebSocket connection established'),
        onClose: () => console.log('WebSocket connection closed'),
        onError: (error) => console.error('WebSocket error:', error),
        shouldReconnect: (closeEvent) => true,
    });

    const handleDownload = () => {
        sendMessage(fileName);
    };

    const handleDelete = () => {
        fetch(`http://localhost:8080/api/games/delete/${fileName}`, {
            method: 'DELETE',
        })
            .then((response) => {
                if (response.ok) {
                    alert('File deleted successfully');
                } else {
                    alert('File not found');
                }
            })
            .catch((error) => {
                console.error('Error:', error);
            });
    };

    React.useEffect(() => {
        if (lastMessage !== null) {
            const blob = new Blob([lastMessage.data], { type: 'application/octet-stream' });
            const link = document.createElement('a');
            link.href = window.URL.createObjectURL(blob);
            link.download = fileName;
            link.click();
        }
    }, [lastMessage, fileName]);

    return (
        <div>
            <h1>Download and Delete File</h1>
            <input
                type="text"
                value={fileName}
                onChange={(e) => setFileName(e.target.value)}
                placeholder="Enter file name"
            />
            <button onClick={handleDownload}>Download</button>
            <button onClick={handleDelete}>Delete</button>
        </div>
    );
};

export default FileHandler;