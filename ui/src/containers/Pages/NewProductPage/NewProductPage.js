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

    const showCreatedProductInfo = () => {
        const {name, quantity, price, description} = product;
        return visible &&
            <>
                <hr/>
                <div>
                    Sukurtas produkas:
                    <div>{name}</div>
                    <div>{quantity}</div>
                    <div>{price}</div>
                    <div>{description}</div>
                </div>
            </>;
    }

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
            { showCreatedProductInfo() }
        </Container>
    );
};

export default NewProductPage;
