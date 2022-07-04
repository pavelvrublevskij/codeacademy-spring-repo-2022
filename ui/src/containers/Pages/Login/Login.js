import { Form, Formik } from 'formik';

const Login = () => {

    const validate = (login) => {

        const errors = {}

        if (!login.email.includes("@")) {
            errors.email = "CIA NE EMAIL'AS!!!";
        }

        return errors
    }

    return (
        <Formik
            initialValues={{
                email: '',
            }}
            onSubmit={(login, helper) => {

                console.log('login', login);
            }}
            validate={validate}
        >
            {
                props => {
                    console.log('React formik props', props)

                    return (
                        <Form>
                            <div>
                                <label>Email</label>
                                <input name="email"
                                       onChange={props.handleChange}
                                       onBlur={props.handleBlur}
                                       value={props.values.name}
                                />
                                {
                                    props.errors.email && <span>{props.errors.email}</span>
                                }
                            </div>
                            <div>
                                <button type='submit'>Submit</button>
                            </div>
                        </Form>
                    )
                }
            }
        </Formik>
    );
};

export default Login;
