import { useParams } from 'react-router-dom';

const ProductPage = () => {
    const { productId } = useParams();  // destruct param path name from url

    return <h1>Produkto id: { productId }</h1>
}

export default ProductPage;
