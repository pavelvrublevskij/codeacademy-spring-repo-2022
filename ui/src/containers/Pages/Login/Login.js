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
                                <Field name="email">
                                    {({ field, form }) => {  // form -> Field form props
                                        const isValid = !form.errors[field.name];
                                        const isInvalid = form.touched[field.name] && !isValid;
                                        return (
                                            <BootstrapForm.Group controlId={field.name}>
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
                                <Field name="password">
                                    {({ field, form }) => {  // form -> Field form props
                                        const isValid = !form.errors[field.name];
                                        const isInvalid = form.touched[field.name] && !isValid;
                                        return (
                                            <BootstrapForm.Group controlId={field.name}>
                                                <BootstrapForm.Label>Password:</BootstrapForm.Label>
                                                <InputGroup>
                                                    <BootstrapForm.Control
                                                        type='password'
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
