import { Field, Form, Formik } from 'formik';
import {
    Button,
    Container, Spinner,
} from 'react-bootstrap';
import FormikFieldInputGroup from '../../../components/Formik/FormikFieldInputGroup/FormikFieldInputGroup';
import { loginEndpoint } from '../../../api/apiEndpoints';
import { useNavigate } from 'react-router-dom';
import { useDispatch } from 'react-redux';
import { setLogin } from '../../../redux/User/userActions';
import {useTranslation} from "react-i18next";
import Yup from "../../../validation"

const validationSchema = Yup.object().shape({
    email: Yup.string()
        .min(5)
        .required()
        .matches(/^(.+)@(.+)$/)
        .label("login:labels.email"),
    password: Yup.string()
        .min(4)
        .required()
        .label("login:labels.password"),
});

const LoginPage = () => {

    const navigate = useNavigate()
    const { t } = useTranslation()
    const dispatch = useDispatch()

    const postLogin = (login, helper) => {
        loginEndpoint({
            username: login.email,
            password: login.password,
        }).then(({ data }) => {
            dispatch(
                setLogin(data)
            )
            navigate("/")
        })
        .catch((error) => console.log(error))
        .finally(() => helper.setSubmitting(false))
    };

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
                props =>
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

                            <div className='text-center'>
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
                                    : <Button type='submit'
                                              variant='primary'>
                                        {t("buttons.submit")}
                                    </Button>
                                }
                            </div>
                        </Form>
                    </Container>
            }
        </Formik>
    );
};

export default LoginPage;
