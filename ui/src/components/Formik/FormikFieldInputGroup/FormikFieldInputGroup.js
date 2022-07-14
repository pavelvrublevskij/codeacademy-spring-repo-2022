import { Form, InputGroup } from 'react-bootstrap';
import {useTranslation} from "react-i18next";

const FormikFieldInputGroup = ({
    field,
    form: { errors, touched },
    labelText,
    type
}) => {

    const fieldError = errors[field.name]
    const fieldTouched = touched[field.name]

    const isValid = !fieldError;
    const isInvalid = fieldTouched && !isValid;

    const { t: validationsT } = useTranslation("validations")

    return (
        <Form.Group controlId={field.name}>
            <Form.Label>{labelText}</Form.Label>
            <InputGroup>
                <Form.Control
                    type={type}
                    name={field.name}
                    isValid={fieldTouched && isValid}
                    isInvalid={isInvalid}
                    feedback={fieldError}
                    onChange={field.onChange}
                />

                {fieldError &&
                    <Form.Control.Feedback type="invalid">
                        {fieldError instanceof String ?
                            validationsT(fieldError) :
                            validationsT(fieldError.key, {label: fieldError.label})}
                    </Form.Control.Feedback>
                }
            </InputGroup>
        </Form.Group>
    );
}

export default FormikFieldInputGroup;
