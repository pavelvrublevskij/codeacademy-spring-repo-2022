import HeaderContainer from './Header';
import FooterContainer from './Footer/FooterContainer';
import './App.css';
import { BrowserRouter } from 'react-router-dom';
import Pages from './Pages';
import { AuthUserContext, initialAuthUserObj } from '../contexts/AuthUserContext';
import { useState } from 'react';
import { saveToSessionStorage, StorageKey } from '../utils/sessionStorage';

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
        <BrowserRouter>
            <div className="mainApp">
                <AuthUserContext.Provider value={authContextValue}>
                    <HeaderContainer />
                    <Pages />
                </AuthUserContext.Provider>
                <FooterContainer />
            </div>
        </BrowserRouter>
    );
}

export default App;
