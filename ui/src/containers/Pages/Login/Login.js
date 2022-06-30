import {useState} from "react";

const Login = () => {

    const [login, setLogin] = useState({
        email: ''
    })

    const [errors, setErrors] = useState({
        email: ''
    })

    const onSubmit = (e) => {
        e.preventDefault()

        console.log("login", login)
    }

    const onChange = (e) => {
        const email = e.target.value

        const errMessage = validateEmail(email)

        setErrors({
            email: errMessage
        })

        setLogin({
            email
        })
    }

    const validateEmail = (email) => {

        if (!email.includes("@")) {
            return "CIA NE EMAIL'AS!!!";
        }

        return ''
    }

    return (
        <form onSubmit={onSubmit}>
            <div>
                <label>Email</label>
                <input name="email" value={login.email} onChange={onChange}/>
                {
                    errors.email && <span color="red">{errors.email}</span>
                }
            </div>

            <div>
                <button type="submit">Submit</button>
            </div>
        </form>
    )
}

export default Login