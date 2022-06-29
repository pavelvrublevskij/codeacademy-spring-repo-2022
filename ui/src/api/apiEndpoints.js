import HTTP from './axiosConfig';

const getProductsEndpoint = () =>
    HTTP.get("/products")
        .finally(response =>
            new Promise((resolve, reject) => {
                setTimeout(() => {
                    resolve(response);
                }, 2000);
            })
        )

const createProductEndpoint = (productData) => HTTP.post("/products", productData)

export {
    getProductsEndpoint
}
