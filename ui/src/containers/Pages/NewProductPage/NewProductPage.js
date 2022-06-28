import { useState } from 'react';
import { Button, Container, Form } from 'react-bootstrap';

const NewProductPage = () => {
    const [product, setProduct] = useState({
        name: '',
        quantity: '',
        price: '',
        description: '',
    });

    const handleChange = (e) => {
        setProduct({
            ...product,
            [e.target.name]: e.target.value,
        });
    };

    const onSubmit = (e) => {
        e.preventDefault();

        console.log(product);
    };

    return (
        <Container>
            <Form onSubmit={onSubmit}>
                <Form.Group className='mb-3' controlId='name'>
                    <Form.Label>Product name</Form.Label>
                    <Form.Control placeholder='Write name'
                                  name="name"
                                  onChange={handleChange} />
                </Form.Group>

                <Form.Group className='mb-3' controlId='quantity'>
                    <Form.Label>Product quantity</Form.Label>
                    <Form.Control placeholder='Write quantity'
                                  name="quantity"
                                  onChange={handleChange} />
                </Form.Group>

                <Form.Group className='mb-3' controlId='price'>
                    <Form.Label>Product price</Form.Label>
                    <Form.Control placeholder='Write price'
                                  name="price"
                                  onChange={handleChange} />
                </Form.Group>

                <Form.Group className='mb-3' controlId='description'>
                    <Form.Label>Product description</Form.Label>
                    <Form.Control placeholder='Write description'
                                  name="description"
                                  as="textarea"
                                  onChange={handleChange} />
                </Form.Group>

                <Button variant='primary' type='submit'>
                    Submit
                </Button>
            </Form>
        </Container>
    );
};

export default NewProductPage;
