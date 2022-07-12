import { ADD_VALUE } from './mathExampleModel';

const defaultState = {
    otherValue: 89,
    value: 1,
}

const mathExampleReducer = (state = defaultState, action) => {
    switch (action.type) {
        case ADD_VALUE: {
            return {
                ...state,
                value: state.value + action.value
            }
        }
        default:
            return state
    }
}

export default mathExampleReducer
