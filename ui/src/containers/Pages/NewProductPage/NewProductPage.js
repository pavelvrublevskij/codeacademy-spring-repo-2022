import { useState } from 'react';
import { Button, Container, Form } from 'react-bootstrap';
import FormLabelControl from '../../../components/Form/FormLabelControl/FormLabelControl';
import { createProductEndpoint } from '../../../api/apiEndpoints';
import { useTranslation } from "react-i18next";

const NewProductPage = () => {
    const [product, setProduct] = useState({
        name: '',
        quantity: '',
        price: '',
        description: '',
    });
    const [visible, setVisible] = useState(false);

    const { t } = useTranslation("productForm")

    const handleChange = (e) => {
        setProduct({
            ...product,
            [e.target.name]: e.target.value,
        });
    };

    const onSubmit = (e) => {
        e.preventDefault();

        createProductEndpoint(product)
            .then((response) => setVisible(true))

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
                    placeholderText={t("placeholders.name")}
                    name="name"
                    labelText={t("labels.name")}
                />

                <FormLabelControl
                    className="mb-3"
                    onChange={handleChange}
                    placeholderText={t("placeholders.quantity")}
                    name="quantity"
                    labelText={t("labels.quantity")}
                />

                <FormLabelControl
                    className="mb-3"
                    onChange={handleChange}
                    placeholderText={t("placeholders.price")}
                    name="price"
                    labelText={t("labels.price")}
                />

                <FormLabelControl
                    className="mb-3"
                    onChange={handleChange}
                    placeholderText={t("placeholders.description")}
                    name="description"
                    labelText={t("labels.description")}
                    isTextArea
                />

                <Button variant='primary' type='submit'>
                    {t("common:buttons.submit")}
                </Button>
            </Form>
            { showCreatedProductInfo() }
        </Container>
    );
};

export default NewProductPage;
