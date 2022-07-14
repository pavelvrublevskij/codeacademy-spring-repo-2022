import {createSlice} from "@reduxjs/toolkit";

const defaultState = {
    items: [],
    totalPrice: 0.00
};

const cartSlice = createSlice({
    name: "cart",
    initialState: defaultState,
    reducers: {
        addToCart(state, { payload: product }) {
            let itemFound = false;
            let newItems = [...state.items];

            newItems = newItems.map(item => {
                if (item.id === product.id) {
                    itemFound = true;

                    return {
                        ...item,
                        itemCount: item.itemCount + 1,
                    }
                }

                return item;
            })

            if (!itemFound) {
                newItems = [
                    ...newItems,
                    {...product, itemCount: 1},
                ];
            }

            const cartLocalStorageObj = {
                ...state,
                items: newItems,
            }

            return cartLocalStorageObj
        },
        removeFromCart(state, { payload: productId }) {
            debugger
            return {
                ...state,
                items: state.items.filter(item => item.id !== productId),
            }
        },

    }
})

export default cartSlice.reducer
export const { addToCart, removeFromCart } = cartSlice.actions