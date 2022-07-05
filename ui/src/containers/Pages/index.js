import { Route, Routes } from 'react-router-dom';
import HomePage from './HomePage/HomePage';
import NewProductPage from './NewProductPage/NewProductPage';
import ProductPage from './ProductPage/ProductPage';
import ProductsPage from './ProductsPage/ProductsPage';
import CartPage from './CartPage/CartPage';
import LoginPage from "./LoginPage/LoginPage";

export default () => (
    <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/products" element={<ProductsPage />} />
        <Route path="/products/create" element={<NewProductPage />} />
        <Route path="/products/:productId" element={<ProductPage />} />
        <Route path="/cart" element={<CartPage />} />
        <Route path="/login" element={<LoginPage />} />
    </Routes>
);
