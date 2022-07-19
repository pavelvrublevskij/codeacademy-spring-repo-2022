import HTTP from './axiosConfig';

const fetchCurrencies = () => HTTP.get('/currencies');

export {fetchCurrencies}
