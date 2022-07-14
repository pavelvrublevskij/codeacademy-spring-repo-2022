import { saveToLocalStorage, StorageKey } from './localStorage';
import throttle from "lodash/throttle";

let prevCart = [];

export const createCartChangesSubscription = (store) => {
    /**
     * Creates a throttled function that only invokes func at most once per every wait milliseconds.
     * The throttled function comes with a cancel method to cancel delayed func invocations and a flush
     * method to immediately invoke them. Provide options to indicate whether func should be invoked on
     * the leading and/or trailing edge of the wait timeout. The func is invoked with the last arguments
     * provided to the throttled function. Subsequent calls to the throttled function return the result
     * of the last func invocation.
     * @see more at documentation: https://lodash.com/docs/#throttle
     */
   return throttle(() => {
        console.log("lodash throttle event!");
        const currentCart = store.getState().cart;

        if (prevCart !== currentCart) {
            prevCart = currentCart;
            saveToLocalStorage(StorageKey.cart, currentCart);
        }

        return currentCart;
        }, 3000
    );
};
