import { Field, Form, Formik } from 'formik';
import {
    Button,
    Container, Spinner,
} from 'react-bootstrap';
import FormikFieldInputGroup from '../../../components/Formik/FormikFieldInputGroup/FormikFieldInputGroup';
import * as Yup from 'yup';

const validationSchema = Yup.object().shape({
    email: Yup.string()
        .min(5, 'Ilgis turi buti ne mazesnis nei 5')
        .required()
        //.email()
        .matches(/^(.+)@(.+)$/, 'email neatitinka standarto'),
    password: Yup.string()
        .min(6, 'Slaptazodzio ilgis turi buti >= 6')
        .required(),
});

const Login = () => {
    return (
        <Formik
            initialValues={{
                email: '',
                password: '',
            }}
            onSubmit={(login, helper) => {

                console.log('login', login);
            }}
            validationSchema={validationSchema}
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
