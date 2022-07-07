import {useTranslation} from "react-i18next";

const HomePage = () => {

    const { t } = useTranslation()

    return (
        <>
            <h1>This is Home Page</h1>
            <h2>{t("hello")}</h2>
            <h2>{t("hello", { lng: "lt" })}</h2>
        </>
    );
}

export default HomePage;
