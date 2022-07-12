import { useDispatch, useSelector } from 'react-redux';
import { Button, Container } from 'react-bootstrap';
import { add } from '../../../redux/MathExample/mathExampleActions';

const ReduxHookMathExample = () => {

    const dispatch = useDispatch();
    const mathValueObj = useSelector(state => state.mathExample)

    const handleButtonClick = () => {
        dispatch(add(5));
    };

    return (
        <>
            <h1>ReduxHookMathExample</h1>
            <h2><pre>
                {JSON.stringify(mathValueObj)}
            </pre></h2>
            <div className='container'>
                <div className='row'>
                    <div className='col text-center'>
                        <Button onClick={handleButtonClick}>
                            Add 1
                        </Button>
                    </div>
                </div>
            </div>
        </>
    );
};

export default ReduxHookMathExample;
