import HeaderContainer from './Header';
import FooterContainer from './Footer/FooterContainer';
import './App.css';
import { BrowserRouter } from 'react-router-dom';
import Pages from './Pages';
import { AuthUserContext, initialAuthUserObj } from '../contexts/AuthUserContext';
import { useState } from 'react';
import { saveToSessionStorage, StorageKey } from '../utils/sessionStorage';
import "../i18n"
import { Provider } from 'react-redux';
import store from '../redux/store';

function App() {

    const [authUser, setAuthUser] = useState(initialAuthUserObj)

    const authContextValue = {
        authUser,
        putAuthUser: (data) => {  // data = { username: '', fullname: '', jwtToken: ''}
            setAuthUser(data)
            saveToSessionStorage(StorageKey.jwt, data.jwtToken)
        },
    }

    return (
        <Provider store={store}>
            <BrowserRouter>
                <div className='mainApp'>
                    <AuthUserContext.Provider value={authContextValue}>
                        <HeaderContainer />
                        <Pages />
                    </AuthUserContext.Provider>
                    <FooterContainer />
                </div>
            </BrowserRouter>
        </Provider>
    );
}

export default App;
