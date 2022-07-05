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

/**
 * i.e. loginData:
 * {
 *     username: string;
 *     password: string;
 * }
 * @param loginData
 * @returns {Promise<AxiosResponse<any>>}
 */
const loginEndpoint = (loginData) => HTTP.post("/login", loginData)

export {
    getProductsEndpoint,
    createProductEndpoint,
    loginEndpoint,
}
