import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import AppRouter from "./router/menu";



class App extends Component {
    wsConnection;
    state = {
      greeting: "", connected: false
    }


    connect = () => {
        this.wsConnection = new WebSocket('ws://localhost:8080/name');
        this.wsConnection.onmessage = (data) => {
            this.showGreeting(data.data);
        };
        this.setConnected(true);
    };

    setConnected(connected) {
        this.setState({
            connected: connected
        });
    }

    disconnect = () => {
        if (this.wsConnection != null) {
            this.wsConnection.close();
        }
        this.setConnected(false);
        console.log("Disconnected");
    }

    sendName = () => {
        if (this.wsConnection != null) {
            this.wsConnection.send(this.state.name);
        }
    }

    showGreeting = (message) => {
      this.setState({
          greetings: message
      });
    }

    handleChange = name => event => {
        this.setState({
            [name]: event.target.value,
        });
    };

    render() {
        return (
            <AppRouter></AppRouter>
        );
    }


}

export default App;
