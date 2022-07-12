/**
 * Action & Action Creators
 */

import { ADD_TO_CART } from './cartModel';

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


