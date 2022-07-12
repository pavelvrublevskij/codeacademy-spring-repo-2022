
export const cartItemsSelector = state => state.cart.items;

// export const cartTotalPriceSelector = state => {
//     return state.cart.items
//         .map(item => item.price * item.itemCount)
//         .reduce((total, newValue) => total + newValue, 0)
// }
export const cartTotalPriceSelector = state => state.cart.totalPrice;
