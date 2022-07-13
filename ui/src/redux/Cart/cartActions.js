/**
 * Action & Action Creators
 */

import {
    ADD_TO_CART,
    REMOVE_FROM_CART
} from './cartModel';

/**
 *  funkcija, sukurianti action‘ą.
 */
export const addToCart = (product) => (
    /**
     * objektas, kuris perduodamas redux, pranešantis apie įvykį.
     */
    {
        type: ADD_TO_CART,
        product,
    }
);

export const removeFromCart = (productId) => ({
    type: REMOVE_FROM_CART,
    productId,
});


