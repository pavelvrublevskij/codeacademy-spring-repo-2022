import HTTP from './axiosConfig';

const getProducts = () => HTTP.get("/products")

const createProduct = (productData) => HTTP.post("/products", productData)
