import { createContext } from 'react';

const CartContext = createContext(null)

/**
 *
 * @type {{items: [
 *          {
 *             id: '',
 *             name: '',
 *             price: 0.00,
 *             itemCount?: 0,
 *          },
 *        ]
 * }}
 */
const initialCartObj = {
    items: [],
};

export {
    CartContext,
    initialCartObj,
}
