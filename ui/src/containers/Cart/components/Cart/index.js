import Cart from './Cart';
import { connect } from 'react-redux';
import {
    cartItemsSelector,
    cartTotalItemsCountSelector,
    cartTotalItemsPriceSelector,
} from '../../../../redux/Cart/cartSelector';
import {removeFromCart} from "../../../../redux/Cart/cartSlice";

const mapStateToProps = state => {
    return {
        cartItems: cartItemsSelector(state),
        cartTotalItemsCount: cartTotalItemsCountSelector(state),
        cartTotalItemsPrice: cartTotalItemsPriceSelector(state),
    }
}

const mapDispatchToProps = {
    removeFromCartByProductId: removeFromCart,
}

export default connect(mapStateToProps, mapDispatchToProps)(Cart)
