import { connect } from 'react-redux';
import ProductsPage from './ProductsPage';
import {addToCart} from "../../../redux/Cart/cartSlice";

/**
 * ____DA - Dispatcher action
 */
const mapDispatchToProps = {
    addToCartDA: addToCart,
}

export default connect(null, mapDispatchToProps)(ProductsPage)
