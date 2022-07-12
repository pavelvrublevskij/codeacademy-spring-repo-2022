import { configureStore } from '@reduxjs/toolkit';
import cartReducer from './Cart/cartReducer';
import mathExampleReducer from './MathExample/mathExampleReducer';

export default configureStore({
    reducer: {
        cart: cartReducer,
        mathExample: mathExampleReducer,
    }
})
