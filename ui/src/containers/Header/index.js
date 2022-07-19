import {
    Button,
    Container,
    Form,
    FormControl,
    Nav,
    Navbar,
    NavDropdown,
} from 'react-bootstrap';
import {Link, NavLink} from 'react-router-dom';
import { useSelector } from 'react-redux';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { solid } from '@fortawesome/fontawesome-svg-core/import.macro';
import { cartTotalItemsCountSelector } from '../../redux/Cart/cartSelector';
import {useTranslation} from "react-i18next";

const HeaderContainer = () => {

    const authUser = useSelector(state => state.user)

    const numberOfCartItems = useSelector(state => cartTotalItemsCountSelector(state))

    const {t, i18n} = useTranslation('header');

    return (
        <Navbar bg="light" expand="lg">
            <Container fluid>
                <Navbar.Brand to="/" as={NavLink}>
                    E-Shop
                </Navbar.Brand>
                <div>
                    <strong>{authUser.fullname}</strong>
                </div>
                <Navbar.Toggle aria-controls="navbarScroll" />
                <Navbar.Collapse id="navbarScroll">
                    <Nav
                        className="me-auto my-2 my-lg-0"
                        style={{ maxHeight: '100px' }}
                        navbarScroll
                    >
                        <Nav.Link to="/products" as={NavLink}>Products</Nav.Link>
                        <Nav>
                            <Nav.Link to="/currencies" as={NavLink}>
                                {t('currencies')}
                            </Nav.Link>
                        </Nav>
                        {authUser?.roles.includes("ROLE_ADMIN") &&
                            <>
                                <Nav.Link to="/products/create" as={NavLink}>New Product</Nav.Link>
                                <Nav.Link href="#" disabled>Users</Nav.Link>
                            </>
                        }
                    </Nav>
                    <Nav>
                        <Nav.Link to="/cart" as={NavLink}>
                            <Button type="button" className="btn btn-primary position-relative">
                                <FontAwesomeIcon className='position-relative' icon={solid('cart-shopping')}/>
                                <span className="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
                                    {numberOfCartItems}
                                </span>
                            </Button>
                        </Nav.Link>
                    </Nav>
                    <NavDropdown title="Languages" id="navbarScrollingDropdown" onSelect={(eventKey) => i18n.changeLanguage(eventKey)}>
                        <NavDropdown.Item eventKey="lt">LT</NavDropdown.Item>
                        <NavDropdown.Item eventKey="en">EN</NavDropdown.Item>
                    </NavDropdown>
                    <Form className="d-flex">
                        <FormControl
                            type="search"
                            placeholder="Search"
                            className="me-2"
                            aria-label="Search"
                        />
                        <Button variant="outline-success">Search</Button>
                    </Form>
                    {!authUser.username
                        ? <Nav.Link to="/login" as={NavLink}>
                            Login
                        </Nav.Link>
                        : <Nav.Link href="/login">
                            Logout
                        </Nav.Link>
                    }
                </Navbar.Collapse>
            </Container>
        </Navbar>
    );
}

export default HeaderContainer;
