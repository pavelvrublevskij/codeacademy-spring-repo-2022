import { useState } from 'react';
import { Button, Container, Form } from 'react-bootstrap';
import FormLabelControl from '../../../components/Form/FormLabelControl/FormLabelControl';

const NewProductPage = () => {
    const [product, setProduct] = useState({
        name: '',
        quantity: '',
        price: '',
        description: '',
    });
    const [visible, setVisible] = useState(false);

    const handleChange = (e) => {
        setProduct({
            ...product,
            [e.target.name]: e.target.value,
        });
    };

    const onSubmit = (e) => {
        e.preventDefault();

        console.log(product);

        setVisible(true);
    };

    return (
        <Container>
            <Form onSubmit={onSubmit}>
                <FormLabelControl
                    className="mb-3"
                    onChange={handleChange}
                    placeholderText="Write name"
                    name="name"
                    labelText="Product name"
                />

                <FormLabelControl
                    className="mb-3"
                    onChange={handleChange}
                    placeholderText="Write quantity"
                    name="quantity"
                    labelText="Product quantity"
                />

                <FormLabelControl
                    className="mb-3"
                    onChange={handleChange}
                    placeholderText="Write price"
                    name="price"
                    labelText="Product price"
                />

                <FormLabelControl
                    className="mb-3"
                    onChange={handleChange}
                    placeholderText="Write description"
                    name="description"
                    labelText="Product description"
                    isTextArea
                />

                <Button variant='primary' type='submit'>
                    Submit
                </Button>
            </Form>
            { visible &&
                <>
                    <hr/>
                    <div>
                        Sukurtas produkas:
                        <div>{product.name}</div>
                        <div>{product.quantity}</div>
                        <div>{product.price}</div>
                        <div>{product.description}</div>
                    </div>
                </>
            }
        </Container>
    );
};

export default NewProductPage;
