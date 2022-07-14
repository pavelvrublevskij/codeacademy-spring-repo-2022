import { Form, InputGroup } from 'react-bootstrap';
import {useTranslation} from "react-i18next";

const FormikFieldInputGroup = ({
    field,
    form,
    labelText,
    type
}) => {
    const isValid = !form.errors[field.name];
    const isInvalid = form.touched[field.name] && !isValid;

    const { t: validationsT } = useTranslation("validations")

    return (
        <Form.Group controlId={field.name}>
            <Form.Label>{labelText}</Form.Label>
            <InputGroup>
                <Form.Control
                    type={type}
                    name={field.name}
                    isValid={form.touched[field.name] && isValid}
                    isInvalid={isInvalid}
                    feedback={form.errors[field.name]}
                    onChange={field.onChange}
                />

                {form.errors[field.name] &&
                    <Form.Control.Feedback type="invalid">
                        {form.errors[field.name] instanceof String ?
                            validationsT(form.errors[field.name]) :
                            validationsT(form.errors[field.name].key, {label: form.errors[field.name].label})}
                    </Form.Control.Feedback>
                }
            </InputGroup>
        </Form.Group>
    );
}

export default FormikFieldInputGroup;
