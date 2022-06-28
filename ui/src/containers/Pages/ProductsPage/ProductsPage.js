import { getProductsApi } from '../../../api/apiEndpoints';
import { useEffect } from 'react';

const ProductsPage = () => {

    useEffect(() => {
        getProductsApi()
            .then((response) => console.log('response', response))
            .catch((error) => console.log('error', error))
    })

    return (
        <>
            <h1>Product list</h1>
        </>
    )
}

export default ProductsPage;
