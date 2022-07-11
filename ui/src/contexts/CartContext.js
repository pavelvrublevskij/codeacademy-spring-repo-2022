import { createContext } from 'react';
import { loadFromSessionStorage, StorageKey } from '../utils/sessionStorage';

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
 *        ],
 * }}
 */
const initialCartObj = loadFromSessionStorage(StorageKey.cart) || {items: []};

export {
    CartContext,
    initialCartObj,
}
