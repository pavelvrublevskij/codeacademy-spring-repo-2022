import { ADD_TO_CART, REMOVE_FROM_CART } from './cartModel';

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
 *   ],
 *   totalPrice: number,
 * }
 */
const defaultState = {
    items: [],
    totalPrice: 0.00,
};

/**
 * state valdanti funkcija, reaguojanti į gautą action‘ą.
 */
const cartReducer = (state = defaultState, action) => {
    switch (action.type) {
        case ADD_TO_CART: {
            const {product} = action;
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

            return {
                ...state,
                items: newItems,
            }
        }
        case REMOVE_FROM_CART:
            return {
                ...state,
                items: state.items.filter(item => item.id !== action.productId),
            }
        default:
            return state;
    }
};

export default cartReducer;
