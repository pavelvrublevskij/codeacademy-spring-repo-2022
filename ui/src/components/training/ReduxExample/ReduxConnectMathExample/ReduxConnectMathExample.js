import { Button } from 'react-bootstrap';

const ReduxConnectMathExample = ({
    matchExampleAdd,
    mathExampleObj,
    mathExampleValue,
}) => {

    const handleButtonClick = () => {
        matchExampleAdd(5);
    };

    return (
        <>
            <h1>ReduxConnectMathExample</h1>
            <h2>
                <pre>
                    {JSON.stringify(mathExampleObj)}
                </pre>
            </h2>
            <h3>{`mathExample props value ${mathExampleValue}`}</h3>
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

export default ReduxConnectMathExample;
