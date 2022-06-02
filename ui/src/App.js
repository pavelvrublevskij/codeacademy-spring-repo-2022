import logo from './logo.svg';
import './App.css';
import MyAwesomeComponent from "./components/MyAwesomeComponent";
import ButtonWithText from "./components/ButtonWithText";

function App() {
  return (
    <div className="App"><header className="App-header">
      <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
        <MyAwesomeComponent name="World"/>
        <ButtonWithText/>
      </header>
    </div>
  );
}

export default App;
