import { ErrorMessage, Field, Form, Formik } from 'formik';
import { Container, Form as BootstrapForm} from 'react-bootstrap';

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
                        <Container>
                            <Form component={BootstrapForm}>
                                <div>
                                    <label>Email</label>
                                    <Field name='email'  />
                                    <ErrorMessage name='email' style={{color: 'red'}} component={'div'}/>
                                </div>
                                <div>
                                    <button type='submit'>Submit</button>
                                </div>
                            </Form>
                        </Container>
                    )
                }
            }
        </Formik>
    );
};

export default Login;
