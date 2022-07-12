import Cart from './Cart';
import { connect } from 'react-redux';
import { cartItemsSelector, cartTotalPriceSelector } from '../../../../redux/Cart/cartSelector';

const mapStateToProps = state => {
    return {
        cartItems: cartItemsSelector(state),
        cartTotalPrice: cartTotalPriceSelector(state),
    }
}

export default connect(mapStateToProps, null)(Cart)
