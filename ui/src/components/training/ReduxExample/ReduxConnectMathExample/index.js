import ReduxConnectMathExample from './ReduxConnectMathExample';
import { connect } from 'react-redux';
import { add } from '../../../../redux/MathExample/mathExampleActions';
import { mathExampleObjSelector, mathExampleValueSelector } from '../../../../redux/MathExample/mathExampleSelector';

const mapStateToProps = state => {
    return {
        mathExampleObj: mathExampleObjSelector(state),
        // mathExampleValue: mathExampleObjSelector.value,
        mathExampleValue: mathExampleValueSelector(state),
    }
}

const mapDispatchToProps = {
    matchExampleAdd: add
}

export default connect(mapStateToProps, mapDispatchToProps)(ReduxConnectMathExample)
