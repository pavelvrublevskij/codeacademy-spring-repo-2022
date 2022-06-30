import {useState} from "react";

const Login = () => {

    const [login, setLogin] = useState({
        email: ''
    })

    const onSubmit = (e) => {
        e.preventDefault()

        console.log("login", login)
    }

    const onChange = (e) => {
        setLogin({
            email: e.target.value
        })
    }

    return (
        <form onSubmit={onSubmit}>
            <label>Email</label>
            <input name="email" value={login.email} onChange={onChange}/>
            <button type="submit">Submit</button>
        </form>
    )
}

export default Login