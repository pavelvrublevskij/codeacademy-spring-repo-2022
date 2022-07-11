import { configureStore } from '@reduxjs/toolkit';
import cartReducer from './Cart/cartReducer';

export default configureStore({
    reducer: {
        cart: cartReducer,
    }
})
