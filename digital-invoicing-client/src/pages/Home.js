import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';


export default function Home() {
  return (
    <>
    <Navbar bg="dark" data-bs-theme="dark">
        <Container>
          <Navbar.Brand href="/">Digital Invoicing</Navbar.Brand>
          <Nav className="me-auto">
            <Nav.Link href="/">Home</Nav.Link>
            <NavDropdown title="Address">
                    <NavDropdown.Item href="/address/list">Address List</NavDropdown.Item>
                    <NavDropdown.Item href="/address/add"> Add Address</NavDropdown.Item>
                    <NavDropdown.Divider />
            </NavDropdown>
            <NavDropdown title="Customer">
                    <NavDropdown.Item href="/customer/list">Customer List</NavDropdown.Item>
                    <NavDropdown.Item href="/customer/add"> Add Customer</NavDropdown.Item>
                    <NavDropdown.Divider />
            </NavDropdown>
            <NavDropdown title="Invoice">
                    <NavDropdown.Item href="/invoice/list">Invoice List</NavDropdown.Item>
                    <NavDropdown.Item href="/invoice/add"> Add Invoice</NavDropdown.Item>
                    <NavDropdown.Divider />
            </NavDropdown>
          </Nav>
        </Container>
      </Navbar>
      <br />
     <div className="m-1 p-1">
        <div className="card">
          <div className="card-body">
            <h3> Welcome </h3>
          </div>
        </div>
      </div>
    </>
  );
}
