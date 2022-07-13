import { saveToLocalStorage, StorageKey } from './localStorage';

let prevCart = []

export const subscribeToCartChanges = (cart) => {
    const currentCart = cart

    if (prevCart !== currentCart) {
        prevCart = currentCart
        saveToLocalStorage(StorageKey.cart, currentCart)
    }

    return currentCart
}
