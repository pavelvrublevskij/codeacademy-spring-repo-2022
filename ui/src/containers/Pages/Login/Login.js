import { Field, Form, Formik } from 'formik';
import {
    Button,
    Container, Spinner,
} from 'react-bootstrap';
import FormikFieldInputGroup from '../../../components/Formik/FormikFieldInputGroup/FormikFieldInputGroup';
import * as Yup from 'yup';
import { loginEndpoint } from '../../../api/apiEndpoints';

const validationSchema = Yup.object().shape({
    email: Yup.string()
        .min(5, 'Ilgis turi buti ne mazesnis nei 5')
        .required()
        //.email()
        .matches(/^(.+)@(.+)$/, 'email neatitinka standarto'),
    password: Yup.string()
        .min(4, 'Slaptazodzio ilgis turi buti >= 4')
        .required(),
});

const Login = () => {

    const postLogin = (login, helper) => {
        loginEndpoint({
            username: login.email,
            password: login.password,
        }).then((response) =>
            console.log('login response', response),
        )
            .catch((error) => console.log(error))
            .finally(() => helper.setSubmitting(false));
    }

    return (
        <Formik
            initialValues={{
                email: '',
                password: '',
            }}
            onSubmit={postLogin}
            validationSchema={validationSchema}
        >
            {
                props => {
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
