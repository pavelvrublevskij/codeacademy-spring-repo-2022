import HeaderContainer from './Header';
import {
    Routes,
    Route,
} from "react-router-dom";
import FooterContainer from './Footer/FooterContainer';
import './App.css';
import { BrowserRouter } from 'react-router-dom';
import HomePage from './Pages/HomePage/HomePage';
import NewProductPage from './Pages/NewProductPage/NewProductPage';
import ProductPage from './Pages/ProductPage/ProductPage';

function App() {
    return (
        <BrowserRouter>
            <div className='mainApp'>
                <HeaderContainer />
                <Routes>
                    <Route path='/' element={ <HomePage /> } />
                    <Route path='/products/create' element={ <NewProductPage /> } />
                    <Route path='/products/:productId' element={ <ProductPage /> } />
                </Routes>
                <FooterContainer />
            </div>
        </BrowserRouter>
    );
}

export default App;
