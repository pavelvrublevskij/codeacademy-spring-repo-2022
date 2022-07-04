import { ErrorMessage, Field, Form, Formik } from 'formik';
import {
    Button,
    Container,
    Form as BootstrapForm,
    InputGroup,
} from 'react-bootstrap';

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
                            <Form>
                                <Field name="email">
                                    {({ field, form }) => {  // form -> Field form props

                                        console.log('field', field)
                                        console.log('form', form)

                                        const isValid = !form.errors[field.name];
                                        const isInvalid = form.touched[field.name] && !isValid;
                                        return (
                                            <BootstrapForm.Group controlId='email'>
                                                <BootstrapForm.Label>Email:</BootstrapForm.Label>
                                                <InputGroup>
                                                    <BootstrapForm.Control
                                                        type='text'
                                                        name={field.name}
                                                        isValid={form.touched[field.name] && isValid}
                                                        isInvalid={isInvalid}
                                                        feedback={form.errors[field.name]}
                                                        onChange={field.onChange}
                                                    />
                                                    <BootstrapForm.Control.Feedback type="invalid">
                                                        {form.errors[field.name]}
                                                    </BootstrapForm.Control.Feedback>
                                                </InputGroup>
                                            </BootstrapForm.Group>
                                        );
                                    }}
                                </Field>
                                <div>
                                    <Button type='submit'>Submit</Button>
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
