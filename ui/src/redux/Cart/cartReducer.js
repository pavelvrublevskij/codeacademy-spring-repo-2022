import { ADD_TO_CART } from './cartModel';

/**
 * cart state:
 * {
 *   items: [
 *     {
 *         id: number,
 *         name: string,
 *         price: number,
 *         itemCount?: number,
 *     },
 *     ...
 *   ]
 * }
 */
const defaultState = {
    items: [],
};

/**
 * state valdanti funkcija, reaguojanti į gautą action‘ą.
 */
const cartReducer = (state = defaultState, action) => {
    switch (action.type) {
        case ADD_TO_CART: {
            console.log('action payload from action creator', action.product);
            return {
                ...state,
                items: [
                    ...state.items,
                    {
                        ...action.product,
                        itemCount: 1,
                    },
                ],
            };
        }
        default:
            return state;
    }
};

export default cartReducer;
