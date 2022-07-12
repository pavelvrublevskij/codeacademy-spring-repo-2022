import Cart from './Cart';
import { connect } from 'react-redux';
import { cartItemsSelector } from '../../../../redux/Cart/cartSelector';

const mapStateToProps = state => {
    return {
        cartItems: cartItemsSelector(state),
    }
}

export default connect(mapStateToProps, null)(Cart)
