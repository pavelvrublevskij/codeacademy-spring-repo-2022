import { Route, Routes, Navigate } from 'react-router-dom';
import HomePage from './HomePage/HomePage';
import NewProductPage from './NewProductPage/NewProductPage';
import ProductPage from './ProductPage/ProductPage';
import ProductsPage from './ProductsPage';
import CartPage from './CartPage/CartPage';
import LoginPage from './LoginPage/LoginPage';
import { useSelector } from 'react-redux';
import Currency from './Currency/Currency';

const Pages = () => {
    const userRoles = useSelector(state => state.user.roles);
    const adminAuthorized = userRoles.includes('ROLE_ADMIN');

    return (
        <Routes>
            <Route path='/' element={<HomePage />} />
            <Route path='/products' element={<ProductsPage />} />
            {
                adminAuthorized
                    ? <Route path='/products/create'
                             element={<NewProductPage />} />
                    : <Route path='/products/create'
                             element={
                                 <Navigate to={{
                                     pathname: '/login',
                                 }} />
                             } />
            }
            <Route path='/products/:productId' element={<ProductPage />} />

            <Route path='/cart' element={<CartPage />} />
            <Route path='/login' element={<LoginPage />} />
            <Route path="/currencies" element={<Currency />} />
        </Routes>
    );
};

export default Pages;
