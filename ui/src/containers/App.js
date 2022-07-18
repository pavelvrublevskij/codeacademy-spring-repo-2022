import HeaderContainer from './Header';
import FooterContainer from './Footer/FooterContainer';
import './App.css';
import { BrowserRouter } from 'react-router-dom';
import Pages from './Pages';
import "../i18n"
import { Provider } from 'react-redux';
import store from '../redux/store';
import "../validation"
import Label from '../components/training/typescript/Label/Label';
import { useState } from 'react';

function App() {

    const [labelClickedText, setLabelClickedText] = useState('')

    const handleOnClick = () => {
        setLabelClickedText('Label clicked!');
    }

    return (
        <Provider store={store}>
            <BrowserRouter>
                <div className='mainApp'>
                    {/*<Label text={'Labas TS'} onClick={handleOnClick}/>*/}
                    {/*<span>{labelClickedText}</span>*/}
                    <HeaderContainer />
                    <Pages />
                    <FooterContainer />
                </div>
            </BrowserRouter>
        </Provider>
    );
}

export default App;
