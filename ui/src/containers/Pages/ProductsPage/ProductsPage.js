import { getProductsEndpoint } from '../../../api/apiEndpoints';
import { useContext, useEffect, useState } from 'react';
import { Button, Card, Col, Container, Row, Spinner } from 'react-bootstrap';
import { CartContext } from '../../../contexts/CartContext';

const ProductsPage = () => {

    const [productItems, setProductItems] = useState([]);
    const [loading, setLoading] = useState(true);
    const { addCartProduct } = useContext(CartContext)

    useEffect(() => {
        getProductsEndpoint()
            .then(({ data }) => {
                setProductItems(data.products);
            })
            .catch((error) => console.log('error', error))
            .finally(() => setLoading(false));
    }, []);

    const handleAddProductToCart = (product) => {
        addCartProduct({
                id: product.productId,
                name: product.name,
                price: product.price,
            })
    }

    return (
        <Container fluid>
            <h1 className={'text-center'}>Product list</h1>
            <Row xs={1} md={2} className='g-4'>
                {loading
                    ? <Spinner className="text-center" animation='border' />
                    : productItems.map(product => (
                        <Col key={product.productId}>
                            <Card>
                                <Card.Header>
                                    <div className='d-flex justify-content-around'>
                                        <div>{product.price} Eur</div>
                                        <div>{product.quantity} available</div>
                                    </div>
                                </Card.Header>
                                <Card.Body>
                                    <Card.Title>{product.name}</Card.Title>
                                    <Card.Text>{product.description}</Card.Text>
                                    <Button onClick={() => handleAddProductToCart(product)}>
                                        Buy
                                    </Button>
                                </Card.Body>
                            </Card>
                        </Col>
                    ))
                }
            </Row>
        </Container>
    );
};

export default ProductsPage;
