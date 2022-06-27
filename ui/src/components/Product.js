import { useState } from 'react';

const Product = () => {
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
        <form onSubmit={onSubmit}>
            <div>
                <label htmlFor="name">Name:</label>
                <input
                    name="name"
                    id="name"
                    value={product.name}
                    onChange={handleChange}
                />
            </div>

            <div>
                <label htmlFor="quantity">Quantity:</label>
                <input
                    name="quantity"
                    id="quantity"
                    value={product.quantity}
                    onChange={handleChange}
                />
            </div>

            <div>
                <label htmlFor="price">Price:</label>
                <input
                    name="price"
                    id="price"
                    value={product.price}
                    onChange={handleChange}
                />
            </div>

            <div>
                <label htmlFor="description">Description:</label>
                <textarea
                    name="description"
                    id="description"
                    value={product.description}
                    onChange={handleChange}
                />
            </div>

            <button type="submit">Submit</button>
        </form>
    );
};

export default Product;
