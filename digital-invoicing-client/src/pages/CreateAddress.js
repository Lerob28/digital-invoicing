import AddressForm from "../components/AddressForm";
import Header from "../components/Hearder";
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Card from "react-bootstrap/Card";

function CreateAddress() {
  return (
    <>
      <Header />
      <br />
      <div className="m-1 p-1">
        <div className="card">
          <div className="card-body">
            <h3> Create New Address </h3>
          </div>
        </div>
      </div>
      <br />
      <Container>
        <Row>
          <Col xs={6} md={1}></Col>
          <Col xs={6} md={10}>
            <Card className="bg-dark text-white">
              <Card.Body>
                <Card.Title>Add Address Form</Card.Title>
                  <AddressForm />
              </Card.Body>
            </Card>
          </Col>
        </Row>
      </Container>
    </>
  );
}

export default CreateAddress;
