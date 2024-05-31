import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import UserList from './components/UserList';
import GameList from './components/GameList';
import CollectionList from './components/CollectionList';
import FileHandler from "./components/FileHandler";

function App() {
    return (
        <Router>
            <div className="App">
                <Switch>
                    <Route path="/users" component={UserList}/>
                    <Route path="/games" component={GameList}/>
                    <Route path="/collections" component={CollectionList}/>
                    <FileHandler/>

                </Switch>
            </div>
        </Router>
    );

}

export default App;
