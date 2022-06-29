import { getProductsEndpoint } from '../../../api/apiEndpoints';
import { useEffect, useState } from 'react';
import { Card, Col, Container, Row, Spinner } from 'react-bootstrap';

const ProductsPage = () => {

    const [productItems, setProductItems] = useState([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        getProductsEndpoint()
            .then(({ data }) => {
                setProductItems(data.products);
            })
            .catch((error) => console.log('error', error))
            .finally(() => setLoading(false));
    }, []);

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
