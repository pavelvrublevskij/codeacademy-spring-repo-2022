import {
    Button,
    Container,
    Form,
    FormControl,
    Nav,
    Navbar,
    NavDropdown,
} from 'react-bootstrap';
import { NavLink } from 'react-router-dom';

const HeaderContainer = () => (
    <Navbar bg="light" expand="lg">
        <Container fluid>
            <Navbar.Brand to="/" as={NavLink}>
                E-Shop
            </Navbar.Brand>
            <Navbar.Toggle aria-controls="navbarScroll" />
            <Navbar.Collapse id="navbarScroll">
                <Nav
                    className="me-auto my-2 my-lg-0"
                    style={{ maxHeight: '100px' }}
                    navbarScroll
                >
                    <Nav.Link to="/products" as={NavLink}>Products</Nav.Link>
                    <Nav.Link to="/products/create" as={NavLink}>New Product</Nav.Link>
                    <Nav.Link href="#" disabled>Users</Nav.Link>
                </Nav>
                <Nav>
                    <Nav.Link to="/cart" as={NavLink}>Cart</Nav.Link>
                </Nav>
                <NavDropdown title="Languages" id="navbarScrollingDropdown">
                    <NavDropdown.Item href="#action3">LT</NavDropdown.Item>
                    <NavDropdown.Item href="#action4">EN</NavDropdown.Item>
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
                <Nav.Link href="#" disabled>
                    Login
                </Nav.Link>
            </Navbar.Collapse>
        </Container>
    </Navbar>
);

export default HeaderContainer;
