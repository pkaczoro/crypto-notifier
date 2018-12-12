import React from "react";
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import Test from "../test/test";
import KuCoin from "../kucoin/kucoin";

const TestMenuItem = () => <Test />;
const KuCoinMenuItem = () => <KuCoin />;
const Users = () => <h2>Users</h2>;

const AppRouter = () => (
    <Router>
        <div>
            <nav>
                <ul>
                    <li>
                        <Link to="/KuCoin/">Home</Link>
                    </li>
                    <li>
                        <Link to="/KuCoin/">KuCoin</Link>
                    </li>
                    <li>
                        <Link to="/Test/">Test</Link>
                    </li>
                </ul>
            </nav>

            <Route path="/" exact component={KuCoinMenuItem} />
            <Route path="/KuCoin/" component={KuCoinMenuItem} />
            <Route path="/Test/" component={TestMenuItem} />
        </div>
    </Router>
);

export default AppRouter;