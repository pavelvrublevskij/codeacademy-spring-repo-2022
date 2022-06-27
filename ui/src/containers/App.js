import HeaderContainer from './Header';
import ContentContainer from './Content';
import FooterContainer from './Footer/FooterContainer';
import './App.css';

function App() {
    return <div className='mainApp'>
        <HeaderContainer />
        <ContentContainer />
        <FooterContainer />
    </div>;
}

export default App;
