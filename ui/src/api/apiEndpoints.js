import HTTP from './axiosConfig';

const getProductsApi = () => HTTP.get("/products")

const createProductApi = (productData) => HTTP.post("/products", productData)

export {
    getProductsApi
}
