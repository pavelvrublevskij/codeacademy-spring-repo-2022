import Cart from './Cart';
import { connect } from 'react-redux';
import {
    cartItemsSelector,
    cartTotalItemsCountSelector, cartTotalItemsPriceSelector,
} from '../../../../redux/Cart/cartSelector';

const mapStateToProps = state => {
    return {
        cartItems: cartItemsSelector(state),
        cartTotalItemsCount: cartTotalItemsCountSelector(state),
        cartTotalItemsPrice: cartTotalItemsPriceSelector(state),
    }
}

export default connect(mapStateToProps, null)(Cart)
