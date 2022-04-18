import './App.css';
import Dashboard from './pages/dashboard/Dashboard';
import {BrowserRouter} from "react-router-dom";

function App() {


    return (
        <BrowserRouter>
            <div className="App">
                <h1> Welcome WAA </h1>
                <Dashboard/>

            </div>
        </BrowserRouter>
    );
}

export default App;
