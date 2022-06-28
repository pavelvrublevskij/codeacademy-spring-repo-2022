import { Route, Routes } from 'react-router-dom';
import HomePage from './HomePage/HomePage';
import NewProductPage from './NewProductPage/NewProductPage';
import ProductPage from './ProductPage/ProductPage';
import ProductsPage from './ProductsPage/ProductsPage';

export default () => (
    <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/products" element={<ProductsPage />} />
        <Route path="/products/create" element={<NewProductPage />} />
        <Route path="/products/:productId" element={<ProductPage />} />
    </Routes>
);
