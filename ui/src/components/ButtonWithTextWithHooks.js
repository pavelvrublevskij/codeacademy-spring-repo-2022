import {useState} from "react";

export default (props) => {

    const [counter, setCounter] = useState(0)

    const count = () => setCounter(prevCounter => prevCounter + 1)

    return (
        <>
            <span>{counter ? counter : props.text }</span>
            <button onClick={count}>Paspausk</button>
        </>
    )
}