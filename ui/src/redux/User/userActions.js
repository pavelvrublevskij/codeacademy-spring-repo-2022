import { LOGIN } from './userModel';

export const setLogin = (user) => ({
    type: LOGIN,
    user
})
