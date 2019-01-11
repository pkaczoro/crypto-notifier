import React, {Component} from 'react';
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';


class Test extends Component {
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
          <div className="App">
            <header className="App-header">
                <div>{this.state.greetings}</div>
                <div> connected: {this.state.connected ? "yes": "no"} </div>
                <Button variant="contained" color="primary" onClick={this.connect}>
                    Connect
                </Button>
                <Button variant="contained" color="primary" onClick={this.disconnect}>
                    Disconnect
                </Button>

                <TextField
                    id="standard-name"
                    label="Message value"
                    value={this.state.name}
                    onChange={this.handleChange('name')}
                    margin="normal"
                />
                <Button variant="contained" color="primary" onClick={this.sendName}>
                    Send message
                </Button>
            </header>


          </div>
        );
    }
}

export default Test;
