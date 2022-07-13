import { Container, Table } from 'react-bootstrap';
import './Cart.scss';

const Cart = ({cartItems, cartTotalItemsCount, cartTotalItemsPrice}) => {
    return (
        <Container fluid>
            <Table striped bordered hover>
                <thead>
                <tr>
                    <th>Product Name</th>
                    <th align='right'>Quantity</th>
                    <th align='right'>Unit Price (Eur)</th>
                    <th align='right'>Total Price (Eur)</th>
                </tr>
                </thead>
                <tbody>
                {
                    cartItems.length >= 0 &&
                    cartItems.map(item => (
                        <tr key={item.id}>
                            <td>{item.name}</td>
                            <td align='right'>{item.itemCount}</td>
                            <td align='right'>{parseFloat(item.price).toFixed(2)}</td>
                            <td align='right'>{(item.price * item.itemCount).toFixed(2)}</td>
                        </tr>
                    ))
                }
                </tbody>
                <tfoot>
                    <tr className='cart_footer'>
                        <td align='right'>Total:</td>
                        <td align='right'>{cartTotalItemsCount}</td>
                        <td align='right' colSpan={2}>{cartTotalItemsPrice}</td>
                    </tr>
                </tfoot>
            </Table>
        </Container>
    );
}

export default Cart
