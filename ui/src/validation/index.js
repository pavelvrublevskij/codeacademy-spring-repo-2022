import * as yup from "yup";

yup.setLocale({
    mixed: {
        default: "default",
        required: (props) => ({ key: "required", label: props.label })
    },
})

export default yup