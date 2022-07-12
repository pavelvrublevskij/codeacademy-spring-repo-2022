import { Container, Table } from 'react-bootstrap';

const Cart = ({cartItems}) => {
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
                            <td align='right'>{item.price}</td>
                            <td align='right'>{item.price * item.itemCount}</td>
                        </tr>
                    ))
                }
                </tbody>
            </Table>
        </Container>
    );
}

export default Cart
