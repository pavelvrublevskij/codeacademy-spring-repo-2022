import HTTP from './axiosConfig';

const getProductsApi = () =>
    HTTP.get("/products")
        .finally(response =>
            new Promise((resolve, reject) => {
                setTimeout(() => {
                    resolve(response);
                }, 2000);
            })
        )

const createProductApi = (productData) => HTTP.post("/products", productData)

export {
    getProductsApi
}
