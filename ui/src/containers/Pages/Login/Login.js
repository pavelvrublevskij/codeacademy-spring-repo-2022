import { Field, Form, Formik } from 'formik';
import {
    Button,
    Container, Spinner,
} from 'react-bootstrap';
import FormikFieldInputGroup from '../../../components/Formik/FormikFieldInputGroup/FormikFieldInputGroup';

const Login = () => {

    const validate = (login) => {

        const errors = {}

        if (!login.email.includes("@")) {
            errors.email = "CIA NE EMAIL'AS!!!";
        }

        if (login.password.length < 6 ) {
            errors.password = "Slaptazodzio ilgis turi buti >= 6"
        }

        return errors
    }

    return (
        <Formik
            initialValues={{
                email: '',
                password: '',
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
                            <Form>
                                <Field name='email'
                                       labelText='Email:'
                                       type='text'
                                       component={FormikFieldInputGroup} />
                                <Field name='password'
                                       labelText='Password:'
                                       type='password'
                                       component={FormikFieldInputGroup} />

                                <div className="text-center">
                                    {props.isSubmitting
                                        ? <Button variant='primary' disabled>
                                            <Spinner
                                                as='span'
                                                animation='grow'
                                                size='sm'
                                                role='status'
                                                aria-hidden='true'
                                            />
                                            Processing...
                                        </Button>
                                        :  <Button type='submit'
                                                   variant='primary'>
                                                Submit
                                           </Button>
                                    }
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
