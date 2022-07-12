import { ADD_VALUE } from './mathExampleModel';

export const add = (value) => (
    {
        type: ADD_VALUE,
        value,
    }
);
