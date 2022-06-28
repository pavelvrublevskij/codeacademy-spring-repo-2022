import { Form } from 'react-bootstrap';

const FormLabelControl = ({
    className,
    name,
    labelText,
    placeholderText,
    onChange,
}) => {
    return (
        <Form.Group className={className} controlId={name}>
            <Form.Label>{labelText}</Form.Label>
            <Form.Control placeholder={placeholderText}
                          name={name}
                          onChange={onChange} />
        </Form.Group>
    )
}

export default FormLabelControl;
