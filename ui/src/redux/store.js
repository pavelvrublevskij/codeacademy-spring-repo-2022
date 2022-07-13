import { configureStore } from '@reduxjs/toolkit';
import cartReducer from './Cart/cartReducer';
import mathExampleReducer from './MathExample/mathExampleReducer';
import { loadFromLocalStorage, saveToLocalStorage, StorageKey } from '../utils/localStorage';
import { subscribeToCartChanges } from '../utils/CartLocalStore';

const preloadedState = () => ({
    cart: loadFromLocalStorage(StorageKey.cart) || undefined
})


export default configureStore({
    reducer: {
        cart: cartReducer,
        mathExample: mathExampleReducer,
    },
    preloadedState: preloadedState(),
})

/*const constructStore = () => {
  const store = configureStore({
      reducer: {
          cart: cartReducer,
          mathExample: mathExampleReducer,
      },
      preloadedState: preloadedState(),
  });

  subscribeCart(store);

  return store
}

const subscribeCart = store => {
    store.subscribe(() => subscribeToCartChanges(store.getState().cart))
}

export default constructStore*/
