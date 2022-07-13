
export const cartItemsSelector = state => state.cart.items;

export const cartTotalItemsCountSelector = state =>
    state.cart.items
        .map(item => item.itemCount)
        .reduce((total, newValue) => total + newValue, 0);

export const cartTotalItemsPriceSelector = state =>
    state.cart.items
        .map(item => item.price * item.itemCount)
        .reduce((total, newValue) => total + newValue, 0);
