import { getProductsApi } from '../../../api/apiEndpoints';
import { useEffect, useState } from 'react';
import { Card, Col, Container, Row } from 'react-bootstrap';

const ProductsPage = () => {

    const [productItems, setProductItems] = useState([])

    useEffect(() => {
        getProductsApi()
            .then(({data}) => {
                setProductItems(data.products)
            })
            .catch((error) => console.log('error', error))
    }, [])

    return (
        <Container fluid>
            <h1 className={"text-center"}>Product list</h1>
            <Row xs={1} md={2} className="g-4">
                {productItems.map(product => (
                    <Col key={product.productId}>
                        <Card>
                            <Card.Header>
                                <div className="d-flex justify-content-around">
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
                ))}
            </Row>
        </Container>
    )
}

export default ProductsPage;
