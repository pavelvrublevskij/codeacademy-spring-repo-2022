import { Container, Table } from 'react-bootstrap';

const initialCartItems = {
    items: [
        {
            id: '9b4018ac-bac2-4afe-8ac6-055612ba9d40',
            name: 'Big Mac',
            quantity: 2,
            price: 5.00,
            totalPrice: 10.00,
        },
        {
            id: '9b4018ac-bac2-4afe-8ac6-055612ba9d41',
            name: 'Big Big',
            quantity: 1,
            price: 5.00,
            totalPrice: 5.00,
        },
    ],
};

const CartContainer = () => {
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
                        initialCartItems.items.map((item) => (
                            <tr key={item.id}>
                                <td>{item.name}</td>
                                <td align='right'>{item.quantity}</td>
                                <td align='right'>{item.price}</td>
                                <td align='right'>{item.totalPrice}</td>
                            </tr>
                        ))
                    }
                </tbody>
            </Table>
        </Container>
    );
};

export default CartContainer;
