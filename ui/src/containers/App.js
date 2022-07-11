import HeaderContainer from './Header';
import FooterContainer from './Footer/FooterContainer';
import './App.css';
import { BrowserRouter } from 'react-router-dom';
import Pages from './Pages';
import { AuthUserContext, initialAuthUserObj } from '../contexts/AuthUserContext';
import { useState } from 'react';
import { saveToSessionStorage, StorageKey } from '../utils/sessionStorage';
import "../i18n"
import { CartContext, initialCartObj } from '../contexts/CartContext';
import { Provider } from 'react-redux';
import store from '../redux/store';

function App() {

    const [authUser, setAuthUser] = useState(initialAuthUserObj)
    const [cart, setCart] = useState(initialCartObj)

    const authContextValue = {
        authUser,
        putAuthUser: (data) => {  // data = { username: '', fullname: '', jwtToken: ''}
            setAuthUser(data)
            saveToSessionStorage(StorageKey.jwt, data.jwtToken)
        },
    }

    const cartContextValue = {
        cart,
        addCartProduct: (product) => {
            const cartItems = [...cart.items];  // kopijavimas
            const existingProduct = cartItems.find(p => p.id === product.id);

            if (existingProduct) {
                existingProduct.itemCount++
            } else {
                cartItems.push({...product, itemCount: 1})
            }

            const cartState = {
                items: cartItems
            }

            setCart(cartState);

            saveToSessionStorage(StorageKey.cart, cartState)
        }
    }

    return (
        <Provider store={store}>
            <BrowserRouter>
                <div className='mainApp'>
                    <AuthUserContext.Provider value={authContextValue}>
                        <CartContext.Provider value={cartContextValue}>
                            <HeaderContainer />
                            <Pages />
                        </CartContext.Provider>
                    </AuthUserContext.Provider>
                    <FooterContainer />
                </div>
            </BrowserRouter>
        </Provider>
    );
}

export default App;
