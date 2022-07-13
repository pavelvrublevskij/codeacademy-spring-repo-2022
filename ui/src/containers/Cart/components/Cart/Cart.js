import { Button, Container, Table } from 'react-bootstrap';
import './Cart.scss';

const Cart = ({
    cartItems,
    cartTotalItemsCount,
    cartTotalItemsPrice,
    removeFromCartByProductId,
}) => {

    const removeProductById = (id) =>
        removeFromCartByProductId(id);

    return (
        <Container fluid>
            <Table striped bordered hover>
                <thead>
                <tr>
                    <th>Product Name</th>
                    <th align='right'>Quantity</th>
                    <th align='right'>Unit Price (Eur)</th>
                    <th align='right'>Total Price (Eur)</th>
                    <th align='right'>Actions</th>
                </tr>
                </thead>
                <tbody>
                {
                    cartItems.length >= 0 &&
                    cartItems.map((item, index) => (
                        <tr key={index}>
                            <td>{item.name}</td>
                            <td align='right'>{item.itemCount}</td>
                            <td align='right'>{parseFloat(item.price).toFixed(2)}</td>
                            <td align='right'>{(item.price * item.itemCount).toFixed(2)}</td>
                            <td align='center'>
                                <Button type="button"
                                        className="btn btn-primary position-relative tableDeleteButton"
                                        onClick={() => removeProductById(item.id)}>
                                    Remove
                                </Button>
                            </td>
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
